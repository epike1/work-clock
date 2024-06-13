import screenFunctions.*;
import dataFunctions.FileManager;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(800, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        FileManager.setFile();
        FrameManager.createTitle(frame);

        System.out.println("completed frame");

        if (FileManager.checkInfoFile()) {
            FrameManager.sendSignal(PanelName.MainMenu);
        } else {
            FrameManager.sendSignal(PanelName.FirstTime);
        }


    }
}
