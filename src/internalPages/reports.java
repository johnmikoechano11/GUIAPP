/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internalPages;

import java.awt.Color;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Angie
 */
public class reports extends javax.swing.JInternalFrame {

    /**
     * Creates new form reports
     */
    public reports() {
        initComponents();
        getCardCount();
           
      this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
      BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
      bi.setNorthPane(null);
   
     showRevenueTrends(revenuePanel);
     showSignupTrend(signupPanel);
    }
    
   public void showRevenueTrends(javax.swing.JPanel displayPanel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            config.configclass con = new config.configclass();
            // Query for last 7 days of revenue
            String query = "SELECT t_date, SUM(t_amount) AS total FROM transactions GROUP BY t_date LIMIT 7";
            java.sql.ResultSet rs = con.getData(query);

            int count = 1;
            while (rs.next()) {
                dataset.addValue(rs.getDouble("total"), "Revenue", String.valueOf(count++));
            }

            JFreeChart barChart = ChartFactory.createBarChart(
                    "Weekly Revenue Trends", "", "",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            CategoryPlot plot = barChart.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setRangeGridlinePaint(new Color(240, 240, 240));

            // CUSTOM RENDERER: This fix ensures multiple colors appear
            BarRenderer renderer = new BarRenderer() {
                @Override
                public java.awt.Paint getItemPaint(int row, int col) {
                    switch (col % 3) {
                        case 0: return new Color(39, 174, 96);   // Emerald Green
                        case 1: return new Color(129, 171, 236);  // Soft Blue
                        case 2: return new Color(243, 156, 18);   // Orange
                        default: return Color.GRAY;
                    }
                }
            };

            // Disable glass effects to keep the "Modern Flat" look
            renderer.setBarPainter(new StandardBarPainter());
            renderer.setShadowVisible(false);
            plot.setRenderer(renderer);

            ChartPanel chartPanel = new ChartPanel(barChart);
            displayPanel.removeAll();
            displayPanel.setLayout(new java.awt.BorderLayout());
            displayPanel.add(chartPanel, java.awt.BorderLayout.CENTER);
            displayPanel.revalidate();
            displayPanel.repaint();

        } catch (Exception e) {
            System.out.println("Revenue Chart Error: " + e.getMessage());
        }
    }

