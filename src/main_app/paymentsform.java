/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_app;

import config.configclass;
import internalPages.Payments_page;
import internalPages.member;
import java.awt.Color;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Angie
 */
public class paymentsform extends javax.swing.JFrame {

    /**
     * Creates new form paymentsform
     */
    public paymentsform() {
          if (!config.Singleton.getInstance().isLoggedIn()) {
        JOptionPane.showMessageDialog(null, "Please Login First!");
        new logIn().setVisible(true);
        this.dispose();
        return; 
    }
        initComponents();
        this.setBackground(new java.awt.Color(0,0,0,0));
   
        p_date.setText(new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
        
        fillMemberCombo();
 m_id.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            fetchMemberData();
        }
    });
     
    }
        Color navcolor = new Color (102,102,102);
     Color headcolor = new Color (51,51,51);
     Color bodycolor = new Color (153,153,153);
     
           public String action;

int validateRegister() {
        if (m_amount.getText().equals("0.00") || m_amount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid amount!"); return 0;
        }
        return 1;
    }

   
    public void close(){
        this.dispose();
        dashboard dash = new dashboard();
        dash.setVisible(true);
        Payments_page up = new Payments_page();
        dash.maindesktop.add(up).setVisible(true);
    }
    

public void setPaymentDetails(String memberID, String memberAmount) {
 
    m_amount.setText(memberAmount); 
    p_id.setText("NEW");

 
    for (int i = 0; i < m_id.getItemCount(); i++) {
        String item = m_id.getItemAt(i).toString();
        if (item.startsWith(memberID + " - ")) {
            m_id.setSelectedIndex(i);
            break;
        }
    }


    fetchMemberData();
}

private void fillMemberCombo() {
    try {
        configclass dbc = new configclass();
      
    
        ResultSet rs = dbc.getData("SELECT m_id, m_fname FROM members");
        while(rs.next()) {
            m_id.addItem(rs.getString("m_id") + " - " + rs.getString("m_fname"));
        }
    } catch(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
}

public void fetchMemberData() {
    if (m_id.getSelectedItem() == null) return;
    configclass dbc = new configclass();
    try {
        String selected = m_id.getSelectedItem().toString();
        String memberId = selected.split(" - ")[0];             
        String query = "SELECT m_type FROM members WHERE m_id = '" + memberId + "'";
        ResultSet rs = dbc.getData(query);
        
        if (rs.next()) {
            String typeFromDb = rs.getString("m_type");

            calculatePayment(typeFromDb); 
        }
    } catch (Exception e) {
        System.out.println("Fetch Error: " + e.getMessage());
    }
}
   
public void calculatePayment(String selectedType) {
    double rate = 0;
    
    if (selectedType == null) return;
    

    if (selectedType.equalsIgnoreCase("Monthly")) rate = 500;
    else if (selectedType.equalsIgnoreCase("Vip")) rate = 1500;
    else if (selectedType.equalsIgnoreCase("Student")) rate = 350;
    

    m_amount.setText(String.format("%.2f", rate));
}
  
    public void printReceipt() {
        String receiptText = 
              "-------------------------------------------\n"    
            + "               MUSCLE FITNESS              \n"
            + "          Official Payment Receipt         \n"
            + "-------------------------------------------\n"
            + " Payment ID:    " + p_id.getText() + "\n"
            + " Member:        " + m_id.getSelectedItem().toString() + "\n"
            + " Date:          " + p_date.getText() + "\n"
            + "-------------------------------------------\n"
            + " Method:        " + m_id.getSelectedItem().toString() + "\n"
            + " Status:        " + status.getSelectedItem().toString() + "\n"
            + "-------------------------------------------\n"
            + " TOTAL AMOUNT:  PHP " + m_amount.getText() + "\n"
            + "-------------------------------------------\n"
            + "          Thank you for your payment!      \n";

        javax.swing.JTextArea receiptArea = new javax.swing.JTextArea(receiptText);
        try {
            boolean complete = receiptArea.print();
            if (complete) JOptionPane.showMessageDialog(null, "Printing Successful!");
        } catch (java.awt.print.PrinterException e) {
            JOptionPane.showMessageDialog(null, "Printer Error: " + e.getMessage());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        body = new javax.swing.JPanel() {
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
        status = new javax.swing.JComboBox<>();
        firstname2 = new javax.swing.JLabel();
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
        ;
        st_label = new javax.swing.JLabel();
        firstname5 = new javax.swing.JLabel();
        firstname6 = new javax.swing.JLabel();
        p_id = new javax.swing.JLabel();
        m_amount = new javax.swing.JTextField();
        firstname7 = new javax.swing.JLabel();
        firstname3 = new javax.swing.JLabel();
        firstname4 = new javax.swing.JLabel();
        p_date = new javax.swing.JTextField();
        m_id = new javax.swing.JComboBox<>();
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
        jLabel2 = new javax.swing.JLabel();
        close5 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(244, 247, 246));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        status.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        status.setForeground(new java.awt.Color(27, 42, 78));
        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Completed", "Failed" }));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });
        body.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, 30));

        firstname2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname2.setForeground(new java.awt.Color(27, 42, 78));
        firstname2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname2.setText("Status:");
        body.add(firstname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 70, 30));

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
        st_label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        st_label.setForeground(new java.awt.Color(255, 255, 255));
        st_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        st_label.setText("Label");
        add.add(st_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 80, 50));

        body.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 280, 50));

        firstname5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname5.setForeground(new java.awt.Color(27, 42, 78));
        firstname5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname5.setText("Payments Id:");
        body.add(firstname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, 30));

        firstname6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname6.setForeground(new java.awt.Color(27, 42, 78));
        firstname6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname6.setText(" Members Id:");
        body.add(firstname6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 100, 30));

        p_id.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        p_id.setForeground(new java.awt.Color(27, 42, 78));
        p_id.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        body.add(p_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 120, 30));

        m_amount.setEditable(false);
        m_amount.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        m_amount.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        m_amount.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        m_amount.setOpaque(false);
        m_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_amountActionPerformed(evt);
            }
        });
        body.add(m_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, 30));

        firstname7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname7.setForeground(new java.awt.Color(27, 42, 78));
        firstname7.setText("Amount:");
        body.add(firstname7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 70, 30));

        firstname3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname3.setForeground(new java.awt.Color(27, 42, 78));
        firstname3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname3.setText("Payment Type:");
        body.add(firstname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 30));

        firstname4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname4.setForeground(new java.awt.Color(27, 42, 78));
        firstname4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname4.setText("Payment Date:");
        body.add(firstname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 30));

        p_date.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        p_date.setForeground(new java.awt.Color(27, 42, 78));
        p_date.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        body.add(p_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 200, 30));

        m_id.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        m_id.setForeground(new java.awt.Color(27, 42, 78));
        m_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_idActionPerformed(evt);
            }
        });
        body.add(m_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 80, 30));

        header.setBackground(new java.awt.Color(27, 42, 78));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PAYMENTS FORM");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 20));

        close5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        close5.setForeground(new java.awt.Color(255, 255, 255));
        close5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close5.setText("×");
        close5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        close5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close5MouseEntered(evt);
            }
        });
        header.add(close5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 60, 50));

        body.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 60));

        type.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        type.setForeground(new java.awt.Color(27, 42, 78));
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Gcash", "Card" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        body.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, 30));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 520, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed

    }//GEN-LAST:event_statusActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
