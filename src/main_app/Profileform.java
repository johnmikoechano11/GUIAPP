/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_app;

import config.Singleton;
import config.configclass;
import config.imageSession;
import internalPages.userprofile;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie
 */
public class Profileform extends javax.swing.JFrame {

    /**
     * Creates new form Profileform
     */
    public Profileform() {
        initComponents();
        profile();
        displayImageIcon();
        
        this.setBackground(new java.awt.Color(0, 0, 0, 0));
    }
    
      void profile() {
        Singleton singleton = Singleton.getInstance();
        f_name.setText(singleton.getFname());
        p_id.setText(String.valueOf(singleton.getId()));
        p_email.setText(singleton.getEmail());
        cont.setText(singleton.getPhone());
    }
        public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
public void imageUpdater(String existingFilePath, String newFilePath) {
   
    File folder = new File("src/image");
    if (!folder.exists()) {
        folder.mkdirs(); 
    }

    try {
        
        if (existingFilePath != null && !existingFilePath.equals(newFilePath)) {
            File oldFile = new File(existingFilePath);
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }
        
      
        if (selectedFile != null && selectedFile.exists()) {
           
            Path destPath = Paths.get(destination); 
            Files.copy(selectedFile.toPath(), destPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Image successfully copied to: " + destination);
        } else {
            System.out.println("Source file does not exist: " + path);
        }
    } catch (IOException e) {
        System.out.println("Error updating image: " + e.getMessage());
    }
}
    
        public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
           
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
        
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
      
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    
public void displayImageIcon() {
    String path = imageSession.getInstance().getImagePath();
    
    if (path != null && !path.isEmpty() && !path.equals("null")) {
        // Load the uploaded image
        profile.setIcon(ResizeImage(path, null, profile));
        profile.setText(""); 
    } else {
        // NO DEFAULT IMAGE - Just clear the label
        profile.setIcon(null); 
        profile.setText("Click to Upload"); // Or leave blank ""
    }
}

public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
    if (ImagePath != null) {
        MyImage = new ImageIcon(ImagePath);
    } else {
        MyImage = new ImageIcon(pic);
    }
 
    int width = label.getWidth();
    int height = label.getHeight();
    
 
    if (width <= 0) width = 130; 
    if (height <= 0) height = 100;

    java.awt.Image img = MyImage.getImage();
    java.awt.Image newImg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(newImg);
}

public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/image", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
  
private void openCropTool(File file) {
    try {
        BufferedImage originalImage = ImageIO.read(file);
        // This opens the new window we created
        CropWindow cropWindow = new CropWindow(this, originalImage);
        cropWindow.setVisible(true);
    } catch (IOException e) {
        System.out.println("Error loading image for cropping: " + e.getMessage());
    }
}