    public void showSignupTrend(javax.swing.JPanel displayPanel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try {
            config.configclass con = new config.configclass();
            String query = "SELECT start_date, COUNT(*) AS daily_total FROM members GROUP BY start_date LIMIT 7";
            java.sql.ResultSet rs = con.getData(query);

            while (rs.next()) {
                dataset.addValue(rs.getDouble("daily_total"), "Signups", rs.getString("start_date"));
            }

            JFreeChart lineChart = ChartFactory.createLineChart(
                    "New Member Signups", "", "",
                    dataset, PlotOrientation.VERTICAL, false, true, false);

            CategoryPlot plot = lineChart.getCategoryPlot();
            plot.setBackgroundPaint(Color.WHITE);
            plot.setRangeGridlinePaint(new Color(240, 240, 240));

            org.jfree.chart.renderer.category.LineAndShapeRenderer renderer = new org.jfree.chart.renderer.category.LineAndShapeRenderer();
            renderer.setSeriesPaint(0, new Color(39, 174, 96)); // Emerald
            renderer.setSeriesStroke(0, new java.awt.BasicStroke(3.0f)); // Modern thick line
            
            plot.setRenderer(renderer);

            ChartPanel chartPanel = new ChartPanel(lineChart);
            displayPanel.removeAll();
            displayPanel.setLayout(new java.awt.BorderLayout());
            displayPanel.add(chartPanel, java.awt.BorderLayout.CENTER);
            displayPanel.revalidate();
            displayPanel.repaint();

        } catch (Exception e) {
            System.out.println("Signup Chart Error: " + e.getMessage());
        }
    }
    
public void getCardCount() {
    config.configclass con = new config.configclass();
    try {
        // 1. Total Revenue for the CURRENT MONTH
        String revQuery = "SELECT SUM(t_amount) FROM transactions "
                        + "WHERE strftime('%m', t_date) = strftime('%m', 'now') "
                        + "AND strftime('%Y', t_date) = strftime('%Y', 'now')";
        java.sql.ResultSet rsRev = con.getData(revQuery);
        if (rsRev.next()) {
            double totalRev = rsRev.getDouble(1);
            revenue.setText("₱" + String.format("%.2f", totalRev));
        }

        // 2. New Member Signups for the CURRENT MONTH
        String memQuery = "SELECT COUNT(*) FROM members "
                        + "WHERE strftime('%m', start_date) = strftime('%m', 'now') "
                        + "AND strftime('%Y', start_date) = strftime('%Y', 'now')";
        java.sql.ResultSet rsMem = con.getData(memQuery);
        if (rsMem.next()) {
            newmember.setText(String.valueOf(rsMem.getInt(1)));
        }

        // 3. Total Transactions for the CURRENT MONTH
        String transQuery = "SELECT COUNT(*) FROM transactions "
                          + "WHERE strftime('%m', t_date) = strftime('%m', 'now') "
                          + "AND strftime('%Y', t_date) = strftime('%Y', 'now')";
        java.sql.ResultSet rsTrans = con.getData(transQuery);
        if (rsTrans.next()) {
            trans.setText(String.valueOf(rsTrans.getInt(1)));
        }

    } catch (java.sql.SQLException e) {
        System.out.println("Reports Card Error: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = jPanel2 = new javax.swing.JPanel() {
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
        jPanel2.setOpaque(false);
        ;
        jPanel6 = jPanel6 = new javax.swing.JPanel() {
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
        jPanel6.setOpaque(false);
        ;
        jLabel1 = new javax.swing.JLabel();
        revenue = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = jPanel3 = new javax.swing.JPanel() {
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
        jPanel3.setOpaque(false);
        ;
        jPanel7 = jPanel7 = new javax.swing.JPanel() {
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
        jPanel7.setOpaque(false);
        ;
        jLabel2 = new javax.swing.JLabel();
        newmember = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = jPanel4 = new javax.swing.JPanel() {
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
        jPanel4.setOpaque(false);
        ;
        jPanel8 = jPanel8 = new javax.swing.JPanel() {
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
        jPanel8.setOpaque(false);
        ;
        jLabel3 = new javax.swing.JLabel();
        trans = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        revenuePanel = new javax.swing.JPanel();
        signupPanel = new javax.swing.JPanel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(243, 156, 18));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(230, 126, 34));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/revenue.png"))); // NOI18N
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 60));

        revenue.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        revenue.setForeground(new java.awt.Color(255, 255, 255));
        revenue.setText("0");
        revenue.setToolTipText("");
        jPanel2.add(revenue, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 30, 100, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Total Revenue This Month");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 100));

        jPanel3.setBackground(new java.awt.Color(39, 174, 96));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(33, 145, 80));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/new_user.png"))); // NOI18N
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 60));

        newmember.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        newmember.setForeground(new java.awt.Color(255, 255, 255));
        newmember.setText("0");
        newmember.setToolTipText("");
        jPanel3.add(newmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("New Member Signups");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 160, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 190, 100));

        jPanel4.setBackground(new java.awt.Color(127, 179, 213));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(93, 173, 226));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/payments.png"))); // NOI18N
        jPanel8.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, 50));

        jPanel4.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 60));

        trans.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        trans.setForeground(new java.awt.Color(255, 255, 255));
        trans.setText("0");
        trans.setToolTipText("");
        jPanel4.add(trans, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Transactions");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 70, 100, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 190, 100));

        javax.swing.GroupLayout revenuePanelLayout = new javax.swing.GroupLayout(revenuePanel);
        revenuePanel.setLayout(revenuePanelLayout);
        revenuePanelLayout.setHorizontalGroup(
            revenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        revenuePanelLayout.setVerticalGroup(
            revenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jPanel1.add(revenuePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 300, 250));

        javax.swing.GroupLayout signupPanelLayout = new javax.swing.GroupLayout(signupPanel);
        signupPanel.setLayout(signupPanelLayout);
        signupPanelLayout.setHorizontalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        signupPanelLayout.setVerticalGroup(
            signupPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jPanel1.add(signupPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 310, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel newmember;
    private javax.swing.JLabel revenue;
    private javax.swing.JPanel revenuePanel;
    private javax.swing.JPanel signupPanel;
    private javax.swing.JLabel trans;
    // End of variables declaration//GEN-END:variables
}