if (validateRegister() == 1) {
        configclass dbc = new configclass();
        
        String selectedMember = m_id.getSelectedItem().toString();
        String memID = selectedMember.split(" - ")[0]; 
        
       
        String payID   = p_id.getText();
        String amount  = m_amount.getText();
        
       
        String payType = type.getSelectedItem().toString(); 
        
        String payDate = p_date.getText();
        String payStat = status.getSelectedItem().toString();

        String sql;

        if (action.equals("Add")) {
            sql = "INSERT INTO payments (m_id, p_amount, p_type, p_date, p_status) "
                + "VALUES (" + memID + ", " + amount + ", '" + payType + "', '" + payDate + "', '" + payStat + "')";

            if (dbc.insertData(sql) == 1) {
                JOptionPane.showMessageDialog(null, "New Payment Recorded!");
                
                // Ask for receipt after successful save
                int response = JOptionPane.showConfirmDialog(null, "Would you like to print a receipt?", "Print", JOptionPane.YES_NO_OPTION);
                if(response == JOptionPane.YES_OPTION){
                    printReceipt();
                }
                
                close();
            }
        } else if (action.equals("Update")) {
            sql = "UPDATE payments SET "
                + "m_id = " + memID + ", "
                + "p_amount = " + amount + ", "
                + "p_type = '" + payType + "', "
                + "p_date = '" + payDate + "', "
                + "p_status = '" + payStat + "' "
                + "WHERE r_id = '" + payID + "'";

            dbc.updateData(sql);
            JOptionPane.showMessageDialog(null, "Payment Updated Successfully!");
            close();
        }
    }
    }//GEN-LAST:event_addMouseClicked

    private void addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseEntered
         add.setBackground(new Color(255, 179, 71));   
    }//GEN-LAST:event_addMouseEntered

    private void addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseExited
           add.setBackground(new Color(243, 156, 18)) ;
    }//GEN-LAST:event_addMouseExited

    private void m_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_amountActionPerformed

    }//GEN-LAST:event_m_amountActionPerformed

    private void m_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_idActionPerformed
      if (m_id.getSelectedItem() != null) {
        fetchMemberData(); 
    }
    }//GEN-LAST:event_m_idActionPerformed

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeActionPerformed

    private void addMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMousePressed
       add.setBackground(new Color(211, 84, 0));
    }//GEN-LAST:event_addMousePressed

    private void close5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close5MouseClicked
        int response = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to exit the application?",
            "Exit Confirmation",
            javax.swing.JOptionPane.YES_NO_OPTION,
            javax.swing.JOptionPane.QUESTION_MESSAGE
        );

        if (response == javax.swing.JOptionPane.YES_OPTION) {

            close();
        }
    }//GEN-LAST:event_close5MouseClicked

    private void close5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close5MouseEntered

    }//GEN-LAST:event_close5MouseEntered

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
            java.util.logging.Logger.getLogger(paymentsform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(paymentsform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(paymentsform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(paymentsform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new paymentsform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel add;
    private javax.swing.JPanel body;
    private javax.swing.JLabel close5;
    private javax.swing.JLabel firstname2;
    private javax.swing.JLabel firstname3;
    private javax.swing.JLabel firstname4;
    private javax.swing.JLabel firstname5;
    private javax.swing.JLabel firstname6;
    private javax.swing.JLabel firstname7;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JTextField m_amount;
    public javax.swing.JComboBox<String> m_id;
    public javax.swing.JTextField p_date;
    public javax.swing.JLabel p_id;
    public javax.swing.JLabel st_label;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