      public String action;
     public void close(){
        this.dispose();
        dashboard dash = new dashboard();
        dash.setVisible(true);
         userprofile up = new userprofile();
        dash.maindesktop.add(up).setVisible(true);
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = body = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 10;
                int borderRadius = 25;
                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // 1. Draw the Shadow
                for (int i = 0; i < shadowSize; i++) {
                    // Gradually fade the black color to create a soft blur
                    g2.setColor(new java.awt.Color(0, 0, 0, (shadowSize - i) * 5)); 
                    g2.drawRoundRect(shadowSize - i, shadowSize - i, width + i * 2, height + i * 2, borderRadius, borderRadius);
                }

                // 2. Fill the Main Panel (White Card)
                g2.setColor(getBackground()); // Uses the color from the Design tab
                g2.fillRoundRect(shadowSize, shadowSize, width, height, borderRadius, borderRadius);

                g2.dispose();
            }
        };
        // This makes the area outside the rounded card transparent
        body.setOpaque(false);
        fullname = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = jPanel1 = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 5;
                int borderRadius = 48;
                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // 1. Draw the Shadow
                for (int i = 0; i < shadowSize; i++) {
                    // Gradually fade the black color to create a soft blur
                    g2.setColor(new java.awt.Color(0, 0, 0, (shadowSize - i) * 5)); 
                    g2.drawRoundRect(shadowSize - i, shadowSize - i, width + i * 2, height + i * 2, borderRadius, borderRadius);
                }

                // 2. Fill the Main Panel (White Card)
                g2.setColor(getBackground()); // Uses the color from the Design tab
                g2.fillRoundRect(shadowSize, shadowSize, width, height, borderRadius, borderRadius);

                g2.dispose();
            }
        };
        // This makes the area outside the rounded card transparent
        jPanel1.setOpaque(false);
        ;
        jLabel7 = new javax.swing.JLabel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                // Create the circular clip
                int diameter = Math.min(getWidth(), getHeight());
                int x = (getWidth() - diameter) / 2;
                int y = (getHeight() - diameter) / 2;

                java.awt.geom.Ellipse2D.Double circle = new java.awt.geom.Ellipse2D.Double(x, y, diameter, diameter);
                g2.setClip(circle);

                // Paint the image inside the circle
                super.paintComponent(g2);

                // Optional: Add a white border around the circle
                g2.setClip(null); // Remove clip to draw border on top
                g2.setColor(java.awt.Color.LIGHT_GRAY);
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.draw(circle);

                g2.dispose();
            }
        };
        profile = new javax.swing.JLabel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                // Create the circular clip
                int diameter = Math.min(getWidth(), getHeight());
                int x = (getWidth() - diameter) / 2;
                int y = (getHeight() - diameter) / 2;

                java.awt.geom.Ellipse2D.Double circle = new java.awt.geom.Ellipse2D.Double(x, y, diameter, diameter);
                g2.setClip(circle);

                // Paint the image inside the circle
                super.paintComponent(g2);

                // Optional: Add a white border around the circle
                g2.setClip(null); // Remove clip to draw border on top
                g2.setColor(java.awt.Color.LIGHT_GRAY);
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.draw(circle);

                g2.dispose();
            }
        };
        cont = new javax.swing.JLabel();
        f_name = new javax.swing.JLabel();
        p_id = new javax.swing.JLabel();
        fullname1 = new javax.swing.JLabel();
        p_email = new javax.swing.JLabel();
        header = header = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 10;
                int borderRadius = 25;
                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // 1. Draw the Shadow (Top corners only)
                for (int i = 0; i < shadowSize; i++) {
                    g2.setColor(new java.awt.Color(0, 0, 0, (shadowSize - i) * 5)); 
                    // Draw shadow as a round rect
                    g2.drawRoundRect(shadowSize - i, shadowSize - i, width + i * 2, height + i * 2, borderRadius, borderRadius);
                }

                // 2. Fill the Main Panel
                g2.setColor(getBackground());

                // --- THE TRICK FOR TOP BORDER RADIUS ONLY ---
                // Fill the top half with rounded corners
                g2.fillRoundRect(shadowSize, shadowSize, width, height, borderRadius, borderRadius);

                // Fill the bottom half with a sharp rectangle to "cancel out" the bottom curves
                // We start from the middle and fill to the very bottom
                g2.fillRect(shadowSize, shadowSize + (height / 2), width, (height / 2));

                g2.dispose();
            }
        };
        header.setOpaque(false);
        jLabel1 = new javax.swing.JLabel();
        wrong = wrong = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 10;
                int borderRadius = 25;
                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // 1. Draw the Shadow (Top corners only)
                for (int i = 0; i < shadowSize; i++) {
                    g2.setColor(new java.awt.Color(0, 0, 0, (shadowSize - i) * 5)); 
                    // Draw shadow as a round rect
                    g2.drawRoundRect(shadowSize - i, shadowSize - i, width + i * 2, height + i * 2, borderRadius, borderRadius);
                }

                // 2. Fill the Main Panel
                g2.setColor(getBackground());

                // --- THE TRICK FOR TOP BORDER RADIUS ONLY ---
                // Fill the top half with rounded corners
                g2.fillRoundRect(shadowSize, shadowSize, width, height, borderRadius, borderRadius);

                // Fill the bottom half with a sharp rectangle to "cancel out" the bottom curves
                // We start from the middle and fill to the very bottom
                g2.fillRect(shadowSize, shadowSize + (height / 2), width, (height / 2));

                g2.dispose();
            }
        };
        wrong.setOpaque(false);
        jLabel3 = new javax.swing.JLabel();
        browse1 = new javax.swing.JLabel();
        browse = new javax.swing.JLabel();
        btnSave = btnSave = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 5;
                int borderRadius = 10;
                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // 1. Draw the Shadow
                for (int i = 0; i < shadowSize; i++) {
                    // Gradually fade the black color to create a soft blur
                    g2.setColor(new java.awt.Color(0, 0, 0, (shadowSize - i) * 5)); 
                    g2.drawRoundRect(shadowSize - i, shadowSize - i, width + i * 2, height + i * 2, borderRadius, borderRadius);
                }

                // 2. Fill the Main Panel (White Card)
                g2.setColor(getBackground()); // Uses the color from the Design tab
                g2.fillRoundRect(shadowSize, shadowSize, width, height, borderRadius, borderRadius);

                g2.dispose();
            }
        };
        // This makes the area outside the rounded card transparent
        btnSave.setOpaque(false);
        ;
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnUpdate = btnUpdate = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 5;
                int borderRadius = 10;
                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // 1. Draw the Shadow
                for (int i = 0; i < shadowSize; i++) {
                    // Gradually fade the black color to create a soft blur
                    g2.setColor(new java.awt.Color(0, 0, 0, (shadowSize - i) * 5)); 
                    g2.drawRoundRect(shadowSize - i, shadowSize - i, width + i * 2, height + i * 2, borderRadius, borderRadius);
                }

                // 2. Fill the Main Panel (White Card)
                g2.setColor(getBackground()); // Uses the color from the Design tab
                g2.fillRoundRect(shadowSize, shadowSize, width, height, borderRadius, borderRadius);

                g2.dispose();
            }
        };
        // This makes the area outside the rounded card transparent
        btnUpdate.setOpaque(false);
        ;
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnDelete = btnDelete = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 5;
                int borderRadius = 10;
                int width = getWidth() - shadowSize * 2;
                int height = getHeight() - shadowSize * 2;

                // 1. Draw the Shadow
                for (int i = 0; i < shadowSize; i++) {
                    // Gradually fade the black color to create a soft blur
                    g2.setColor(new java.awt.Color(0, 0, 0, (shadowSize - i) * 5)); 
                    g2.drawRoundRect(shadowSize - i, shadowSize - i, width + i * 2, height + i * 2, borderRadius, borderRadius);
                }

                // 2. Fill the Main Panel (White Card)
                g2.setColor(getBackground()); // Uses the color from the Design tab
                g2.fillRoundRect(shadowSize, shadowSize, width, height, borderRadius, borderRadius);

                g2.dispose();
            }
        };
        // This makes the area outside the rounded card transparent
        btnDelete.setOpaque(false);
        ;
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(244, 247, 246));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fullname.setBackground(new java.awt.Color(204, 204, 204));
        fullname.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        fullname.setForeground(new java.awt.Color(27, 42, 78));
        fullname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname.setText("Phone No:");
        body.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, 40));

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        email.setForeground(new java.awt.Color(27, 42, 78));
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("Email: ");
        body.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 90, 40));

        ID.setBackground(new java.awt.Color(204, 204, 204));
        ID.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ID.setForeground(new java.awt.Color(27, 42, 78));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setText("User ID: ");
        body.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 110, 40));

        jPanel4.setBackground(new java.awt.Color(229, 231, 235));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/edit.png"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 28));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, 50, 50));

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        profile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileMouseClicked(evt);
            }
        });
        jPanel4.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 160, 140));

        body.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 220, 170));

        cont.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cont.setForeground(new java.awt.Color(27, 42, 78));
        cont.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cont.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        body.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 210, 40));

        f_name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        f_name.setForeground(new java.awt.Color(27, 42, 78));
        f_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        f_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        body.add(f_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 210, 40));

        p_id.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        p_id.setForeground(new java.awt.Color(27, 42, 78));
        p_id.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p_id.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        body.add(p_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 210, 40));

        fullname1.setBackground(new java.awt.Color(204, 204, 204));
        fullname1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        fullname1.setForeground(new java.awt.Color(27, 42, 78));
        fullname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname1.setText("Full name: ");
        body.add(fullname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 130, 40));

        p_email.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        p_email.setForeground(new java.awt.Color(27, 42, 78));
        p_email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p_email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        body.add(p_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 210, 40));

        header.setBackground(new java.awt.Color(27, 42, 78));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PROFILE FORM");
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, -1, -1));

        wrong.setBackground(new java.awt.Color(27, 42, 78));
        wrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wrongMouseClicked(evt);
            }
        });
        wrong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("×");
        wrong.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 70));

        header.add(wrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, 80, 80));

        body.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 80));

        browse1.setBackground(new java.awt.Color(153, 153, 255));
        browse1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        browse1.setForeground(new java.awt.Color(27, 42, 78));
        browse1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        browse1.setText("SELECT");
        browse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browse1MouseClicked(evt);
            }
        });
        body.add(browse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 210, -1));

        browse.setBackground(new java.awt.Color(153, 153, 255));
        browse.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        browse.setForeground(new java.awt.Color(27, 42, 78));
        browse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        browse.setText("BROWSE");
        browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseMouseClicked(evt);
            }
        });
        body.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 299, 210, 30));

        btnSave.setBackground(new java.awt.Color(39, 163, 96));
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSaveMousePressed(evt);
            }
        });
        btnSave.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SAVE");
        btnSave.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 52, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new_user.png"))); // NOI18N
        btnSave.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 52, 50));

        body.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, 70, 70));

        btnUpdate.setBackground(new java.awt.Color(41, 128, 185));
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUpdateMousePressed(evt);
            }
        });
        btnUpdate.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("UPDATE");
        btnUpdate.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 40, 66, 30));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N
        btnUpdate.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 76, 40));

        body.add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 74, 70));

        btnDelete.setBackground(new java.awt.Color(192, 57, 43));
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDeleteMousePressed(evt);
            }
        });
        btnDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("DELETE");
        btnDelete.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 40, 62, 30));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        btnDelete.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        body.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(573, 360, 73, 70));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browse1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browse1MouseClicked
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/image/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();

                if(FileExistenceChecker(path) == 1){
                    JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    profile.setIcon(ResizeImage(path, null, profile));
                    browse.setVisible(true);
                    browse.setText("REMOVE");
                    browse1.setVisible(false);
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_browse1MouseClicked

    private void browseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseMouseClicked
     config.imageSession.getInstance().setImagePath(null);
    browse.setVisible(false);
    browse1.setVisible(true);
    profile.setIcon(null);
    

    destination = "";
    path = "";
    }//GEN-LAST:event_browseMouseClicked

    private void profileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileMouseClicked
   JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        try {
            selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            destination = "src/image/" + selectedFile.getName();

            if(FileExistenceChecker(path) == 1){
                JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                destination = "";
                path = "";
            } else {
               
                profile.setIcon(ResizeImage(path, null, profile));
                profile.setText("");
                
               
                browse.setVisible(true);
                browse.setText("REMOVE");
            }
        } catch (Exception ex) {
            System.out.println("File Error!");
        }
    }
    }//GEN-LAST:event_profileMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
    if (destination == null || destination.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select and crop an image first!");
        return;
    }

    configclass conf = new configclass();
    String sql = "UPDATE users SET Image = '" + destination + "' WHERE u_email = '" + p_email.getText() + "'";


    conf.updateData(sql);
    
 
    imageUpdater(oldpath, destination);
    
    JOptionPane.showMessageDialog(null, "Profile Updated successfully!");
    oldpath = destination;

 
  try {
   
    JDesktopPane desktop = (JDesktopPane) javax.swing.SwingUtilities.getAncestorOfClass(JDesktopPane.class, this);
    
    if (desktop != null) {
        desktop.removeAll();
        internalPages.userprofile up = new internalPages.userprofile();
        desktop.add(up);
        up.setVisible(true);
        desktop.revalidate();
        desktop.repaint();
    }
        
       
        this.dispose();
        
    } catch (Exception ex) {
        System.out.println("Error returning to User Profile: " + ex.getMessage());
    }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        browse1MouseClicked(null);
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
 if (path == null || path.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Please select an image first!");
        return;
    }

    String fixedPath = path.replace("\\", "\\\\");
    configclass conf = new configclass();
    
    String sql = "UPDATE users SET Image = '" + fixedPath + "' WHERE u_email = '" + p_email.getText().trim() + "'";

    System.out.println("Executing: " + sql); 

    conf.updateData(sql);
    
  
    imageUpdater(oldpath, path);
    JOptionPane.showMessageDialog(null, "Profile Updated with Local Path!");
    oldpath = path;
    
    // REMOVED THE BROKEN ELSE BLOCK HERE
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void wrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wrongMouseClicked
  
        this.dispose();

   
        javax.swing.JFrame topFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);

        try {
          
            java.lang.reflect.Field field = topFrame.getClass().getDeclaredField("maindesktop");
            field.setAccessible(true);
            javax.swing.JDesktopPane desktop = (javax.swing.JDesktopPane) field.get(topFrame);

        
            desktop.removeAll();
            dashboard db = new dashboard(); 
            desktop.add(db).setVisible(true);

        
            desktop.revalidate();
            desktop.repaint();

        } catch (Exception e) {

            System.out.println("Error returning to Members: " + e.getMessage());
        }
    }//GEN-LAST:event_wrongMouseClicked

    private void btnSaveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseEntered
      btnSave.setBackground(new Color(46, 204, 113));
    }//GEN-LAST:event_btnSaveMouseEntered

    private void btnSaveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseExited
       btnSave.setBackground(new Color(39,163,96));
    }//GEN-LAST:event_btnSaveMouseExited

    private void btnSaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMousePressed
      btnSave.setBackground(new Color(30, 132, 73));
    }//GEN-LAST:event_btnSaveMousePressed

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
       btnUpdate.setBackground(new Color(52, 152, 219));
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
      btnUpdate.setBackground(new Color(41,128,185));
    }//GEN-LAST:event_btnUpdateMouseExited

    private void btnUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMousePressed
       btnUpdate.setBackground(new Color(41,128,185));
    }//GEN-LAST:event_btnUpdateMousePressed

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        btnDelete.setBackground(new Color(231, 76, 60));
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        btnDelete.setBackground(new Color(192,57,43));
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMousePressed
        btnDelete.setBackground(new Color(146, 43, 33));
    }//GEN-LAST:event_btnDeleteMousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
   if (selectedFile != null && selectedFile.exists()) {
    
        if (destination == null || destination.isEmpty()) {
            destination = "src/image/profile_" + System.currentTimeMillis() + ".png";
        }
        openCropTool(selectedFile);
    } else {
      
        String existingPath = config.imageSession.getInstance().getImagePath();
        if (existingPath != null && !existingPath.equals("null")) {
            selectedFile = new File(existingPath);
            destination = existingPath; 
            openCropTool(selectedFile);
        } else {
            JOptionPane.showMessageDialog(null, "Please select an image first!");
        }
    }
    
    }//GEN-LAST:event_jPanel1MouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profileform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profileform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profileform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profileform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profileform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ID;
    private javax.swing.JPanel body;
    public javax.swing.JLabel browse;
    public javax.swing.JLabel browse1;
    private javax.swing.JPanel btnDelete;
    private javax.swing.JPanel btnSave;
    private javax.swing.JPanel btnUpdate;
    public javax.swing.JLabel cont;
    public javax.swing.JLabel email;
    public javax.swing.JLabel f_name;
    public javax.swing.JLabel fullname;
    public javax.swing.JLabel fullname1;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JLabel p_email;
    public javax.swing.JLabel p_id;
    public javax.swing.JLabel profile;
    private javax.swing.JPanel wrong;
    // End of variables declaration//GEN-END:variables
}
