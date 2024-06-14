package screenFunctions;
import screenForms.*;
import javax.swing.*;
import java.awt.*;
public class FrameManager {

    private static JFrame frame = new JFrame();
    private static String name = "";
    private static double pay = 0;

    private static void updatePane(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);

        frame.revalidate();
        frame.repaint();
        System.out.println("frame painted");
    }

    public static void updateInfo(String name, double pay) {

    }

    public static void createTitle(JFrame newFrame) {

        frame = newFrame;

        updatePane(new Title().getMainPanel());
        FormatFunctions.titleDelay();
    }

    public static void sendSignal(PanelName panel) { // panels will send signals to frame manager to switch panels

        switch (panel) {

            case FirstTime:
                updatePane(new FirstTime().getMainPanel());
                break;
            case MainMenu:
                updatePane(new MainMenu().getMainPanel());
                break;
            case NameAndPay:
                updatePane(new NameAndPay().getMainPanel(name, pay));
        }
    }
}
