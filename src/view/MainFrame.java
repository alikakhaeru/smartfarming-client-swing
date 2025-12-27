package view;

import javax.swing.*;
import controller.DashboardController;
import websocket.WebSocketClientApp;
import worker.LoadLahanWorker;
import worker.LoadSensorWorker;
import worker.LoadTanamanWorker;

public class MainFrame extends JFrame {
    public MainFrame() {
        setTitle("Smart Farming Dashboard");
        setSize(1200, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        DashboardPanel dashboard = new DashboardPanel();
        setContentPane(dashboard);

        // PERBAIKAN: Inisialisasi Controller agar logika jalan
        new DashboardController(dashboard);

        // Jalankan WebSocket di background
        new Thread(() -> {
            try {
                WebSocketClientApp client = new WebSocketClientApp(
                    "ws://localhost:8080", 
                    () -> {
                        new LoadLahanWorker(dashboard.lahanPanel).execute();
                        new LoadSensorWorker(dashboard.sensorPanel).execute();
                        new LoadTanamanWorker(dashboard.tanamanPanel).execute();
                    }
                );
                client.connect();
            } catch (Exception e) {
                System.err.println("WebSocket belum aktif, gunakan refresh manual.");
            }
        }).start();
    }
}