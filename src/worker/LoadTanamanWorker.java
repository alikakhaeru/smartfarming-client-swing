package worker;

import javax.swing.SwingWorker;
import java.util.List;
import model.Tanaman;
import service.TanamanApiService;
import view.TanamanPanel;
import view.tablemodel.TanamanTableModel;

public class LoadTanamanWorker extends SwingWorker<List<Tanaman>, Void> {

    private final TanamanPanel panel;
    private final TanamanApiService service = new TanamanApiService();

    public LoadTanamanWorker(TanamanPanel panel) {
        this.panel = panel;
    }

    @Override
    protected List<Tanaman> doInBackground() throws Exception {
        return service.getAll();
    }

    @Override
    protected void done() {
        try {
            panel.table.setModel(new TanamanTableModel(get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
