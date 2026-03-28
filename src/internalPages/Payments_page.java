/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import config.configclass;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import main_app.paymentsform;

/**
 *
 * @author Angie
 */
public class Payments_page extends javax.swing.JInternalFrame {

    /**
     * Creates new form Payments_page
     */
    public Payments_page() {
        initComponents();
        
        displayData();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        javax.swing.plaf.basic.BasicInternalFrameUI bi = (javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        paymentstable.setRowHeight(30);
        paymentstable.setShowGrid(false);
        paymentstable.setIntercellSpacing(new java.awt.Dimension(0,0));
        paymentstable.setBackground(Color.WHITE);
        paymentstable.setBorder(null);
        
        
        paymentstable.getTableHeader().setOpaque(false);
        paymentstable.getTableHeader().setPreferredSize(new java.awt.Dimension(100,35));
        
        paymentstable.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
         @Override
 public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
         setBackground(new Color(240, 240, 240));
         setForeground(new Color(51, 51, 51));
         
         setFont(new Font("Segoe UI", Font.BOLD, 16));
         
         setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
         setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
         
         return this;
         }
        });
        
        paymentstable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        c.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        if (isSelected) {
          
            c.setBackground(new Color(243, 156, 18)); 
            c.setForeground(Color.WHITE); 
        } else {
            
            c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(248, 249, 250));
            c.setForeground(new Color(27, 42, 78));
        }

        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)); 
        
        return c;
    }
});
  
 
javax.swing.border.Border line = javax.swing.BorderFactory.createLineBorder(new Color(200, 200, 200), 2);


javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5);


jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder(line, padding));


jScrollPane1.setBackground(Color.WHITE);
jScrollPane1.getViewport().setBackground(Color.WHITE);
    }
   
