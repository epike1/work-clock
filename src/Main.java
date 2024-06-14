import screenFunctions.*;
import dataFunctions.FileManager;
import screenForms.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
            ArrayList<Object> infoList = FileManager.getInfo();

            FrameManager.updateInfo(infoList.get(0).toString(), Double.parseDouble(infoList.get(1).toString()));
            FrameManager.sendSignal(PanelName.MainMenu);

        } else {
            FrameManager.sendSignal(PanelName.FirstTime);
        }


    }
}
