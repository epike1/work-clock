package screenForms;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;

public class StartPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public StartPanel() {
		setSize(new Dimension(800, 600));
		setPreferredSize(new Dimension(750, 550));
		setBackground(new Color(46, 45, 52));
		setLayout(null);
		
		JLabel startLabel = new JLabel("McStarting...");
		startLabel.setBounds(50, 285, 308, 58);
		startLabel.setForeground(new Color(204, 0, 0));
		startLabel.setFont(new Font("Tahoma", Font.BOLD, 48));
		add(startLabel);
		
		JLabel verLabel = new JLabel("McVer 0.5");
		verLabel.setBounds(25, 480, 180, 44);
		verLabel.setForeground(Color.WHITE);
		verLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		add(verLabel);
		
		JLabel titleLabel = new JLabel("McTracker™");
		titleLabel.setBounds(50, 100, 499, 99);
		titleLabel.setForeground(new Color(241, 194, 50));
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 82));
		add(titleLabel);

	}

}
