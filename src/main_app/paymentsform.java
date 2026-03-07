/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_app;

import config.configclass;
import internalPages.member;
import java.awt.Color;
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
        initComponents();
    }
        Color navcolor = new Color (102,102,102);
     Color headcolor = new Color (51,51,51);
     Color bodycolor = new Color (153,153,153);
     
           public String action;

int validateRegister() {
    if (type.getSelectedIndex() == -1) {
        JOptionPane.showMessageDialog(null, "Please select Cash, GCash, or Card!");
        return 0;
    }
    return 1;
}
   
    public void close(){
        this.dispose();
        dashboard dash = new dashboard();
        dash.setVisible(true);
        member up = new member();
        dash.maindesktop.add(up).setVisible(true);
    }
    

public void setPaymentDetails(String memberID, String memberAmount) {
    p_mid.setText(memberID);      
    p_amount.setText(memberAmount); 
    p_id.setText("NEW");
}
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        type = new javax.swing.JComboBox<>();
        firstname2 = new javax.swing.JLabel();
        firstname4 = new javax.swing.JLabel();
        add1 = new javax.swing.JPanel();
        st_label = new javax.swing.JLabel();
        firstname5 = new javax.swing.JLabel();
        firstname6 = new javax.swing.JLabel();
        p_id = new javax.swing.JLabel();
        p_amount = new javax.swing.JTextField();
        p_mid = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        type.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Gcash", "Card" }));
        type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeActionPerformed(evt);
            }
        });
        jPanel3.add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, -1));

        firstname2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        firstname2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname2.setText("Payment Type:");
        jPanel3.add(firstname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, 30));

        firstname4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        firstname4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname4.setText("Amount:");
        jPanel3.add(firstname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 80, 30));

        add1.setBackground(new java.awt.Color(204, 204, 204));
        add1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add1MouseExited(evt);
            }
        });
        add1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        st_label.setBackground(new java.awt.Color(255, 255, 255));
        st_label.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        st_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        st_label.setText("Label");
        add1.add(st_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 60, -1));

        jPanel3.add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, 40));

        firstname5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        firstname5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname5.setText("Payments Id:");
        jPanel3.add(firstname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 110, 30));

        firstname6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        firstname6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname6.setText(" Members Id:");
        jPanel3.add(firstname6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 30));
        jPanel3.add(p_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 120, 30));
        jPanel3.add(p_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, 30));
        jPanel3.add(p_mid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 140, 30));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PAYMENTS FORM");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 240, 20));

        jPanel5.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 40));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/wrong.png"))); // NOI18N
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 70, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 387, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeActionPerformed

    }//GEN-LAST:event_typeActionPerformed

    private void add1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseClicked
   if (validateRegister() == 1) {
    configclass dbc = new configclass();
    String sql;

    if (action.equals("Add")) {
        // INSERT: p_id is handled by database AUTOINCREMENT
        sql = "INSERT INTO payments (m_id, p_amount, p_type) "
            + "VALUES ('" + p_mid.getText() + "', "
            + "'" + p_amount.getText() + "', "
            + "'" + type.getSelectedItem().toString() + "')";

        if (dbc.insertData(sql) == 1) {
            JOptionPane.showMessageDialog(null, "New Payment Recorded!");
            close();
        }
    } else if (action.equals("Update")) {
        // UPDATE: Uses the p_id Label to match the specific receipt
        sql = "UPDATE payments SET "
            + "p_type = '" + type.getSelectedItem().toString() + "' "
            + "WHERE p_id = '" + p_id.getText() + "'";

        dbc.updateData(sql);
        JOptionPane.showMessageDialog(null, "Payment Updated!");
        close();
    }
}

    }//GEN-LAST:event_add1MouseClicked

    private void add1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseEntered

    }//GEN-LAST:event_add1MouseEntered

    private void add1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add1MouseExited

    }//GEN-LAST:event_add1MouseExited

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
    public javax.swing.JPanel add1;
    private javax.swing.JLabel firstname2;
    private javax.swing.JLabel firstname4;
    private javax.swing.JLabel firstname5;
    private javax.swing.JLabel firstname6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JTextField p_amount;
    public javax.swing.JLabel p_id;
    public javax.swing.JTextField p_mid;
    public javax.swing.JLabel st_label;
    public javax.swing.JComboBox<String> type;
    // End of variables declaration//GEN-END:variables
}
