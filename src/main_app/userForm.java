/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_app;

import config.configclass;
import config.imageSession;
import internalPages.Payments_page;
import internalPages.manageUser;
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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie
 */
public class userForm extends javax.swing.JFrame {

    /**
     * Creates new form userForm
     */
    public userForm() {
         if (!config.Singleton.getInstance().isLoggedIn()) {
        JOptionPane.showMessageDialog(null, "Please Login First!");
        new logIn().setVisible(true);
        this.dispose();
        return; 
    }
        initComponents();
        displayImageIcon();
    }
       public void close(){
        this.dispose();
        dashboard dash = new dashboard();
        dash.setVisible(true);
        manageUser up = new manageUser();
        dash.maindesktop.add(up).setVisible(true);
        
        String sessionPath = config.imageSession.getInstance().getImagePath();
    if (sessionPath != null && !sessionPath.isEmpty() && !sessionPath.equals("null")) {
        path = sessionPath;
        image.setIcon(ResizeImage(path, null, image));
        browse.setVisible(true);
        browse.setText("REMOVE");
        browse1.setVisible(false);
    } else {
        browse.setVisible(false);
        browse1.setVisible(true);
    }
    }
       
              public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
public void imageUpdater(String existingFilePath, String newFilePath) {
    File folder = new File("src/image");
    if (!folder.exists()) folder.mkdirs();

    try {
        // If there was an old image and it's different from the new one, delete the old one
        if (existingFilePath != null && !existingFilePath.equals(newFilePath)) {
            File oldFile = new File(existingFilePath);
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }
        
        // Copy the new selected file to the destination
        if (selectedFile != null && !destination.isEmpty()) {
            Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
    } catch (IOException e) {
        System.out.println("Error updating image: " + e);
    }
}
    
        public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
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
        image.setIcon(ResizeImage(path, null, image));
        image.setText(""); 
    } else {
        // NO DEFAULT IMAGE - Just clear the label
        image.setIcon(null); 
        image.setText("Click to Upload"); // Or leave blank ""
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
      int validateRegister(){
         int result;
        if(fname.getText().isEmpty() || email.getText().isEmpty() || pword.getText().isEmpty() || uname.getText().isEmpty() || con.getText().isEmpty()){
            result = 0;
        }else{
            result = 1;
        }
        return result;
    }
      public String action;
   public void close1(){
        this.dispose();
        dashboard dash = new dashboard();
        dash.setVisible(true);
        manageUser up = new manageUser();
        dash.maindesktop.add(up).setVisible(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        add = add = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 5;
                int borderRadius = 20;
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
        add.setOpaque(false);
        st_label = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        username1 = new javax.swing.JLabel();
        u_id = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        fname = new javax.swing.JTextField();
        username2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        username3 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        username4 = new javax.swing.JLabel();
        pword = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        username7 = new javax.swing.JLabel();
        con = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        username6 = new javax.swing.JLabel();
        uname = new javax.swing.JTextField();
        type = new javax.swing.JComboBox<>();
        Status = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        image = new javax.swing.JLabel() {
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
        browse1 = new javax.swing.JLabel();
        browse = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(244, 247, 246));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setBackground(new java.awt.Color(243, 156, 18));
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addMousePressed(evt);
            }
        });
        add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        st_label.setBackground(new java.awt.Color(255, 255, 255));
        st_label.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        st_label.setForeground(new java.awt.Color(255, 255, 255));
        st_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        st_label.setText("LABEL");
        add.add(st_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 110, 30));

        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 210, 50));

        jPanel3.setBackground(new java.awt.Color(244, 247, 246));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username1.setBackground(new java.awt.Color(204, 204, 204));
        username1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(27, 42, 78));
        username1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username1.setText("Id:");
        jPanel3.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        u_id.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        u_id.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        u_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                u_idActionPerformed(evt);
            }
        });
        jPanel3.add(u_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 240, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 300, 80));

        jPanel6.setBackground(new java.awt.Color(244, 247, 246));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fname.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        fname.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        jPanel6.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 240, 30));

        username2.setBackground(new java.awt.Color(27, 42, 78));
        username2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username2.setForeground(new java.awt.Color(27, 42, 78));
        username2.setText("Full Name:");
        jPanel6.add(username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 300, 80));

        jPanel7.setBackground(new java.awt.Color(244, 247, 246));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username3.setBackground(new java.awt.Color(204, 204, 204));
        username3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username3.setForeground(new java.awt.Color(27, 42, 78));
        username3.setText("Email:");
        jPanel7.add(username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        email.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        email.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel7.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 240, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 300, 80));

        jPanel8.setBackground(new java.awt.Color(244, 247, 246));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username4.setBackground(new java.awt.Color(204, 204, 204));
        username4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username4.setForeground(new java.awt.Color(27, 42, 78));
        username4.setText("Password:");
        jPanel8.add(username4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        pword.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        pword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        pword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwordActionPerformed(evt);
            }
        });
        jPanel8.add(pword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 30));

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 310, 80));

        jPanel10.setBackground(new java.awt.Color(244, 247, 246));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username7.setBackground(new java.awt.Color(204, 204, 204));
        username7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username7.setForeground(new java.awt.Color(27, 42, 78));
        username7.setText("Phone Number:");
        jPanel10.add(username7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        con.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        con.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conActionPerformed(evt);
            }
        });
        jPanel10.add(con, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 30));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 310, 80));

        jPanel9.setBackground(new java.awt.Color(244, 247, 246));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username6.setBackground(new java.awt.Color(204, 204, 204));
        username6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username6.setForeground(new java.awt.Color(27, 42, 78));
        username6.setText("Username:");
        jPanel9.add(username6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        uname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        uname.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        jPanel9.add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 250, 30));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 310, 80));

        type.setBackground(new java.awt.Color(240, 240, 240));
        type.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        type.setForeground(new java.awt.Color(27, 42, 78));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User", "Admin" }));
        jPanel1.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 200, 30));

        Status.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Status.setForeground(new java.awt.Color(27, 42, 78));
        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pending", "Active" }));
        jPanel1.add(Status, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 200, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 171, 710, 350));

        jPanel4.setBackground(new java.awt.Color(27, 42, 78));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(15, 23, 42)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERS FORM");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 180, 50));

        close.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        close.setForeground(new java.awt.Color(255, 255, 255));
        close.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close.setText("×");
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closeMouseEntered(evt);
            }
        });
        jPanel4.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 80, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 50));

        jPanel2.setBackground(new java.awt.Color(18, 27, 90));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(15, 23, 42), new java.awt.Color(15, 23, 42), new java.awt.Color(15, 23, 42), new java.awt.Color(15, 23, 42)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(18, 27, 90));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add.png"))); // NOI18N
        image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageMouseClicked(evt);
            }
        });
        jPanel5.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 100));

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 150, 100));

        browse1.setBackground(new java.awt.Color(153, 153, 255));
        browse1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        browse1.setForeground(new java.awt.Color(255, 255, 255));
        browse1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        browse1.setText("SELECT");
        browse1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browse1MouseClicked(evt);
            }
        });
        jPanel2.add(browse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 70, -1));

        browse.setBackground(new java.awt.Color(153, 153, 255));
        browse.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        browse.setForeground(new java.awt.Color(255, 255, 255));
        browse.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        browse.setText("BROWSE/");
        browse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                browseMouseClicked(evt);
            }
        });
        jPanel2.add(browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 70, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 120));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conActionPerformed

    private void u_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_u_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_u_idActionPerformed

    private void pwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwordActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
