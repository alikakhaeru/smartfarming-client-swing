package controller;

import javax.swing.JOptionPane;
import model.Tanaman;
import service.TanamanApiService;
import view.TanamanPanel;
import view.TanamanDialog;
import view.tablemodel.TanamanTableModel;
import worker.LoadTanamanWorker;

public class TanamanController {
    private final TanamanPanel panel;
    private final TanamanApiService apiService = new TanamanApiService();

    public TanamanController(TanamanPanel panel) {
        this.panel = panel;
        loadData();

        // Hubungkan Tombol dengan benar
        panel.btnRefresh.addActionListener(e -> loadData());
        panel.btnAdd.addActionListener(e -> aksiTambah());
        panel.btnEdit.addActionListener(e -> aksiEdit());
        panel.btnDelete.addActionListener(e -> aksiHapus());
    }

    private void loadData() {
        new LoadTanamanWorker(panel).execute();
    }

    private void aksiTambah() {
        TanamanDialog dialog = new TanamanDialog(null);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            try {
                apiService.save(dialog.getTanaman());
                loadData();
                JOptionPane.showMessageDialog(panel, "Tanaman berhasil disimpan!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage());
            }
        }
    }

    private void aksiEdit() {
        int row = panel.table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(panel, "Pilih baris dulu!");
            return;
        }

        // Casting model agar bisa panggil getTanamanAt
        TanamanTableModel model = (TanamanTableModel) panel.table.getModel();
        Tanaman selected = model.getTanamanAt(row);
        
        TanamanDialog dialog = new TanamanDialog(selected);
        dialog.setVisible(true);

        if (dialog.isSave()) {
            try {
                apiService.update(dialog.getTanaman());
                loadData();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Gagal Update: " + ex.getMessage());
            }
        }
    }

    private void aksiHapus() {
        int row = panel.table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(panel, "Pilih data yang ingin dihapus!");
            return;
        }

        if (JOptionPane.showConfirmDialog(panel, "Hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                TanamanTableModel model = (TanamanTableModel) panel.table.getModel();
                Tanaman selected = model.getTanamanAt(row);
                
                apiService.delete(selected.id);
                loadData();
                JOptionPane.showMessageDialog(panel, "Data berhasil dihapus!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Gagal Hapus: " + ex.getMessage());
            }
        }
    }
}