package view.tablemodel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Lahan;

public class LahanTableModel extends AbstractTableModel {
    private final List<Lahan> list;
    private final String[] columns = {"ID", "Nama Lahan", "Lokasi", "Luas", "ID Tanaman"};

    public LahanTableModel(List<Lahan> list) {
        this.list = list;
    }

    // FUNGSI KRUSIAL: Menghubungkan baris tabel dengan objek Lahan
    public Lahan getLahanAt(int row) {
        return list.get(row);
    }

    @Override
    public int getRowCount() { return list.size(); }

    @Override
    public int getColumnCount() { return columns.length; }

    @Override
    public Object getValueAt(int row, int col) {
        Lahan l = list.get(row);
        switch (col) {
            case 0: return l.id;
            case 1: return l.nama_lahan;
            case 2: return l.lokasi;
            case 3: return l.luas;
            case 4: return l.tanaman_id;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int col) { return columns[col]; }
}