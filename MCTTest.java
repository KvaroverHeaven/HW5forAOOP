package HW5forAOOP;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MCTTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException
                    | IllegalAccessException ex) {
                ex.printStackTrace();
            }
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        var mctFrame = new MCTFrame();
        mctFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        mctFrame.setSize(1280, 720);
        mctFrame.setLocationByPlatform(true);
        mctFrame.setVisible(true);
    }

}
