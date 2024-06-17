import screenFunctions.*;
import dataFunctions.FileManager;
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

        FormatFunctions.frame = frame;
        
        FileManager.setFile();
        FrameManager.createTitle(frame);

        if (FileManager.checkInfoFile()) {
            ArrayList<Object> infoList = FileManager.getInfo();
            
            FrameManager.updateInfo(infoList.get(0).toString(), Double.parseDouble((String) infoList.get(1)), FileManager.convertFromObjectList(infoList.get(2)));
            FrameManager.updateWorkTimes(FileManager.getWorkTimes());
            FrameManager.sendSignal(PanelName.MainMenu);

        } else {
            FrameManager.sendSignal(PanelName.FirstTime);
        }
    }
    
    
}
