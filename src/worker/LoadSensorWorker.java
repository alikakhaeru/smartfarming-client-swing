package worker;

import javax.swing.SwingWorker;
import java.util.List;
import model.Sensor;
import service.SensorApiService;
import view.SensorPanel;
import view.tablemodel.SensorTableModel;

public class LoadSensorWorker extends SwingWorker<List<Sensor>, Void> {

    private final SensorPanel panel;
    private final SensorApiService service = new SensorApiService();

    public LoadSensorWorker(SensorPanel panel) {
        this.panel = panel;
    }

    protected List<Sensor> doInBackground() throws Exception {
        return service.getAll();
    }

    protected void done() {
        try {
            panel.table.setModel(new SensorTableModel(get()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
