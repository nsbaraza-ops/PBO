package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection con;

    public static Connection getConnection() {
        if (con == null) {
            try {
                // Menghubungkan ke database 'pbo' di phpMyAdmin lokal
                con = DriverManager.getConnection("jdbc:mysql://localhost/pbo", "root", "");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Koneksi ke Database Gagal! Pastikan XAMPP sudah aktif.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return con;
    }
}