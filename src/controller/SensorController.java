package controller;

import view.SensorPanel;
import worker.LoadSensorWorker;

public class SensorController {

    private final SensorPanel panel;

    public SensorController(SensorPanel panel) {
        this.panel = panel;
        load();
        panel.btnRefresh.addActionListener(e -> load());
    }

    private void load() {
        new LoadSensorWorker(panel).execute();
    }
}
