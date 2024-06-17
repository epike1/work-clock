package screenForms;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import screenFunctions.*;

public class FirstTimePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public FirstTimePanel() {
		setBackground(new Color(46, 45, 52));
		setPreferredSize(new Dimension(750, 550));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("As this is your first time you are");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(30, 150, 597, 34);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		add(lblNewLabel);
		
		JLabel lblRunningThisMcprogram = new JLabel("running this McProgram, you will");
		lblRunningThisMcprogram.setForeground(Color.WHITE);
		lblRunningThisMcprogram.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblRunningThisMcprogram.setBounds(30, 195, 597, 47);
		add(lblRunningThisMcprogram);
		
		JLabel lblNeedToSet = new JLabel("need to set up your McData.");
		lblNeedToSet.setForeground(Color.WHITE);
		lblNeedToSet.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNeedToSet.setBounds(30, 244, 597, 47);
		add(lblNeedToSet);
		
		JButton beginButton = new JButton("McBegin");
		beginButton.setBorder(null);
		beginButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		beginButton.setForeground(new Color(241, 194, 50));
		beginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.sendSignal(PanelName.NameAndPay);
			}
		});
		beginButton.setBackground(new Color(91, 15, 0));
		beginButton.setBounds(30, 400, 297, 102);
		add(beginButton);

	}

}