public void displayData() {
    config.configclass conf = new config.configclass();

    
    String query = "SELECT p.r_id AS 'Payment ID', "
                 + "m.m_id AS 'Member ID', "
                 + "p.p_amount AS 'Amount', "
                 + "p.p_type AS 'Payment Type', "
                 + "p.p_status AS 'Status' " 
                 + "FROM payments p "
                 + "JOIN members m ON p.m_id = m.m_id";

    conf.displayData(query, paymentstable);
}
    private void printReceipt(String id, String member, String amount, String date, String status) {
    System.out.println("-------------------------------------------");
    System.out.println("           GYM RECEIPT                     ");
    System.out.println("-------------------------------------------");
    System.out.println("Transaction ID: " + id);
    System.out.println("Member Name:    " + member);
    System.out.println("Amount Paid:    ₱" + amount);
    System.out.println("Date:           " + date);
    System.out.println("Status:         " + status);
    System.out.println("-------------------------------------------");
    System.out.println("       Thank you for your payment!         ");
    
    // This will show a quick confirmation to the user
    javax.swing.JOptionPane.showMessageDialog(null, "Receipt for ID " + id + " sent to console!");
}
        
        
     Color navcolor = new Color (102,102,102);
        Color headcolor = new Color (51,51,51);
        Color bodycolor = new Color (153,153,153);
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        paymentstable = new javax.swing.JTable();
        update = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        printBtn = Add = new javax.swing.JPanel() {
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
        Add.setOpaque(false);
        ;
        search5 = new javax.swing.JLabel();
        nav_panel = nav_panel = new javax.swing.JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                java.awt.Graphics2D g2 = (java.awt.Graphics2D) g.create();
                g2.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING, java.awt.RenderingHints.VALUE_ANTIALIAS_ON);

                int shadowSize = 10;
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
        nav_panel.setOpaque(false);
        search3 = new javax.swing.JTextField();
        searchUser = new javax.swing.JPanel();
        search = new javax.swing.JLabel();
        refresh = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Add = Add = new javax.swing.JPanel() {
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
        Add.setOpaque(false);
        ;
        search2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Edit = Edit = new javax.swing.JPanel() {
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
        Edit.setOpaque(false);
        ;
        search4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        delete = delete = new javax.swing.JPanel() {
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
        delete.setOpaque(false);
        ;
        search1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(244, 247, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paymentstable.setAutoCreateRowSorter(true);
        paymentstable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        paymentstable.setFont(new java.awt.Font("Century Gothic", 1, 10)); // NOI18N
        paymentstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        paymentstable.setSelectionBackground(new java.awt.Color(102, 102, 102));
        paymentstable.setSelectionForeground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setViewportView(paymentstable);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 650, 240));

        update.setBackground(new java.awt.Color(102, 102, 102));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateMouseExited(evt);
            }
        });
        update.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 80, -1));

        header.setBackground(new java.awt.Color(27, 42, 78));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PAYMENTS");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 150, 60));

        printBtn.setBackground(new java.awt.Color(93, 120, 193));
        printBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                printBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                printBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                printBtnMousePressed(evt);
            }
        });
        printBtn.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search5.setBackground(new java.awt.Color(51, 51, 51));
        search5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search5.setForeground(new java.awt.Color(255, 255, 255));
        search5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search5.setText("PRINT RECEIPT");
        printBtn.add(search5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 30));

        header.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 6, 140, 50));

        jPanel3.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 60));

        nav_panel.setBackground(new java.awt.Color(27, 42, 78));
        nav_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        search3.setBorder(null);
        search3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search3MouseClicked(evt);
            }
        });
        search3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search3ActionPerformed(evt);
            }
        });
        nav_panel.add(search3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, 180, 40));

        searchUser.setBackground(new java.awt.Color(243, 156, 18));
        searchUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchUserMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                searchUserMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                searchUserMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchUserMousePressed(evt);
            }
        });
        searchUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search.setBackground(new java.awt.Color(243, 156, 18));
        search.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/search.png"))); // NOI18N
        searchUser.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        nav_panel.add(searchUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 40, 40));

        refresh.setBackground(new java.awt.Color(153, 153, 153));
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshMouseExited(evt);
            }
        });
        refresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/refresh.png"))); // NOI18N
        refresh.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 30, 30));

        nav_panel.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 30, 40));

        Add.setBackground(new java.awt.Color(243, 156, 18));
        Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AddMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                AddMousePressed(evt);
            }
        });
        Add.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search2.setBackground(new java.awt.Color(51, 51, 51));
        search2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search2.setForeground(new java.awt.Color(255, 255, 255));
        search2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search2.setText("NEW USER");
        Add.add(search2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 90, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new_user.png"))); // NOI18N
        Add.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 50));

        nav_panel.add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 16, 120, 50));

        Edit.setBackground(new java.awt.Color(41, 128, 185));
        Edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EditMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                EditMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                EditMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                EditMousePressed(evt);
            }
        });
        Edit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search4.setBackground(new java.awt.Color(51, 51, 51));
        search4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search4.setForeground(new java.awt.Color(255, 255, 255));
        search4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search4.setText("EDIT USER");
        Edit.add(search4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 70, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/pencil.png"))); // NOI18N
        Edit.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 50));

        nav_panel.add(Edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 16, 120, -1));

        delete.setBackground(new java.awt.Color(192, 57, 43));
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteMousePressed(evt);
            }
        });
        delete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search1.setBackground(new java.awt.Color(51, 51, 51));
        search1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        search1.setForeground(new java.awt.Color(255, 255, 255));
        search1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search1.setText("DELETE RECORD");
        delete.add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 120, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete.png"))); // NOI18N
        delete.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 50));

        nav_panel.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 16, -1, 50));

        jPanel3.add(nav_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 670, 80));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseExited
        update.setBackground(navcolor);
    }//GEN-LAST:event_updateMouseExited

    private void updateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseEntered
        update.setBackground(bodycolor);
    }//GEN-LAST:event_updateMouseEntered

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked

    }//GEN-LAST:event_updateMouseClicked

    private void search3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_search3MouseClicked

    private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed

    }//GEN-LAST:event_search3ActionPerformed

    private void searchUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUserMouseClicked
       config.configclass conf = new config.configclass();
    String txt = search3.getText();


    String query = "SELECT p.r_id AS 'Payment ID', m.m_id AS 'Member ID', "
                 + "p.p_amount AS 'Amount', p.p_type AS 'Payment Type', p.p_status AS 'Status' "
                 + "FROM payments p JOIN members m ON p.m_id = m.m_id "
                 + "WHERE p.r_id LIKE '%" + txt + "%' OR m.m_id LIKE '%" + txt + "%'";

    conf.displayData(query, paymentstable);
    }//GEN-LAST:event_searchUserMouseClicked

    private void searchUserMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUserMouseEntered
        searchUser.setBackground(new Color(241, 196, 15));
    }//GEN-LAST:event_searchUserMouseEntered

    private void searchUserMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUserMouseExited
        searchUser.setBackground(new Color(243,156,18));
    }//GEN-LAST:event_searchUserMouseExited

    private void searchUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUserMousePressed
        searchUser.setBackground(new Color(214, 137, 16));
    }//GEN-LAST:event_searchUserMousePressed

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        // 1. Clear the white text field (search3), NOT the button label (search)
        search3.setText("");

        // 2. Reset the button text just in case it was deleted
        search.setText("SEARCH");

        // 3. Reload the table data
        displayData();
    }//GEN-LAST:event_refreshMouseClicked

    private void refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseEntered
        refresh.setBackground(bodycolor);
    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited
        refresh.setBackground(navcolor);
    }//GEN-LAST:event_refreshMouseExited

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
      JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
       mainFrame.dispose();
       paymentsform stf = new paymentsform();
       stf.setVisible(true);
       stf.action = "Add";
       stf.st_label.setText("SAVE");
    }//GEN-LAST:event_AddMouseClicked

    private void AddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseEntered
        Add.setBackground(new Color(241, 196, 15));
    }//GEN-LAST:event_AddMouseEntered

    private void AddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseExited
        Add.setBackground(new Color(243,156,18));
    }//GEN-LAST:event_AddMouseExited

    private void AddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMousePressed
        Add.setBackground(new Color(214, 137, 16));
    }//GEN-LAST:event_AddMousePressed

    private void EditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseClicked
     int rowIndex = paymentstable.getSelectedRow();

    if(rowIndex < 0){
        JOptionPane.showMessageDialog(null, "Please Select an Item!");
    } else {
        TableModel model = paymentstable.getModel();
    
        String id = model.getValueAt(rowIndex, 0).toString();

        try {
            config.configclass dbc = new config.configclass();
      
            ResultSet rs = dbc.getData("SELECT * FROM payments WHERE r_id = " + id);

            if(rs.next()){
                paymentsform stf = new paymentsform();

                stf.p_id.setText(rs.getString("r_id"));
                stf.m_id.setSelectedItem(rs.getString("m_id"));
                stf.m_amount.setText(rs.getString("p_amount"));
                
               
                stf.type.setSelectedItem(rs.getString("p_type")); 
                stf.status.setSelectedItem(rs.getString("p_status"));
                
                stf.p_date.setText(rs.getString("p_date"));

                stf.action = "Update";
                stf.st_label.setText("UPDATE");

                stf.setVisible(true);

           
                JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
                mainFrame.dispose();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_EditMouseClicked

    private void EditMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseEntered
        Edit.setBackground(new Color(52, 152, 219));
    }//GEN-LAST:event_EditMouseEntered

    private void EditMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMouseExited
        Edit.setBackground(new Color(41,128,185));
    }//GEN-LAST:event_EditMouseExited

    private void EditMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EditMousePressed
        Edit.setBackground(new Color(33, 97, 140));
    }//GEN-LAST:event_EditMousePressed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        int rowIndex = paymentstable.getSelectedRow();

    if(rowIndex < 0){
        JOptionPane.showMessageDialog(null, "Please select a payment record from the table!");
    } else {
        TableModel model = paymentstable.getModel();

        String paymentId = model.getValueAt(rowIndex, 0).toString();

        int confirm = JOptionPane.showConfirmDialog(null, 
                "Are you sure you want to delete Payment ID: " + paymentId + "?", 
                "Confirm Deletion", JOptionPane.YES_NO_OPTION);

        if(confirm == JOptionPane.YES_OPTION){
            config.configclass dbc = new config.configclass();
            

            dbc.deleteData(Integer.parseInt(paymentId), "payments", "r_id");

            JOptionPane.showMessageDialog(null, "Payment record removed successfully!");

 
            displayData();
        }
    }
    }//GEN-LAST:event_deleteMouseClicked

    private void deleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseEntered
        delete.setBackground(new Color(231, 76, 60));
    }//GEN-LAST:event_deleteMouseEntered

    private void deleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseExited
        delete.setBackground(new Color(192,57,43));
    }//GEN-LAST:event_deleteMouseExited

    private void deleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMousePressed
        delete.setBackground(new Color(146, 43, 33));
    }//GEN-LAST:event_deleteMousePressed

    private void printBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseClicked
    int rowIndex = paymentstable.getSelectedRow();
    
    if (rowIndex < 0) {
        javax.swing.JOptionPane.showMessageDialog(null, "Please select a payment record to print!");
    } else {
        TableModel model = paymentstable.getModel();
        
        // These indexes MUST match your SELECT query columns (0 to 4)
        String id = model.getValueAt(rowIndex, 0).toString();     // Payment ID
        String member = model.getValueAt(rowIndex, 1).toString(); // Member ID
        String amount = model.getValueAt(rowIndex, 2).toString(); // Amount
        String status = model.getValueAt(rowIndex, 4).toString(); // Status
        
        // Since your SQL query doesn't select the Date, we'll use the current system date
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        
        // Call the method you defined earlier
        printReceipt(id, member, amount, currentDate, status);
    }
    }//GEN-LAST:event_printBtnMouseClicked

    private void printBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_printBtnMouseEntered

    private void printBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_printBtnMouseExited

    private void printBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_printBtnMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Add;
    private javax.swing.JPanel Edit;
    private javax.swing.JPanel delete;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel nav_panel;
    public javax.swing.JTable paymentstable;
    private javax.swing.JPanel printBtn;
    private javax.swing.JPanel refresh;
    private javax.swing.JLabel search;
    private javax.swing.JLabel search1;
    private javax.swing.JLabel search2;
    private javax.swing.JTextField search3;
    private javax.swing.JLabel search4;
    private javax.swing.JLabel search5;
    private javax.swing.JPanel searchUser;
    private javax.swing.JPanel update;
    // End of variables declaration//GEN-END:variables
}
