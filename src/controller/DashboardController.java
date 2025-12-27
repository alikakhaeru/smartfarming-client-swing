package controller;

import view.DashboardPanel;

public class DashboardController {

    public DashboardController(DashboardPanel panel) {

        panel.showPage("LAHAN"); // default

        panel.btnLahan.addActionListener(e ->
            panel.showPage("LAHAN")
        );

        panel.btnSensor.addActionListener(e ->
            panel.showPage("SENSOR")
        );

        panel.btnTanaman.addActionListener(e ->
            panel.showPage("TANAMAN")
        );

        // controller masing-masing panel
        new LahanController(panel.lahanPanel);
        new SensorController(panel.sensorPanel);
        new TanamanController(panel.tanamanPanel);
    }
}
