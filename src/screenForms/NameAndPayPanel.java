package screenForms;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import screenFunctions.FrameManager;
import screenFunctions.PanelName;
import screenFunctions.FormatFunctions;

public class NameAndPayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static String name = "";
    private static double pay = 0.00;
    private JTextField nameField;
    private JTextField payField;
    private JLabel nameLabel;
    private JLabel payLabel;
    
	/**
	 * Create the panel.
	 */
	public NameAndPayPanel() {
		setPreferredSize(new Dimension(750, 550));
		setBackground(new Color(46, 45, 52));
		setLayout(null);
		
		JButton nextButton = new JButton("McNext");
		nextButton.setActionCommand("McNext");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!name.isEmpty() && pay > 0) { // checks for values given

	                
	                FrameManager.updateInfo(getName(), getPay());
					FrameManager.sendSignal(PanelName.BreakTimes);
				} else {
					FormatFunctions.errorMessage("Null Information", "Name and pay must be given values before proceeding.");
				}
			}
		});
		nextButton.setForeground(new Color(241, 194, 50));
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		nextButton.setBorder(null);
		nextButton.setBackground(new Color(91, 15, 0));
		nextButton.setBounds(10, 437, 297, 102);
		add(nextButton);
		
		nameLabel = new JLabel("Name: NONE");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		nameLabel.setBounds(22, 128, 371, 41);
		add(nameLabel);
		
		payLabel = new JLabel("Pay: NONE");
		payLabel.setForeground(Color.WHITE);
		payLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		payLabel.setBounds(22, 256, 371, 41);
		add(payLabel);
		
		nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		nameField.setBounds(403, 128, 206, 41);
		add(nameField);
		nameField.setColumns(10);
		
		JButton nameSubmit = new JButton("SUBMIT");
		nameSubmit.addActionListener(new ActionListener() { // when user submits name
			public void actionPerformed(ActionEvent e) { 
				String newName = nameField.getText().trim();
                nameField.setText("");

                if (!newName.isEmpty() && newName.length() <= 10) {
                    setName(newName);
                } else {
                    FormatFunctions.errorMessage("Invalid Name", "Name must not be empty, and must be 10 characters or less.");
                }

                updateLabels();
			}
		});
		nameSubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
		nameSubmit.setBorder(null);
		nameSubmit.setBackground(new Color(241, 194, 50));
		nameSubmit.setBounds(619, 128, 121, 41);
		add(nameSubmit);
		
		payField = new JTextField();
		payField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		payField.setColumns(10);
		payField.setBounds(403, 256, 206, 41);
		add(payField);
		
		JButton paySubmit = new JButton("SUBMIT");
		paySubmit.addActionListener(new ActionListener() { // when user submits pay
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					double newPay = Double.parseDouble(payField.getText());
					DecimalFormat df = new DecimalFormat("#.##");
					double roundedPay = Double.valueOf(df.format(newPay));
					
					if (roundedPay > 0.00) {
						setPay(roundedPay);
					} else {
						FormatFunctions.errorMessage("Invalid Pay", "Pay must be greater than $0.00.");
					}
					
				} catch (Exception invalidPay) {
					FormatFunctions.errorMessage("Invalid Pay", "Pay must be a number.");
				}
				
				payField.setText("");
				updateLabels();
			}
		});
		paySubmit.setFont(new Font("Tahoma", Font.BOLD, 22));
		paySubmit.setBorder(null);
		paySubmit.setBackground(new Color(241, 194, 50));
		paySubmit.setBounds(619, 256, 121, 41);
		add(paySubmit);
		
	}
	
	public void updateLabels() { //update name and pay panels

        if (!name.isEmpty()) {
            nameLabel.setText("Name: " + getName());
        } else {
            nameLabel.setText("Name: NONE");
        }

        if (pay > 0) {
            payLabel.setText(String.format("Pay: $%.2f", getPay()));
        } else {
            payLabel.setText("Pay: NONE");
        }
    }
	
	public String getName() {
        return name;
    }

    public void setName(String name) {
        NameAndPayPanel.name = name;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        NameAndPayPanel.pay = pay;
    }
    
}