if (action.equals("Add")) {
        int check = validateRegister();
        if (check == 1) {
            configclass dbc = new configclass();

         
            int result = dbc.insertData("INSERT INTO users (u_fname, u_email, u_password, u_username, u_phone, u_type, u_status, Image) "
                    + "VALUES ('" + fname.getText() + "', '" + email.getText() + "', '" + pword.getText() + "', "
                    + "'" + uname.getText() + "', '" + con.getText() + "', '" + type.getSelectedItem() + "', '" + Status.getSelectedItem() + "', '" + destination + "')");

            if (result == 1) {
                try {
                
                    if (selectedFile != null && !destination.isEmpty()) {
                        Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }

                  
                    config.imageSession.getInstance().setImagePath(null);

                    JOptionPane.showMessageDialog(null, "Successfully Saved!");
                    close();
                } catch (IOException e) {
                    System.out.println("Image storage error: " + e);
                    JOptionPane.showMessageDialog(null, "Data saved, but image failed to copy.");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "All fields are required!");
        }

    } else if (action.equals("Update")) {
        configclass dbc = new configclass();

       
        String finalPath = (destination.isEmpty()) ? oldpath : destination;

     
        dbc.updateData("UPDATE users SET u_fname = '" + fname.getText() + "', "
                + "u_email = '" + email.getText() + "', "
                + "u_password = '" + pword.getText() + "', "
                + "u_username = '" + uname.getText() + "', "
                + "u_phone = '" + con.getText() + "', "
                + "u_type = '" + type.getSelectedItem() + "', "
                + "u_status = '" + Status.getSelectedItem() + "', "
                + "Image = '" + finalPath + "' "
                + "WHERE u_id = '" + u_id.getText() + "'");

   
        if (!destination.isEmpty()) {
            imageUpdater(oldpath, path);
        }

        // Update the session so the UI reflects the change immediately
        config.imageSession.getInstance().setImagePath(finalPath);

        JOptionPane.showMessageDialog(null, "Successfully Updated!");
        close();
    }
 
    }//GEN-LAST:event_addMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
      add.setBackground(new Color(255, 179, 71));   
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
    add.setBackground(new Color(243, 156, 18)) ;     
    }//GEN-LAST:event_addMouseExited

    private void imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageMouseClicked
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
                    image.setIcon(ResizeImage(path, null, image));
                    browse.setVisible(true);
                    browse.setText("REMOVE");
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_imageMouseClicked

    private void browseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browseMouseClicked
     config.imageSession.getInstance().setImagePath(null);
    

    browse.setVisible(false);
    browse1.setVisible(true);
    image.setIcon(null);
    

    destination = "";
    path = "";
    }//GEN-LAST:event_browseMouseClicked

    private void browse1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_browse1MouseClicked
     JFileChooser fileChooser = new JFileChooser();
    int returnValue = fileChooser.showOpenDialog(null);
    if (returnValue == JFileChooser.APPROVE_OPTION) {
        try {
            selectedFile = fileChooser.getSelectedFile();
            destination = "src/image/" + selectedFile.getName();
            path = selectedFile.getAbsolutePath();

            if(FileExistenceChecker(path) == 1){
                JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                destination = "";
                path = "";
            } else {
               
                config.imageSession.getInstance().setImagePath(path);
                
            
                image.setIcon(ResizeImage(path, null, image));
                
                browse.setVisible(true);
                browse.setText("REMOVE");
                browse1.setVisible(false);
            }
        } catch (Exception ex) {
            System.out.println("File Error: " + ex);
        }
    }
    }//GEN-LAST:event_browse1MouseClicked

    private void addMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMousePressed
       add.setBackground(new Color(211, 84, 0));
    }//GEN-LAST:event_addMousePressed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        int response = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to exit the application?",
            "Exit Confirmation",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (response == javax.swing.JOptionPane.YES_OPTION) {

            close1();
        }
    }//GEN-LAST:event_closeMouseClicked

    private void closeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseEntered

    }//GEN-LAST:event_closeMouseEntered

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
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JComboBox<String> Status;
    public javax.swing.JPanel add;
    public javax.swing.JLabel browse;
    public javax.swing.JLabel browse1;
    private javax.swing.JLabel close;
    public javax.swing.JTextField con;
    public javax.swing.JTextField email;
    public javax.swing.JTextField fname;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JTextField pword;
    public javax.swing.JLabel st_label;
    public javax.swing.JComboBox<String> type;
    public javax.swing.JTextField u_id;
    public javax.swing.JTextField uname;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel username2;
    private javax.swing.JLabel username3;
    private javax.swing.JLabel username4;
    private javax.swing.JLabel username6;
    private javax.swing.JLabel username7;
    // End of variables declaration//GEN-END:variables
}
