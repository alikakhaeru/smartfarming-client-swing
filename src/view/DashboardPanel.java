package view;

import javax.swing.*;
import java.awt.*;

public class DashboardPanel extends JPanel {
    public JButton btnLahan = new JButton("Data Lahan");
    public JButton btnSensor = new JButton("Monitoring Sensor");
    public JButton btnTanaman = new JButton("Data Tanaman");
    public JPanel contentPanel = new JPanel(new CardLayout());

    public LahanPanel lahanPanel = new LahanPanel();
    public SensorPanel sensorPanel = new SensorPanel();
    public TanamanPanel tanamanPanel = new TanamanPanel();

    public DashboardPanel() {
        setLayout(new BorderLayout());

        // Sidebar Styling
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(new Color(242, 242, 242)); // Abu-abu sangat muda
        sidebar.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.LIGHT_GRAY));

        // Judul Aplikasi di Sidebar
        JLabel appTitle = new JLabel("SMART FARMING");
        appTitle.setFont(new Font("SansSerif", Font.BOLD, 18));
        appTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        sidebar.add(appTitle);

        // Styling Tombol Menu
        styleMenuButton(btnLahan);
        styleMenuButton(btnSensor);
        styleMenuButton(btnTanaman);

        sidebar.add(btnLahan);
        sidebar.add(btnSensor);
        sidebar.add(btnTanaman);

        contentPanel.add(lahanPanel, "LAHAN");
        contentPanel.add(sensorPanel, "SENSOR");
        contentPanel.add(tanamanPanel, "TANAMAN");
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(sidebar, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void styleMenuButton(JButton btn) {
        btn.setPreferredSize(new Dimension(190, 40));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setFocusPainted(false);
        btn.putClientProperty("JButton.buttonType", "roundRect"); // FlatLaf feature
    }

    public void showPage(String name) {
        ((CardLayout) contentPanel.getLayout()).show(contentPanel, name);
    }
}