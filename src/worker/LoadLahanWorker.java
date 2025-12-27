package worker;

import javax.swing.SwingWorker;
import java.util.List;
import model.Lahan;
import service.LahanApiService;
import view.LahanPanel;
import view.tablemodel.LahanTableModel;

public class LoadLahanWorker extends SwingWorker<List<Lahan>, Void> {

    private final LahanPanel panel;
    private final LahanApiService service = new LahanApiService();

    public LoadLahanWorker(LahanPanel panel) {
        this.panel = panel;
    }

    @Override
    protected List<Lahan> doInBackground() throws Exception {
        return service.getAll();
    }

    @Override
    protected void done() {
        try {
            panel.table.setModel(new LahanTableModel(get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
