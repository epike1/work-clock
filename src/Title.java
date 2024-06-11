import javax.swing.*;
import java.awt.*;

public class Title {
    private JPanel panel1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(800,600));
        frame.setContentPane(new Title().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
