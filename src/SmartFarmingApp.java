import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import view.MainFrame;

public class SmartFarmingApp {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.err.println("Gagal memuat tema.");
        }

        javax.swing.SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}