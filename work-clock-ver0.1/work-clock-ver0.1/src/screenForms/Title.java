package screenForms;

import javax.swing.*;
import java.awt.*;

public class Title {
    public JPanel mainPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(800,600));
        frame.setContentPane(new Title().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
