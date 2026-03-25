/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main_app;

import internalPages.member;
import javax.swing.JOptionPane;
import internalPages.Transaction_page;
import config.configclass;
import java.awt.Color;

public class TransactionForm extends javax.swing.JFrame {

    public TransactionForm() {
        initComponents();
        fillTransactionCombo();
        this.setBackground(new java.awt.Color(0,0,0,0));
        java.time.LocalDate today = java.time.LocalDate.now();
    t_date.setText(today.toString());
    
    p_id.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        if (p_id.getSelectedItem() != null) {
            String selected = p_id.getSelectedItem().toString();
            String planID = selected.split(" - ")[0]; // Get the ID number
            
            try {
                configclass dbc = new configclass();
                
                java.sql.ResultSet rs = dbc.getData("SELECT p_amount FROM payments WHERE r_id = " + planID);
                
                if (rs.next()) {
                   
                    m_amount.setText(rs.getString("p_amount"));
                }
                rs.close();
            } catch (Exception e) {
                System.out.println("Error auto-filling amount: " + e.getMessage());
            }
        }
    }
    
     });       
    }

    
    int validateRegister() {
        if (m_amount.getText().equals("0.00") || m_amount.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Invalid amount!"); return 0;
        }
        return 1;
    }
   public String action;
   
    public void close(){
        this.dispose();
        dashboard dash = new dashboard();
        dash.setVisible(true);
        member up = new member();
        dash.maindesktop.add(up).setVisible(true);
    }
    private void fillTransactionCombo() {
    try {
        configclass dbc = new configclass();
        
            m_id.removeAllItems();
        p_id.removeAllItems(); // This is your p_id combo based on your variable declarations

        // 2. Populate Members Dropdown (m_id)
        java.sql.ResultSet rsMembers = dbc.getData("SELECT m_id, m_fname FROM members");
        while(rsMembers.next()) {
            m_id.addItem(rsMembers.getString("m_id") + " - " + rsMembers.getString("m_fname"));
        }
        rsMembers.close();

      
        java.sql.ResultSet rsPayments = dbc.getData("SELECT r_id FROM payments"); 
        while(rsPayments.next()) {
           
            p_id.addItem(rsPayments.getString("r_id"));
        }
        rsPayments.close();

    } catch(Exception e) {
        System.out.println("Error filling combos: " + e.getMessage());
    }
}
    public void printReceipt() {
    // 1. Get the data from your form fields
    String id = t_id.getText();
    String memberInfo = m_id.getSelectedItem().toString();
    String amount = m_amount.getText();
    String method = this.method.getSelectedItem().toString();
    String date = t_date.getText();
    String stat = status.getSelectedItem().toString();

  
    String receiptText = 
          "------------------------------------------\n"
        + "             AEROTICKET GYM               \n"
        + "           Official Receipt               \n"
        + "------------------------------------------\n"
        + " Date: " + date + "\n"
        + " Trans ID: " + id + "\n"
        + " Member:   " + memberInfo + "\n"
        + "------------------------------------------\n\n"
        + " Description             Amount           \n"
        + " Gym Membership Fee      " + amount + "           \n\n"
        + "------------------------------------------\n"
        + " Total Amount:           " + amount + "           \n"
        + " Payment Method:         " + method + "           \n"
        + " Status:                 " + stat + "             \n"
        + "------------------------------------------\n"
        + "        Thank you for your payment!       \n"
        + "        Please keep this receipt.         \n"
        + "------------------------------------------\n";

    // 3. Display it in a Pop-up (or send to a JTextArea in another Frame)
    javax.swing.JTextArea receiptArea = new javax.swing.JTextArea(receiptText);
    receiptArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12));
    receiptArea.setEditable(false);
    
    // Wrap it in a ScrollPane in case it gets long
    javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(receiptArea);
    scrollPane.setPreferredSize(new java.awt.Dimension(350, 450));

    JOptionPane.showMessageDialog(null, scrollPane, "Print Preview", JOptionPane.PLAIN_MESSAGE);
    
    try {
        receiptArea.print();
    } catch (java.awt.print.PrinterException e) {
        JOptionPane.showMessageDialog(null, "Printer Error: " + e.getMessage());
    }
}
private void fetchPaymentAmount() {
    configclass dbc = new configclass();
    
    if (p_id.getSelectedItem() != null) {
        String selected = p_id.getSelectedItem().toString();
     
        String planId = selected.split(" - ")[0];
        
        try {

            java.sql.ResultSet rs = dbc.getData("SELECT p_amount FROM payments WHERE r_id = " + planId);
            
            if (rs.next()) {

                double amountValue = rs.getDouble("p_amount");
                m_amount.setText(String.format("%.2f", amountValue));
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error fetching p_amount: " + e.getMessage());
        }
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jPanel5 = new javax.swing.JPanel();
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
        jLabel1 = new javax.swing.JLabel();
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
        t_id = new javax.swing.JLabel();
        m_amount = new javax.swing.JTextField();
        firstname7 = new javax.swing.JLabel();
        firstname3 = new javax.swing.JLabel();
        firstname4 = new javax.swing.JLabel();
        t_date = new javax.swing.JTextField();
        m_id = new javax.swing.JComboBox<>();
        header1 = header = new javax.swing.JPanel() {
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
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        wrong1 = wrong = new javax.swing.JPanel() {
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
        jLabel4 = new javax.swing.JLabel();
        method = new javax.swing.JComboBox<>();
        p_id = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(27, 42, 78));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("PAYMENTS FORM");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 20));

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

        header.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 40));

        wrong.setBackground(new java.awt.Color(27, 42, 78));
        wrong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wrongMouseClicked(evt);
            }
        });
        wrong.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("×");
        wrong.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 50));

        header.add(wrong, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 80, 60));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, -1));

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
        body.add(firstname5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 110, 30));

        firstname6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname6.setForeground(new java.awt.Color(27, 42, 78));
        firstname6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname6.setText(" Members Id:");
        body.add(firstname6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, 30));

        t_id.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_id.setForeground(new java.awt.Color(27, 42, 78));
        body.add(t_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 30));

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
        firstname3.setText("Method:");
        body.add(firstname3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 30));

        firstname4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        firstname4.setForeground(new java.awt.Color(27, 42, 78));
        firstname4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        firstname4.setText("Transaction Date:");
        body.add(firstname4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 120, 30));

        t_date.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        t_date.setForeground(new java.awt.Color(27, 42, 78));
        t_date.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(209, 213, 216), java.awt.Color.darkGray, null, null));
        body.add(t_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 200, 30));

        m_id.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        m_id.setForeground(new java.awt.Color(27, 42, 78));
        m_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_idActionPerformed(evt);
            }
        });
        body.add(m_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 80, 30));

        header1.setBackground(new java.awt.Color(27, 42, 78));
        header1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("PAYMENTS FORM");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        header1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, 20));

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        header1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, -1, 40));

        wrong1.setBackground(new java.awt.Color(27, 42, 78));
        wrong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                wrong1MouseClicked(evt);
            }
        });
        wrong1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("×");
        wrong1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 30, 50));

        header1.add(wrong1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 0, 80, 60));

        body.add(header1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, -1));

        method.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        method.setForeground(new java.awt.Color(27, 42, 78));
        method.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Gcash", "Card" }));
        method.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                methodActionPerformed(evt);
            }
        });
        body.add(method, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, 30));

        p_id.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        p_id.setForeground(new java.awt.Color(27, 42, 78));
        p_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_idActionPerformed(evt);
            }
        });
        body.add(p_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 80, 30));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 520, 450));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void wrongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wrongMouseClicked
        // 1. Close this popup form
        this.dispose();

        // 2. Find the dashboard window you are already in
        javax.swing.JFrame topFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);

        try {
            // 3. Access the blue area (maindesktop)
            java.lang.reflect.Field field = topFrame.getClass().getDeclaredField("maindesktop");
            field.setAccessible(true);
            javax.swing.JDesktopPane desktop = (javax.swing.JDesktopPane) field.get(topFrame);

            // 4. Clear the screen and load the MEMBERS table
            desktop.removeAll();
            Transaction_page m = new Transaction_page(); // This loads your table page
            desktop.add(m).setVisible(true);

            // 5. Refresh the screen
            desktop.revalidate();
            desktop.repaint();

        } catch (Exception e) {

            System.out.println("Error returning to Members: " + e.getMessage());
        }
    }//GEN-LAST:event_wrongMouseClicked

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed

    }//GEN-LAST:event_statusActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
      if (validateRegister() == 1) {
    configclass dbc = new configclass();


    String selectedMember = m_id.getSelectedItem().toString();
    String memID = selectedMember.split(" - ")[0]; // t_id/m_id links
    
    String transID = t_id.getText();   // Maps to t_id (Primary Key)
    String amount  = m_amount.getText(); // Maps to t_amount (REAL)
    String method  = this.method.getSelectedItem().toString(); // Maps to t_method (TEXT)
    String date    = t_date.getText();   // Maps to t_date (TEXT)
    String stat    = status.getSelectedItem().toString(); // Maps to t_status (TEXT)

    String sql;

    if (action.equals("Add")) {
      
        sql = "INSERT INTO transactions (m_id, t_amount, t_method, t_date, t_status) "
            + "VALUES (" + memID + ", " + amount + ", '" + method + "', '" + date + "', '" + stat + "')";

        if (dbc.insertData(sql) == 1) {
            JOptionPane.showMessageDialog(null, "New Transaction Recorded!");
            
            int response = JOptionPane.showConfirmDialog(null, "Print receipt?", "Print", JOptionPane.YES_NO_OPTION);
            if(response == JOptionPane.YES_OPTION){
                printReceipt();
            }
            close();
        }
    } else if (action.equals("Update")) {
     
        sql = "UPDATE transactions SET "
            + "m_id = " + memID + ", "
            + "t_amount = " + amount + ", "
            + "t_method = '" + method + "', "
            + "t_date = '" + date + "', "
            + "t_status = '" + stat + "' "
            + "WHERE t_id = '" + transID + "'";

        dbc.updateData(sql);
        JOptionPane.showMessageDialog(null, "Transaction Updated!");
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

    private void addMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMousePressed
        add.setBackground(new Color(211, 84, 0));
    }//GEN-LAST:event_addMousePressed

    private void m_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_amountActionPerformed

    }//GEN-LAST:event_m_amountActionPerformed

    private void m_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_idActionPerformed

    }//GEN-LAST:event_m_idActionPerformed

    private void wrong1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_wrong1MouseClicked
        // 1. Close this popup form
        this.dispose();

        // 2. Find the dashboard window you are already in
        javax.swing.JFrame topFrame = (javax.swing.JFrame) javax.swing.SwingUtilities.getWindowAncestor(this);

        try {
            // 3. Access the blue area (maindesktop)
            java.lang.reflect.Field field = topFrame.getClass().getDeclaredField("maindesktop");
            field.setAccessible(true);
            javax.swing.JDesktopPane desktop = (javax.swing.JDesktopPane) field.get(topFrame);

            // 4. Clear the screen and load the MEMBERS table
            desktop.removeAll();
            member m = new member(); // This loads your table page
            desktop.add(m).setVisible(true);

            // 5. Refresh the screen
            desktop.revalidate();
            desktop.repaint();

        } catch (Exception e) {

            System.out.println("Error returning to Members: " + e.getMessage());
        }
    }//GEN-LAST:event_wrong1MouseClicked

    private void methodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_methodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_methodActionPerformed

    private void p_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_idActionPerformed
       fetchPaymentAmount();
    }//GEN-LAST:event_p_idActionPerformed

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
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel add;
    private javax.swing.JPanel body;
    private javax.swing.JLabel firstname2;
    private javax.swing.JLabel firstname3;
    private javax.swing.JLabel firstname4;
    private javax.swing.JLabel firstname5;
    private javax.swing.JLabel firstname6;
    private javax.swing.JLabel firstname7;
    private javax.swing.JPanel header;
    private javax.swing.JPanel header1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    public javax.swing.JTextField m_amount;
    public javax.swing.JComboBox<String> m_id;
    public javax.swing.JComboBox<String> method;
    public javax.swing.JComboBox<String> p_id;
    public javax.swing.JLabel st_label;
    public javax.swing.JComboBox<String> status;
    public javax.swing.JTextField t_date;
    public javax.swing.JLabel t_id;
    private javax.swing.JPanel wrong;
    private javax.swing.JPanel wrong1;
    // End of variables declaration//GEN-END:variables
}
