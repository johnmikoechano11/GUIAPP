/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import config.configclass;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import main_app.exerciseForm;

/**
 *
 * @author Angie
 */
public class exercise_page extends javax.swing.JInternalFrame {

    /**
     * Creates new form exercise_page
     */
    public exercise_page() {
        initComponents();
        
               this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
    BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
    bi.setNorthPane(null);
    displayData(); 

     
    exercise_table.setRowHeight(30);
    exercise_table.setShowGrid(false);
    exercise_table.setIntercellSpacing(new java.awt.Dimension(0,0));
    exercise_table.setBackground(Color.WHITE);
    exercise_table.setBorder(null);


    exercise_table.getTableHeader().setOpaque(false);
    exercise_table.getTableHeader().setPreferredSize(new java.awt.Dimension(100, 35));

exercise_table.getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        setBackground(new Color(240, 240, 240)); 
        setForeground(new Color(51, 51, 51));
        

        setFont(new Font("Segoe UI", Font.BOLD, 16));
        

        setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10)); 
        
        return this;
    }
});


exercise_table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
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
    config.configclass cc = new config.configclass();

    String query = "SELECT ex_id, exercise_name, sets, reps, rest_time FROM exercises";
    cc.displayData(query, exercise_table);
}
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        exercise_table = new javax.swing.JTable();
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
        header = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        body.setBackground(new java.awt.Color(244, 247, 246));
        body.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exercise_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(exercise_table);

        body.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 650, 240));

        nav_panel.setBackground(new java.awt.Color(27, 42, 78));
        nav_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        search3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        search3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        body.add(nav_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 670, 80));

        getContentPane().add(body, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 670, 390));

        header.setBackground(new java.awt.Color(27, 42, 78));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("EXERCISE");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 60));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search3MouseClicked
        
    }//GEN-LAST:event_search3MouseClicked

    private void search3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search3ActionPerformed

    }//GEN-LAST:event_search3ActionPerformed

    private void searchUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchUserMouseClicked
        config.configclass conf = new config.configclass();
        String txt = search3.getText();

      String query = "SELECT ex_id, exercise_name, sets, reps, rest_time FROM exercises "
                 + "WHERE UPPER(exercise_name) LIKE UPPER('%" + txt + "%')";
        conf.displayData(query, exercise_table);
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

    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited

    }//GEN-LAST:event_refreshMouseExited

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked
        JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        mainFrame.dispose();
        exerciseForm stf = new exerciseForm();
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
    int rowIndex = exercise_table.getSelectedRow();
    
    if(rowIndex < 0){
        JOptionPane.showMessageDialog(null, "Please Select an Item!");
    } else {
        TableModel model = exercise_table.getModel();
        exerciseForm stf = new exerciseForm();
        
        
        stf.ex_id.setText(model.getValueAt(rowIndex, 0).toString());     
        stf.ex_name.setText(model.getValueAt(rowIndex, 1).toString());   
        stf.rest.setText(model.getValueAt(rowIndex, 4).toString()); 
        

        try {
           
            int setsValue = Integer.parseInt(model.getValueAt(rowIndex, 2).toString());
            int repsValue = Integer.parseInt(model.getValueAt(rowIndex, 3).toString());
            
            stf.Sets.setValue(setsValue);
            stf.Reps.setValue(repsValue);
        } catch (NumberFormatException e) {
          
            stf.Sets.setValue(1);
            stf.Reps.setValue(1);
        }

        stf.setVisible(true);
        stf.action = "Update";
        stf.st_label.setText("UPDATE");

        // Close current window
        JFrame mainFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (mainFrame != null) {
            mainFrame.dispose();
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
        int rowIndex = exercise_table.getSelectedRow();
        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select data first from the table!");
        }else{
            TableModel model = exercise_table.getModel();
            Object value = model.getValueAt(rowIndex, 0);
            String id = value.toString();
            int a = JOptionPane.showConfirmDialog(null, "Are you sure to delete ID: "+id);
            if(a == JOptionPane.YES_OPTION){
                configclass dbc = new configclass();
                int u_id = Integer.parseInt(id);
                dbc.deleteData(u_id, "exercises", "ex_id");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Add;
    private javax.swing.JPanel Edit;
    private javax.swing.JPanel body;
    private javax.swing.JPanel delete;
    private javax.swing.JTable exercise_table;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel nav_panel;
    private javax.swing.JPanel refresh;
    private javax.swing.JLabel search;
    private javax.swing.JLabel search1;
    private javax.swing.JLabel search2;
    private javax.swing.JTextField search3;
    private javax.swing.JLabel search4;
    private javax.swing.JPanel searchUser;
    // End of variables declaration//GEN-END:variables
}
