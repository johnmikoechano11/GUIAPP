/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.Session;
import config.Singleton;
import config.configclass;
import config.imageSession;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import main_app.Profileform;
import main_app.landingpage;

/**
 *
 * @author USER42
 */
public class userprofile extends javax.swing.JInternalFrame {

    /**
     * Creates new form accountsettings
     */
    public userprofile() {
        initComponents();
         
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        profile();
        
        imageprofile();
    }

   
  void profile() {
        Singleton singleton = Singleton.getInstance();
        p_name1.setText(singleton.getFname());
        p_name.setText(singleton.getFname());
        p_id.setText(String.valueOf(singleton.getId()));
        p_email.setText(singleton.getEmail());
        cont.setText(singleton.getPhone());
    }
void imageprofile() {
    imageSession image = imageSession.getInstance();
    String path = image.getImagePath();
    
    // Check if path is valid
    if (path != null && !path.isEmpty() && !path.equals("null")) {
        try {
            java.awt.Image img;
            
            // 1. Check if it's an internal resource (starts with /)
            if (path.startsWith("/")) {
                java.net.URL resource = getClass().getResource(path);
                if (resource != null) {
                    img = new javax.swing.ImageIcon(resource).getImage();
                } else {
                    System.out.println("Resource not found: " + path);
                    return;
                }
            } else {
                // 2. Otherwise, treat it as an external file path
                img = new javax.swing.ImageIcon(path).getImage();
            }
            
            // 3. Scale the image to fit your label 'profile'
            // Use Math.max(1, ...) to prevent width/height being 0 if UI hasn't fully rendered
            int w = Math.max(profile.getWidth(), 120); 
            int h = Math.max(profile.getHeight(), 100);
            
            java.awt.Image newImg = img.getScaledInstance(w, h, java.awt.Image.SCALE_SMOOTH);
            
            profile.setIcon(new javax.swing.ImageIcon(newImg));
            profile.setText(""); // Clear any placeholder text
            
        } catch (Exception e) {
            System.out.println("Error loading profile image: " + e.getMessage());
        }
    } else {
        // Fallback to default if no path is found
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile.png")));
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        p_name1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        edit = edit = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 10;
                int borderRadius = 28;
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
        edit.setOpaque(false);
        username1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logout = logout = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 10;
                int borderRadius = 28;
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
        logout.setOpaque(false);
        username3 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        reports = reports = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 10;
                int borderRadius = 28;
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
        reports.setOpaque(false);
        username2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fullname1 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        fullname = new javax.swing.JLabel();
        cont = new javax.swing.JLabel();
        p_email = new javax.swing.JLabel();
        p_id = new javax.swing.JLabel();
        p_name = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(670, 390));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(36, 59, 126));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(36, 59, 126));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/profile.png"))); // NOI18N
        jPanel4.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 120, 100));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 170, 130));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("USER PROFILE");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Welcome,");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 130, 30));

        p_name1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        p_name1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(p_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 180, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 130));

        jPanel3.setBackground(new java.awt.Color(244, 247, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit.setBackground(new java.awt.Color(27, 42, 78));
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                editMousePressed(evt);
            }
        });
        edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username1.setBackground(new java.awt.Color(0, 0, 0));
        username1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(255, 255, 255));
        username1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username1.setText("EDIT PROFILE");
        edit.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_2.png"))); // NOI18N
        edit.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 110, 100));

        jPanel3.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 190, 130));

        logout.setBackground(new java.awt.Color(211, 84, 0));
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logout.setPreferredSize(new java.awt.Dimension(160, 160));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
        });
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username3.setBackground(new java.awt.Color(0, 0, 0));
        username3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username3.setForeground(new java.awt.Color(255, 255, 255));
        username3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username3.setText("LOG OUT");
        logout.add(username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 110, -1));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_4.png"))); // NOI18N
        logout.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 110, 90));

        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 190, 130));

        reports.setBackground(new java.awt.Color(255, 255, 255));
        reports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportsMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportsMousePressed(evt);
            }
        });
        reports.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username2.setBackground(new java.awt.Color(0, 0, 0));
        username2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username2.setText("REPORTS");
        reports.add(username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 120, 20));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon_3.png"))); // NOI18N
        reports.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, 90));

        jPanel3.add(reports, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 200, 130));

        fullname1.setBackground(new java.awt.Color(204, 204, 204));
        fullname1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fullname1.setForeground(new java.awt.Color(44, 62, 80));
        fullname1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname1.setText("Full Name: ");
        jPanel3.add(fullname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, -1));

        ID.setBackground(new java.awt.Color(204, 204, 204));
        ID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ID.setForeground(new java.awt.Color(44, 62, 80));
        ID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ID.setText("User ID: ");
        jPanel3.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

        email.setBackground(new java.awt.Color(204, 204, 204));
        email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        email.setForeground(new java.awt.Color(44, 62, 80));
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("Email: ");
        jPanel3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 50, -1));

        fullname.setBackground(new java.awt.Color(204, 204, 204));
        fullname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        fullname.setForeground(new java.awt.Color(44, 62, 80));
        fullname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fullname.setText("Phone No:");
        jPanel3.add(fullname, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, 80, 30));

        cont.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cont.setForeground(new java.awt.Color(27, 42, 78));
        cont.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(197, 160, 89), 1, true));
        jPanel3.add(cont, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 260, 30));

        p_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        p_email.setForeground(new java.awt.Color(27, 42, 78));
        p_email.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(197, 160, 89), 1, true));
        jPanel3.add(p_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, 260, 30));

        p_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        p_id.setForeground(new java.awt.Color(27, 42, 78));
        p_id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(197, 160, 89), 1, true));
        jPanel3.add(p_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 260, 30));

        p_name.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        p_name.setForeground(new java.awt.Color(27, 42, 78));
        p_name.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(197, 160, 89), 1, true));
        jPanel3.add(p_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 260, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 670, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseEntered
        edit.setBackground(new Color(44,62,140));
    }//GEN-LAST:event_editMouseEntered

    private void editMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseExited
        edit.setBackground(new Color(27,42,78));
    }//GEN-LAST:event_editMouseExited

    private void reportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseEntered
        reports.setBackground(new Color(244,247,246));
    }//GEN-LAST:event_reportsMouseEntered

    private void reportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseExited
        reports.setBackground(new Color(255,255,255));
    }//GEN-LAST:event_reportsMouseExited

    private void logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseClicked
         int a = javax.swing.JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Select", javax.swing.JOptionPane.YES_NO_OPTION);
        if (a == 0) {
            landingpage lp = new landingpage();
            lp.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_logoutMouseClicked

    private void logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseEntered
        logout.setBackground(new Color(230, 126, 34));
    }//GEN-LAST:event_logoutMouseEntered

    private void logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMouseExited
        logout.setBackground(new Color(211, 84, 0));
    }//GEN-LAST:event_logoutMouseExited

    private void editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMouseClicked
      Profileform p = new Profileform();
      p.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_editMouseClicked

    private void reportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMousePressed
      reports.setBackground(new Color(255,232,240));
    }//GEN-LAST:event_reportsMousePressed

    private void editMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMousePressed
      edit.setBackground(new Color(18,28,51));
    }//GEN-LAST:event_editMousePressed

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
     logout.setBackground(new Color(160,64,0));
    }//GEN-LAST:event_logoutMousePressed

    private void reportsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsMouseClicked
   reports rep = new reports();
    
   
    javax.swing.JDesktopPane maindesktop = (javax.swing.JDesktopPane) javax.swing.SwingUtilities.getAncestorOfClass(javax.swing.JDesktopPane.class, this);
    
    if (maindesktop != null) {
     
        maindesktop.removeAll();
        
       
        maindesktop.add(rep);
        rep.setVisible(true);
        
        
        try {
            rep.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
            System.out.println("Error selecting frame: " + e.getMessage());
        }


        maindesktop.revalidate();
        maindesktop.repaint();
    } else {
        System.out.println("Error: Could not find maindesktop. Ensure userprofile is inside a JDesktopPane.");
    }
    }//GEN-LAST:event_reportsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel ID;
    public javax.swing.JLabel cont;
    private javax.swing.JPanel edit;
    public javax.swing.JLabel email;
    public javax.swing.JLabel fullname;
    public javax.swing.JLabel fullname1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel logout;
    public javax.swing.JLabel p_email;
    public javax.swing.JLabel p_id;
    public javax.swing.JLabel p_name;
    public javax.swing.JLabel p_name1;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel reports;
    private javax.swing.JLabel username1;
    private javax.swing.JLabel username2;
    private javax.swing.JLabel username3;
    // End of variables declaration//GEN-END:variables
}
