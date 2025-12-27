package websocket;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import java.net.URI;

public class WebSocketClientApp extends WebSocketClient {
    private Runnable onUpdate;

    public WebSocketClientApp(String url, Runnable onUpdate) throws Exception {
        super(new URI(url));
        this.onUpdate = onUpdate;
    }

    @Override
    public void onOpen(ServerHandshake sh) {
        System.out.println("✅ Terhubung ke Server WebSocket");
    }

    @Override
    public void onMessage(String message) {
        System.out.println("📩 Pesan masuk: " + message);
        // Perbaikan: Cek isi JSON dari Node.js
        if (message.contains("\"type\":\"update\"")) {
            System.out.println("🔄 Me-refresh data otomatis...");
            onUpdate.run();
        }
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        System.out.println("🔌 Koneksi Terputus");
    }

    @Override
    public void onError(Exception ex) {
        ex.printStackTrace();
    }
}