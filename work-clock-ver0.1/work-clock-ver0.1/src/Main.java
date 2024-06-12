import screenForms.*;
import screenFunctions.formatFunctions;
import dataFunctions.FileManager;
import java.awt.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        FileManager.setFile();

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Title().mainPanel);
        frame.setResizable(false);
        frame.setVisible(true);
        formatFunctions.titleDelay();

        if (FileManager.checkInfoFile()) {
            frame.getContentPane().removeAll();
            frame.repaint();

            frame.add(new MainMenu().mainPanel);
        } else {
            System.out.println("New Info");
            frame.setContentPane(new FirstTime().mainPanel);
            frame.repaint();
        }


    }
}
