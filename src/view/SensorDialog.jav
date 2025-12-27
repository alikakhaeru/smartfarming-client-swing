package view;

import javax.swing.*;
import java.awt.*;
import model.Sensor;

public class SensorDialog extends JDialog {
    private JTextField txtLahanId = new JTextField(20);
    private JTextField txtSuhu = new JTextField(20);
    private JTextField txtKelembapan = new JTextField(20);
    private JTextField txtCahaya = new JTextField(20);
    private JButton btnSimpan = new JButton("Simpan");
    
    private boolean save = false;
    private Sensor sensor;

    public SensorDialog(Sensor sensor) {
        this.sensor = sensor;
        setTitle(sensor == null ? "Tambah Data Sensor" : "Edit Data Sensor");
        setModal(true);
        setLayout(new GridLayout(5, 2, 10, 10));

        if (sensor != null) {
            txtLahanId.setText(String.valueOf(sensor.lahan_id));
            txtSuhu.setText(String.valueOf(sensor.suhu));
            txtKelembapan.setText(String.valueOf(sensor.kelembapan_tanah));
            txtCahaya.setText(String.valueOf(sensor.intensitas_cahaya));
        }

        add(new JLabel(" ID Lahan:")); add(txtLahanId);
        add(new JLabel(" Suhu:")); add(txtSuhu);
        add(new JLabel(" Kelembapan:")); add(txtKelembapan);
        add(new JLabel(" Cahaya:")); add(txtCahaya);
        add(new JButton("Batal") {{ addActionListener(e -> dispose()); }});
        add(btnSimpan);

        btnSimpan.addActionListener(e -> {
            try {
                if (this.sensor == null) this.sensor = new Sensor();
                this.sensor.lahan_id = Integer.parseInt(txtLahanId.getText());
                this.sensor.suhu = Double.parseDouble(txtSuhu.getText());
                this.sensor.kelembapan_tanah = Double.parseDouble(txtKelembapan.getText());
                this.sensor.intensitas_cahaya = Double.parseDouble(txtCahaya.getText());
                save = true;
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Input harus angka!");
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public boolean isSave() { return save; }
    public Sensor getSensor() { return sensor; }
}