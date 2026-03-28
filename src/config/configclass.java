package config;

import java.sql.*;
import static javax.management.remote.JMXConnectorFactory.connect;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import main_app.logIn;

public class configclass {

   public Connection connectDB() {
    try {
        Class.forName("org.sqlite.JDBC");
        Connection con = DriverManager.getConnection("jdbc:sqlite:gymsystem.db");

        // Enable WAL mode to reduce locking issues
        try (Statement stmt = con.createStatement()) {
            stmt.execute("PRAGMA journal_mode=WAL;");
        }

        return con;
    } catch (Exception e) {
        System.out.println("Connection Failed: " + e);
        return null;
    }
}

    // Insert data safely
    public int insertData(String sql) {
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.executeUpdate();
            System.out.println("Inserted Successfully!");
            return 1;
        } catch (SQLException ex) {
            System.out.println("Insert Error: " + ex);
            return 0;
        }
    }

    // Update data safely
    public void updateData(String sql) {
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully!");
            } else {
                System.out.println("Data Update Failed!");
            }
        } catch (SQLException ex) {
            System.out.println("Update Error: " + ex);
        }
    }

    // Delete safely
    public void deleteData(int id, String table, String table_id) {
        String sql = "DELETE FROM " + table + " WHERE " + table_id + " = ?";
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rowsDeleted = pst.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Deleted Successfully!");
            } else {
                System.out.println("Deletion Failed!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data cannot be deleted\nContact the administrator.");
        }
    }

    // Authentication safely
    public String authenticate(String sql, Object... values) {
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql)) {

            for (int i = 0; i < values.length; i++) {
                pst.setObject(i + 1, values[i]);
            }

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("u_status");
                }
            }
        } catch (SQLException e) {
            System.out.println("Login Error: " + e.getMessage());
        }
        return null;
    }

    // Display data safely
    public void displayData(String sql, javax.swing.JTable table) {
        try (Connection conn = connectDB();
             PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println("Error displaying data: " + e.getMessage());
        }
    }

    // Get data safely: return ResultSet and ensure caller closes it
    public ResultSet getData(String sql) throws SQLException {
        Connection conn = connectDB();
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(sql); // caller must close ResultSet, Statement, Connection
    }

    // Same for viewData
    public ResultSet viewData(String sql, Object[] values) throws SQLException {
        Connection conn = connectDB();
        PreparedStatement pst = conn.prepareStatement(sql);
        for (int i = 0; i < values.length; i++) {
            pst.setObject(i + 1, values[i]);
        }
        return pst.executeQuery();
    }
    
public boolean isDuplicate(String sql) {
 
    try (Connection conn = connectDB();
         PreparedStatement pst = conn.prepareStatement(sql);
         ResultSet rs = pst.executeQuery()) {
        
        return rs.next(); 
    } catch (SQLException ex) {
        System.out.println("Check Error: " + ex.getMessage());
        return false;
    }
}
}