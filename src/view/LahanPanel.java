package view;

import javax.swing.*;
import java.awt.*;

public class LahanPanel extends JPanel {
    public JTable table = new JTable();
    public JButton btnTambah = new JButton("Tambah Lahan");
    public JButton btnHapus = new JButton("Hapus");
    public JButton btnRefresh = new JButton("Refresh");

    public LahanPanel() {
        setLayout(new BorderLayout(0, 15));
        setBackground(Color.WHITE);

        // Header Section
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        JLabel title = new JLabel("Manajemen Lahan");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        header.add(title, BorderLayout.WEST);

        // Button Panel
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        btnPanel.setOpaque(false);
        
        btnTambah.putClientProperty("JButton.buttonType", "roundRect");
        btnTambah.setBackground(new Color(40, 167, 69)); // Hijau
        btnTambah.setForeground(Color.WHITE);
        
        btnHapus.putClientProperty("JButton.buttonType", "roundRect");
        btnHapus.setBackground(new Color(220, 53, 69)); // Merah
        btnHapus.setForeground(Color.WHITE);
        
        btnPanel.add(btnRefresh);
        btnPanel.add(btnHapus);
        btnPanel.add(btnTambah);
        header.add(btnPanel, BorderLayout.EAST);

        // Table Styling
        table.setRowHeight(35);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setShowGrid(false); // Hanya grid horizontal
        table.setSelectionBackground(new Color(232, 245, 233));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(230, 230, 230)));

        add(header, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}