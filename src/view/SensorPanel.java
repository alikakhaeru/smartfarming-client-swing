package view;

import javax.swing.*;
import java.awt.*;

public class SensorPanel extends JPanel {

    public JTable table = new JTable();
    public JButton btnRefresh = new JButton("Refresh");

    public SensorPanel() {
        setLayout(new BorderLayout(10,10));
        JLabel title = new JLabel("Monitoring Sensor");
        title.setFont(title.getFont().deriveFont(Font.BOLD,18));

        add(title, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnRefresh, BorderLayout.SOUTH);
    }
}
