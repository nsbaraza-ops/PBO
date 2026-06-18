package gui;

import database.DBConnection;
import model.Mhs;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FormNilaiMhs extends JFrame {
    // Komponen Input Form
    private JTextField txtNim, txtNama, txtUts, txtUas, txtTugas;
    private JTable tabelMhs;
    private DefaultTableModel tableModel;
    private JButton btnSimpan, btnUpdate, btnHapus, btnClear, btnKeluar;

    public FormNilaiMhs() {
        setTitle("Sistem Informasi Penilaian Mahasiswa - Tugas PBO Optimasi");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
        tampilkanDataDiTabel();
    }

    private void initComponents() {
        // Main Panel dengan Layout Border
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(245, 247, 250));

        // 1. Panel Judul (Header)
        JLabel lblHeader = new JLabel("Form Penginputan & Penilaian Mahasiswa", JLabel.CENTER);
        lblHeader.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblHeader.setForeground(new Color(44, 62, 80));
        mainPanel.add(lblHeader, BorderLayout.NORTH);

        // 2. Panel Kiri (Input Form)
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.white);
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 224, 230), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 8, 8, 8);

        // Styling Label & Textfield
        Font labelFont = new Font("Segoe UI", Font.BOLD, 13);
        
        // NIM
        gbc.gridx = 0; gbc.gridy = 0;
        JLabel lblNim = new JLabel("NIM (Primary Key):");
        lblNim.setFont(labelFont);
        formPanel.add(lblNim, gbc);
        gbc.gridx = 1;
        txtNim = new JTextField(15);
        formPanel.add(txtNim, gbc);

        // Nama
        gbc.gridx = 0; gbc.gridy = 1;
        JLabel lblNama = new JLabel("Nama Lengkap:");
        lblNama.setFont(labelFont);
        formPanel.add(lblNama, gbc);
        gbc.gridx = 1;
        txtNama = new JTextField(15);
        formPanel.add(txtNama, gbc);

        // UTS
        gbc.gridx = 0; gbc.gridy = 2;
        JLabel lblUts = new JLabel("Nilai UTS (35%):");
        lblUts.setFont(labelFont);
        formPanel.add(lblUts, gbc);
        gbc.gridx = 1;
        txtUts = new JTextField(15);
        formPanel.add(txtUts, gbc);

        // UAS
        gbc.gridx = 0; gbc.gridy = 3;
        JLabel lblUas = new JLabel("Nilai UAS (35%):");
        lblUas.setFont(labelFont);
        formPanel.add(lblUas, gbc);
        gbc.gridx = 1;
        txtUas = new JTextField(15);
        formPanel.add(txtUas, gbc);

        // Tugas
        gbc.gridx = 0; gbc.gridy = 4;
        JLabel lblTugas = new JLabel("Nilai Tugas (30%):");
        lblTugas.setFont(labelFont);
        formPanel.add(lblTugas, gbc);
        gbc.gridx = 1;
        txtTugas = new JTextField(15);
        formPanel.add(txtTugas, gbc);

        // Panel Tombol di bawah form input
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 8, 8));
        buttonPanel.setBackground(Color.WHITE);

        btnSimpan = new JButton("Simpan");
        btnUpdate = new JButton("Update");
        btnHapus = new JButton("Hapus");
        btnClear = new JButton("Reset");
        btnKeluar = new JButton("Keluar");

        // Styling Tombol
        JButton[] buttons = {btnSimpan, btnUpdate, btnHapus, btnClear, btnKeluar};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Segoe UI", Font.BOLD, 12));
            btn.setFocusPainted(false);
            btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        btnSimpan.setBackground(new Color(46, 204, 113)); btnSimpan.setForeground(Color.BLACK);
        btnUpdate.setBackground(new Color(52, 152, 219)); btnUpdate.setForeground(Color.BLACK);
        btnHapus.setBackground(new Color(231, 76, 60)); btnHapus.setForeground(Color.BLACK);
        btnClear.setBackground(new Color(241, 196, 15)); btnClear.setForeground(Color.BLACK);
        btnKeluar.setBackground(new Color(149, 165, 166)); btnKeluar.setForeground(Color.BLACK);

        buttonPanel.add(btnSimpan);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnHapus);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnKeluar);

        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        mainPanel.add(formPanel, BorderLayout.WEST);

        // 3. Panel Kanan (Tabel Data)
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBackground(Color.WHITE);
        tablePanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 224, 230), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        String[] headers = {"No", "NIM", "Nama", "UTS", "UAS", "Tugas", "Nilai Akhir", "Huruf", "Predikat"};
        tableModel = new DefaultTableModel(headers, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Tabel tidak bisa diedit secara langsung demi keamanan data
            }
        };

        tabelMhs = new JTable(tableModel);
        tabelMhs.setRowHeight(25);
        tabelMhs.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tabelMhs.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(tabelMhs);
        tablePanel.add(scrollPane, BorderLayout.CENTER);

        mainPanel.add(tablePanel, BorderLayout.CENTER);

        add(mainPanel);

        // REGISTER EVENT LISTENERS
        btnSimpan.addActionListener(e -> simpanData());
        btnUpdate.addActionListener(e -> updateData());
        btnHapus.addActionListener(e -> hapusData());
        btnClear.addActionListener(e -> clearForm());
        btnKeluar.addActionListener(e -> System.exit(0));

        // Event saat baris tabel diklik oleh mouse (mengisi form input secara otomatis)
        tabelMhs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tabelMhs.getSelectedRow();
                if (row != -1) {
                    txtNim.setText(tableModel.getValueAt(row, 1).toString());
                    txtNim.setEditable(false); // Kunci field NIM agar tidak bisa diedit saat proses update
                    txtNama.setText(tableModel.getValueAt(row, 2).toString());
                    txtUts.setText(tableModel.getValueAt(row, 3).toString());
                    txtUas.setText(tableModel.getValueAt(row, 4).toString());
                    txtTugas.setText(tableModel.getValueAt(row, 5).toString());
                }
            }
        });
    }

    // ==========================================
    // METHOD OPTIMASI DATABASE & BUSINESS LOGIC
    // ==========================================

    // Method Mengambil Data (Sesuai dengan Bagian 3 Analisis Optimasi)
    private List<Mhs> getMhsList() {
        List<Mhs> mhsList = new ArrayList<>();
        String query = "SELECT * FROM mhs";
        Connection con = DBConnection.getConnection();

        if (con == null) return mhsList;

        // Try-with-resources: resource otomatis ditutup setelah dipakai
        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                Mhs m = new Mhs(
                        rs.getString("nim"),
                        rs.getString("nama"),
                        rs.getDouble("nilai_uts"),
                        rs.getDouble("nilai_uas"),
                        rs.getDouble("nilai_tugas")
                );
                mhsList.add(m);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Gagal mengambil data database: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
        return mhsList;
    }

    // Menampilkan List Mahasiswa ke Komponen JTable
    private void tampilkanDataDiTabel() {
        tableModel.setRowCount(0); // Kosongkan tabel terlebih dahulu
        List<Mhs> list = getMhsList();

        Object[] row = new Object[9];
        for (int i = 0; i < list.size(); i++) {
            Mhs m = list.get(i);
            double na = m.nilaiAkhir();
            char huruf = m.getNilHuruf(na);

            row[0] = i + 1; // Nomor urut baris
            row[1] = m.getNim();
            row[2] = m.getNama();
            row[3] = m.getNilaiUts();
            row[4] = m.getNilaiUas();
            row[5] = m.getNilaiTugas();
            row[6] = String.format("%.2f", na);
            row[7] = huruf;
            row[8] = m.getPredikat(huruf);

            tableModel.addRow(row);
        }
    }

    // Menyimpan Mahasiswa Baru ke Database
    private void simpanData() {
        if (validasiInput()) {
            String query = "INSERT INTO mhs (nim, nama, nilai_uts, nilai_uas, nilai_tugas, nilai_akhir, nilai_huruf, predikat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            Connection con = DBConnection.getConnection();

            try (PreparedStatement ps = con.prepareStatement(query)) {
                Mhs m = new Mhs(
                        txtNim.getText().trim(),
                        txtNama.getText().trim(),
                        Double.parseDouble(txtUts.getText().trim()),
                        Double.parseDouble(txtUas.getText().trim()),
                        Double.parseDouble(txtTugas.getText().trim())
                );
                
                double na = m.nilaiAkhir();
                char huruf = m.getNilHuruf(na);
                String predikat = m.getPredikat(huruf);

                ps.setString(1, m.getNim());
                ps.setString(2, m.getNama());
                ps.setDouble(3, m.getNilaiUts());
                ps.setDouble(4, m.getNilaiUas());
                ps.setDouble(5, m.getNilaiTugas());
                ps.setDouble(6, na);
                ps.setString(7, String.valueOf(huruf));
                ps.setString(8, predikat);

                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data Mahasiswa berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                tampilkanDataDiTabel();
                clearForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "NIM sudah terdaftar atau terjadi kesalahan database!", "Error Simpan", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Melakukan Perubahan/Update Data Mahasiswa
    private void updateData() {
        if (validasiInput()) {
            String query = "UPDATE mhs SET nama=?, nilai_uts=?, nilai_uas=?, nilai_tugas=?, nilai_akhir=?, nilai_huruf=?, predikat=? WHERE nim=?";
            Connection con = DBConnection.getConnection();

            try (PreparedStatement ps = con.prepareStatement(query)) {
                Mhs m = new Mhs(
                        txtNim.getText().trim(),
                        txtNama.getText().trim(),
                        Double.parseDouble(txtUts.getText().trim()),
                        Double.parseDouble(txtUas.getText().trim()),
                        Double.parseDouble(txtTugas.getText().trim())
                );

                double na = m.nilaiAkhir();
                char huruf = m.getNilHuruf(na);
                String predikat = m.getPredikat(huruf);

                ps.setString(1, m.getNama());
                ps.setDouble(2, m.getNilaiUts());
                ps.setDouble(3, m.getNilaiUas());
                ps.setDouble(4, m.getNilaiTugas());
                ps.setDouble(5, na);
                ps.setString(6, String.valueOf(huruf));
                ps.setString(7, predikat);
                ps.setString(8, m.getNim());

                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data Mahasiswa berhasil diperbarui!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    tampilkanDataDiTabel();
                    clearForm();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + ex.getMessage(), "Error Update", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Menghapus Data Mahasiswa
    private void hapusData() {
        String nim = txtNim.getText().trim();
        if (nim.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih baris tabel terlebih dahulu atau ketik NIM yang ingin dihapus!", "Pemberitahuan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int konfirmasi = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus mahasiswa dengan NIM " + nim + "?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (konfirmasi == JOptionPane.YES_OPTION) {
            String query = "DELETE FROM mhs WHERE nim=?";
            Connection con = DBConnection.getConnection();

            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, nim);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data Mahasiswa berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                tampilkanDataDiTabel();
                clearForm();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + ex.getMessage(), "Error Hapus", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Mereset Form Input
    private void clearForm() {
        txtNim.setText("");
        txtNim.setEditable(true); // Aktifkan kembali penginputan NIM baru
        txtNama.setText("");
        txtUts.setText("");
        txtUas.setText("");
        txtTugas.setText("");
        tabelMhs.clearSelection();
    }

    // Validasi Sederhana sebelum Data Dikirim ke Database
    private boolean validasiInput() {
        if (txtNim.getText().trim().isEmpty() || txtNama.getText().trim().isEmpty() ||
            txtUts.getText().trim().isEmpty() || txtUas.getText().trim().isEmpty() || txtTugas.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom form wajib diisi!", "Validasi Gagal", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        try {
            double uts = Double.parseDouble(txtUts.getText().trim());
            double uas = Double.parseDouble(txtUas.getText().trim());
            double tugas = Double.parseDouble(txtTugas.getText().trim());

            if (uts < 0 || uts > 100 || uas < 0 || uas > 100 || tugas < 0 || tugas > 100) {
                JOptionPane.showMessageDialog(this, "Nilai harus berada di rentang angka 0 - 100!", "Validasi Angka", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Format nilai UTS/UAS/Tugas harus berupa angka desimal atau bulat!", "Format Salah", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Entry Point Utama Aplikasi
    public static void main(String[] args) {
        // Menggunakan Look and Feel Sistem Operasi agar GUI Terlihat Modern
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new FormNilaiMhs().setVisible(true);
        });
    }
}
