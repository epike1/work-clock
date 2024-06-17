package screenForms;

import javax.swing.JPanel;

import screenFunctions.FrameManager;
import screenFunctions.PanelName;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public MainMenuPanel() {
		setPreferredSize(new Dimension(750, 550));
		setBackground(new Color(46, 45, 52));
		setLayout(null);
		
		JLabel titleLabel = new JLabel("McTracker™");
		titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		titleLabel.setForeground(new Color(241, 194, 50));
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 82));
		titleLabel.setBounds(114, 57, 499, 99);
		add(titleLabel);
		
		JButton quitButton = new JButton("McQuit");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrameManager.quitProgram();
			}
		});
		quitButton.setForeground(new Color(241, 194, 50));
		quitButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		quitButton.setBorder(null);
		quitButton.setBackground(new Color(91, 15, 0));
		quitButton.setBounds(204, 420, 297, 102);
		add(quitButton);
		
		JButton trackButton = new JButton("McTrack");
		trackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.sendSignal(PanelName.TrackerMenu);
			}
		});
		trackButton.setForeground(new Color(241, 194, 50));
		trackButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		trackButton.setBorder(null);
		trackButton.setBackground(new Color(91, 15, 0));
		trackButton.setBounds(50, 307, 297, 102);
		add(trackButton);
		
		JButton optionsButton = new JButton("McOptions");
		optionsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.sendSignal(PanelName.NameAndPay);
			}
		});
		optionsButton.setForeground(new Color(241, 194, 50));
		optionsButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		optionsButton.setBorder(null);
		optionsButton.setBackground(new Color(91, 15, 0));
		optionsButton.setBounds(357, 307, 297, 102);
		add(optionsButton);
		
	}

}
