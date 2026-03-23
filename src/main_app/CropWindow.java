package main_app;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class CropWindow extends JDialog {
    private BufferedImage image;
    private Rectangle selection;
    private Point startPoint;
    private Profileform parent;

    public CropWindow(Profileform parent, BufferedImage img) {
        this.image = img;
        this.parent = parent;
        setModal(true);
        setTitle("Drag to Select Profile Area");
        setSize(900, 700);
        setLocationRelativeTo(parent);

        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                
                // Draw the original image
                g2.drawImage(image, 0, 0, null);
                
                if (selection != null) {
                    // Dim the unselected area
                    Area outer = new Area(new Rectangle(0, 0, getWidth(), getHeight()));
                    outer.subtract(new Area(selection));
                    g2.setColor(new Color(0, 0, 0, 150));
                    g2.fill(outer);

                    // Draw the selection border
                    g2.setColor(Color.CYAN);
                    g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, new float[]{10, 5}, 0));
                    g2.draw(selection);
                }
                g2.dispose();
            }
        };

        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                startPoint = e.getPoint();
                selection = new Rectangle(startPoint);
            }
        });

        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int width = Math.abs(e.getX() - startPoint.x);
                int height = Math.abs(e.getY() - startPoint.y);
                
                // For a circular profile, a square selection (1:1 ratio) works best
                int side = Math.max(width, height);
                
                int x = e.getX() < startPoint.x ? startPoint.x - side : startPoint.x;
                int y = e.getY() < startPoint.y ? startPoint.y - side : startPoint.y;

                selection.setBounds(x, y, side, side);
                canvas.repaint();
            }
        });

        JButton btnConfirm = new JButton("CONFIRM CROP");
        btnConfirm.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnConfirm.setBackground(new Color(39, 163, 96));
        btnConfirm.setForeground(Color.WHITE);
        btnConfirm.setFocusPainted(false);
        
        btnConfirm.addActionListener(e -> {
            if (selection != null && selection.width > 10) {
                saveAndApplyCrop();
            } else {
                JOptionPane.showMessageDialog(this, "Please drag to select an area first!");
            }
        });

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(canvas), BorderLayout.CENTER);
        this.add(btnConfirm, BorderLayout.SOUTH);
    }

 private void saveAndApplyCrop() {
    try {
        // Check 1: Did they actually drag a box?
        if (selection == null) {
            JOptionPane.showMessageDialog(this, "Please select a crop area first!");
            return;
        }

        // Check 2: Is the destination set in the Profileform?
        if (parent.destination == null) {
            System.out.println("Error: parent.destination is null!");
            parent.destination = "src/image/default_profile.png"; // Emergency fallback
        }

        BufferedImage cropped = image.getSubimage(selection.x, selection.y, selection.width, selection.height);
        
        // Update UI
        parent.profile.setIcon(new ImageIcon(cropped.getScaledInstance(160, 140, Image.SCALE_SMOOTH)));
        
        // Physical Save
        File outputfile = new File(parent.destination);
        if (!outputfile.getParentFile().exists()) {
            outputfile.getParentFile().mkdirs();
        }
        ImageIO.write(cropped, "png", outputfile);
        
        this.dispose();
    } catch (Exception ex) {
        System.out.println("Save Error: " + ex.getMessage());
        ex.printStackTrace();
    }
}
}