package controller;

import javax.swing.JOptionPane;
import model.Lahan;
import service.LahanApiService;
import view.LahanDialog;
import view.LahanPanel;
import view.tablemodel.LahanTableModel; // Import ini wajib ada
import worker.LoadLahanWorker;

public class LahanController {

    private final LahanPanel panel;
    private final LahanApiService apiService = new LahanApiService();

    public LahanController(LahanPanel panel) {
        this.panel = panel;
        loadData();

        panel.btnRefresh.addActionListener(e -> loadData());
        panel.btnTambah.addActionListener(e -> tambahData());
        panel.btnHapus.addActionListener(e -> hapusData());
    }

    private void loadData() {
        new LoadLahanWorker(panel).execute();
    }

    private void tambahData() {
        LahanDialog dialog = new LahanDialog(null);
        dialog.setVisible(true);
        if (dialog.isSave()) {
            try {
                apiService.save(dialog.getLahan());
                loadData();
                JOptionPane.showMessageDialog(panel, "Data berhasil ditambah!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Gagal simpan: " + ex.getMessage());
            }
        }
    }

    private void hapusData() {
        int selectedRow = panel.table.getSelectedRow();
        
        // Cek apakah ada baris yang dipilih
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(panel, "Pilih data yang akan dihapus!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(panel, "Yakin ingin hapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // PROSES AMBIL DATA: Ini yang tadi error
                LahanTableModel model = (LahanTableModel) panel.table.getModel();
                Lahan lahanTerpilih = model.getLahanAt(selectedRow);
                
                // Kirim ID ke API
                apiService.delete(lahanTerpilih.id); 
                
                loadData(); // Refresh tabel
                JOptionPane.showMessageDialog(panel, "Data berhasil dihapus!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Gagal hapus: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}