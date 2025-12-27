package view;

import javax.swing.*;
import java.awt.*;

public class TanamanPanel extends JPanel {
    public JTable table = new JTable();
    public JButton btnAdd = new JButton("Tambah Tanaman");
    public JButton btnEdit = new JButton("Edit");
    public JButton btnDelete = new JButton("Hapus");
    public JButton btnRefresh = new JButton("Refresh");

    public TanamanPanel() {
        setLayout(new BorderLayout(0, 15));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- HEADER ---
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        JLabel title = new JLabel("Katalog Tanaman");
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        header.add(title, BorderLayout.WEST);

        // --- TOOLBAR ---
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        toolbar.setOpaque(false);

        // Styling Tombol
        styleButton(btnAdd, new Color(40, 167, 69));   // Hijau
        styleButton(btnEdit, new Color(0, 123, 255));  // Biru
        styleButton(btnDelete, new Color(220, 53, 69)); // Merah
        styleButton(btnRefresh, new Color(108, 117, 125)); // Abu-abu

        toolbar.add(btnRefresh);
        toolbar.add(btnDelete);
        toolbar.add(btnEdit);
        toolbar.add(btnAdd);
        header.add(toolbar, BorderLayout.EAST);

        // --- TABLE ---
        table.setRowHeight(35);
        table.setShowVerticalLines(false);
        table.setSelectionBackground(new Color(232, 245, 233));
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(240, 240, 240)));
        scrollPane.getViewport().setBackground(Color.WHITE);

        add(header, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void styleButton(JButton btn, Color bg) {
        btn.putClientProperty("JButton.buttonType", "roundRect");
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
    }
}