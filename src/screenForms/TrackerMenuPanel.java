package screenForms;

import javax.swing.JPanel;

import screenFunctions.FrameManager;
import screenFunctions.PanelName;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class TrackerMenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TrackerMenuPanel() {
		setPreferredSize(new Dimension(750, 550));
		setBackground(new Color(46, 45, 52));
		setLayout(null);
		
		JButton backButton = new JButton("McGo Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.sendSignal(PanelName.MainMenu);
			}
		});
		backButton.setForeground(new Color(241, 194, 50));
		backButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		backButton.setBorder(null);
		backButton.setBackground(new Color(91, 15, 0));
		backButton.setActionCommand("McNext");
		backButton.setBounds(200, 412, 329, 102);
		add(backButton);
		
		JButton addEntryButton = new JButton("Add McEntry");
		addEntryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.sendSignal(PanelName.AddEntry);
			}
		});
		addEntryButton.setForeground(new Color(241, 194, 50));
		addEntryButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		addEntryButton.setBorder(null);
		addEntryButton.setBackground(new Color(91, 15, 0));
		addEntryButton.setActionCommand("McNext");
		addEntryButton.setBounds(200, 290, 329, 102);
		add(addEntryButton);
		
		JButton McWeeksButton = new JButton("Sort by McWeeks");
		McWeeksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.sendSignal(PanelName.SortByWeeks);
			}
		});
		McWeeksButton.setForeground(new Color(241, 194, 50));
		McWeeksButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		McWeeksButton.setBorder(null);
		McWeeksButton.setBackground(new Color(91, 15, 0));
		McWeeksButton.setActionCommand("McNext");
		McWeeksButton.setBounds(200, 166, 329, 102);
		add(McWeeksButton);
		
		JButton McDaysButton = new JButton("Sort by McDays");
		McDaysButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.sendSignal(PanelName.SortByDays);
			}
		});
		McDaysButton.setForeground(new Color(241, 194, 50));
		McDaysButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		McDaysButton.setBorder(null);
		McDaysButton.setBackground(new Color(91, 15, 0));
		McDaysButton.setActionCommand("McNext");
		McDaysButton.setBounds(200, 39, 329, 102);
		add(McDaysButton);

	}

}
