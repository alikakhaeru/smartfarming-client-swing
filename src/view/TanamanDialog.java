package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import model.Tanaman;

public class TanamanDialog extends JDialog {
    private JTextField txtNama = new JTextField(20);
    private JTextField txtJenis = new JTextField(20);
    private JButton btnSimpan = new JButton("Simpan Data");
    private JButton btnBatal = new JButton("Batal");
    private boolean save = false;
    private Tanaman tanaman;

    public TanamanDialog(Tanaman tanaman) {
        this.tanaman = tanaman;
        setTitle(tanaman == null ? "Tambah Tanaman Baru" : "Perbarui Data Tanaman");
        setModal(true);
        setLayout(new BorderLayout());

        // --- PANEL FORM ---
        JPanel pnlForm = new JPanel(new GridLayout(2, 2, 10, 15));
        pnlForm.setBorder(new EmptyBorder(25, 25, 25, 25)); // Padding agar lega
        
        pnlForm.add(new JLabel("Nama Tanaman:"));
        pnlForm.add(txtNama);
        pnlForm.add(new JLabel("Jenis/Varietas:"));
        pnlForm.add(txtJenis);

        // --- PANEL TOMBOL ---
        JPanel pnlBottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 15));
        pnlBottom.setBackground(new Color(245, 245, 245));
        
        // Styling Tombol Simpan
        btnSimpan.putClientProperty("JButton.buttonType", "roundRect");
        btnSimpan.setBackground(new Color(40, 167, 69));
        btnSimpan.setForeground(Color.WHITE);
        
        btnBatal.putClientProperty("JButton.buttonType", "roundRect");

        pnlBottom.add(btnBatal);
        pnlBottom.add(btnSimpan);

        // Isi data jika edit
        if (tanaman != null) {
            txtNama.setText(tanaman.nama);
            txtJenis.setText(tanaman.jenis);
        }

        add(pnlForm, BorderLayout.CENTER);
        add(pnlBottom, BorderLayout.SOUTH);

        // Event handling
        btnSimpan.addActionListener(e -> {
            if (txtNama.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama harus diisi!");
                return;
            }
            if (this.tanaman == null) this.tanaman = new Tanaman();
            this.tanaman.nama = txtNama.getText();
            this.tanaman.jenis = txtJenis.getText();
            save = true;
            dispose();
        });

        btnBatal.addActionListener(e -> dispose());

        pack();
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public boolean isSave() { return save; }
    public Tanaman getTanaman() { return tanaman; }
}