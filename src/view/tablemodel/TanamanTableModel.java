package view.tablemodel;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Tanaman;

public class TanamanTableModel extends AbstractTableModel {

    private final List<Tanaman> data;
    private final String[] col = {"id","nama","jenis"};

    public TanamanTableModel(List<Tanaman> data) {
        this.data = data;
    }

    public int getRowCount(){ return data.size(); }
    public int getColumnCount(){ return col.length; }
    public String getColumnName(int c){ return col[c]; }

    public Object getValueAt(int r,int c){
        Tanaman t = data.get(r);
        return switch(c){
            case 0 -> t.id;
            case 1 -> t.nama;
            case 2 -> t.jenis;
            default -> null;
        };
    }

    // PERBAIKAN: Harus return data, jangan throw Exception
    public Tanaman getTanamanAt(int row) {
        return data.get(row);
    }
}