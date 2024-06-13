package screenForms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import screenFunctions.*;

public class FirstTime {

    private JButton mcBeginButton;
    private JPanel mainPanel;

    public FirstTime() {
        mcBeginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                FrameManager.sendSignal(PanelName.NameAndPay);
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
