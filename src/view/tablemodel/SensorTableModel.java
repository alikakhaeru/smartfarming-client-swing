package view.tablemodel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Sensor;

public class SensorTableModel extends AbstractTableModel {

    private final List<Sensor> data;
    private final String[] col = {
        "id", "lahan", "suhu", "kelembapan", "cahaya", "waktu"
    };

    public SensorTableModel(List<Sensor> data) {
        this.data = data;
    }

    public int getRowCount() { return data.size(); }
    public int getColumnCount() { return col.length; }
    public String getColumnName(int c) { return col[c]; }

    public Object getValueAt(int r, int c) {
        Sensor s = data.get(r);
        return switch (c) {
            case 0 -> s.id;
            case 1 -> s.lahan;
            case 2 -> s.suhu;
            case 3 -> s.kelembapan_tanah;
            case 4 -> s.intensitas_cahaya;
            case 5 -> s.waktu;
            default -> null;
        };
    }
}
