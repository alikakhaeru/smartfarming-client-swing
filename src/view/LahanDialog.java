package view;

import javax.swing.*;
import java.awt.*;
import model.Lahan;

public class LahanDialog extends JDialog {
    private JTextField txtNama = new JTextField(20);
    private JTextField txtLokasi = new JTextField(20);
    private JTextField txtLuas = new JTextField(20);
    private JTextField txtTanamanId = new JTextField(20); // Sementara pakai ID
    private JButton btnSimpan = new JButton("Simpan");
    private JButton btnBatal = new JButton("Batal");
    
    private boolean save = false;
    private Lahan lahan;

    public LahanDialog(Lahan lahan) {
        this.lahan = lahan;
        setTitle(lahan == null ? "Tambah Lahan" : "Edit Lahan");
        setModal(true);
        setLayout(new GridLayout(5, 2, 10, 10));

        // Jika Edit, isi field dengan data lama
        if (lahan != null) {
            txtNama.setText(lahan.nama_lahan);
            txtLokasi.setText(lahan.lokasi);
            txtLuas.setText(String.valueOf(lahan.luas));
            txtTanamanId.setText(String.valueOf(lahan.tanaman_id));
        }

        add(new JLabel(" Nama Lahan:")); add(txtNama);
        add(new JLabel(" Lokasi:")); add(txtLokasi);
        add(new JLabel(" Luas:")); add(txtLuas);
        add(new JLabel(" ID Tanaman:")); add(txtTanamanId);
        add(btnBatal); add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            if (validateInput()) {
                if (this.lahan == null) this.lahan = new Lahan();
                this.lahan.nama_lahan = txtNama.getText();
                this.lahan.lokasi = txtLokasi.getText();
                this.lahan.luas = Double.parseDouble(txtLuas.getText());
                this.lahan.tanaman_id = Integer.parseInt(txtTanamanId.getText());
                save = true;
                dispose();
            }
        });

        btnBatal.addActionListener(e -> dispose());
        
        pack();
        setLocationRelativeTo(null);
    }

    private boolean validateInput() {
        try {
            Double.parseDouble(txtLuas.getText());
            Integer.parseInt(txtTanamanId.getText());
            return !txtNama.getText().isEmpty();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Input Luas/ID harus angka!");
            return false;
        }
    }

    public boolean isSave() { return save; }
    public Lahan getLahan() { return lahan; }
}