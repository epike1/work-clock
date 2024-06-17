package screenForms;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import dataFunctions.WorkEntry;
import screenFunctions.FormatFunctions;
import screenFunctions.PanelName;
import screenFunctions.FrameManager;

public class AddEntryPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField dateField;
	private JTextField startHourField;
	private JTextField startMinuteField;
	private JTextField endMinuteField;
	private JTextField endHourField;
	
	private static ArrayList<WorkEntry> workTimes = new ArrayList<WorkEntry>();

	/**
	 * Create the panel.
	 */
	public AddEntryPanel() {
		setPreferredSize(new Dimension(750, 550));
		setBackground(new Color(46, 45, 52));
		setLayout(null);
		
		JLabel dateLabel = new JLabel("Date: (dd/mm/yyyy)");
		dateLabel.setBounds(22, 90, 389, 41);
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		add(dateLabel);
		
		JLabel startLabel = new JLabel("Start: (24H clock)");
		startLabel.setForeground(Color.WHITE);
		startLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		startLabel.setBounds(22, 180, 389, 41);
		add(startLabel);
		
		JLabel endLabel = new JLabel("End: (24H clock)");
		endLabel.setForeground(Color.WHITE);
		endLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		endLabel.setBounds(22, 275, 389, 41);
		add(endLabel);
		
		JButton backButton = new JButton("McGo Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameManager.updateWorkTimes(workTimes);
				FrameManager.sendSignal(PanelName.TrackerMenu);
			}
		});
		backButton.setForeground(new Color(241, 194, 50));
		backButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		backButton.setBorder(null);
		backButton.setBackground(new Color(91, 15, 0));
		backButton.setActionCommand("McNext");
		backButton.setBounds(10, 437, 329, 102);
		add(backButton);
		
		dateField = new JTextField();
		dateField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		dateField.setColumns(10);
		dateField.setBounds(438, 90, 284, 41);
		add(dateField);
		
		startHourField = new JTextField();
		startHourField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		startHourField.setColumns(10);
		startHourField.setBounds(438, 180, 126, 41);
		add(startHourField);
		
		JLabel colonLabel1 = new JLabel(":");
		colonLabel1.setForeground(Color.WHITE);
		colonLabel1.setFont(new Font("Tahoma", Font.BOLD, 34));
		colonLabel1.setBounds(574, 180, 12, 41);
		add(colonLabel1);
		
		startMinuteField = new JTextField();
		startMinuteField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		startMinuteField.setColumns(10);
		startMinuteField.setBounds(596, 180, 126, 41);
		add(startMinuteField);
		
		endMinuteField = new JTextField();
		endMinuteField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		endMinuteField.setColumns(10);
		endMinuteField.setBounds(596, 275, 126, 41);
		add(endMinuteField);
		
		endHourField = new JTextField();
		endHourField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		endHourField.setColumns(10);
		endHourField.setBounds(438, 275, 126, 41);
		add(endHourField);
		
		JLabel colonLabel2 = new JLabel(":");
		colonLabel2.setForeground(Color.WHITE);
		colonLabel2.setFont(new Font("Tahoma", Font.BOLD, 34));
		colonLabel2.setBounds(574, 275, 12, 41);
		add(colonLabel2);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				checkWorkEntry();
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 22));
		submit.setBorder(null);
		submit.setBackground(new Color(241, 194, 50));
		submit.setBounds(438, 351, 284, 41);
		add(submit);

	}
	
	public void checkWorkEntry() {
		
		String date = dateField.getText().trim();
		String startHourStr = startHourField.getText().trim();
		String startMinuteStr = startMinuteField.getText().trim();
		String endHourStr = endHourField.getText().trim();
		String endMinuteStr = endMinuteField.getText().trim();
		
		dateField.setText("");
		startHourField.setText("");
		startMinuteField.setText("");
		endHourField.setText("");
		endMinuteField.setText("");
		
		if (!date.isEmpty() && !startHourStr.isEmpty() && !startMinuteStr.isEmpty() && !endHourStr.isEmpty() && !endMinuteStr.isEmpty()) {
			
			if (validDate(date)) {
				try {
					
					int startHour = Integer.parseInt(startHourStr);
					int startMinute = Integer.parseInt(startMinuteStr);
					int endHour = Integer.parseInt(endHourStr);
					int endMinute = Integer.parseInt(endMinuteStr);
					
					if (startHour >= 0 && startHour < 24 && endHour >= 0 && endHour < 24) {
						
						if (startMinute >= 0 && startMinute < 60 && endMinute >= 0 && endMinute < 60) {
							
							double hours = getTime(startHour, endHour, startMinute, endMinute);
							
							if (hours > 0) {
								workTimes.add(new WorkEntry(date, hours));
							} else {
								FormatFunctions.errorMessage("Invalid Time", "Start and end times cannot be equal.");
							}
							
						} else {
							
							FormatFunctions.errorMessage("Invalid Minutes", "Minutes must be greater than or equal to 0 AND less than 60.");
							
						}
						
						
					} else {
						FormatFunctions.errorMessage("Invalid Hours", "Hours must be greater than or equal to 0 AND less than 24.");
					}
				} catch (Exception e) {
					FormatFunctions.errorMessage("Invalid Times", "Input for times must be of type integer.");
				}
			} else {
				FormatFunctions.errorMessage("Invalid Date", "Date must follow 'dd/mm/yyyy' format, and days must be between 1 and 31 and months must be between 1 and 12.");
			}
		} else {
			FormatFunctions.errorMessage("Empty Information", "All text fields must have information.");
		}
	}
	
	private boolean validDate(String date) {
		
		if (!date.isEmpty()) {
			
			String[] dateList = date.split("/");
			
			if (dateList.length == 3) {
				
				if (dateList[0].length() == 2 && dateList[1].length() == 2 && dateList[2].length() == 4) {
					try {
						
						int day = Integer.parseInt(dateList[0]);
						int month = Integer.parseInt(dateList[1]);
						int year = Integer.parseInt(dateList[2]);
						
						if (day >= 1 && day <= 31 && month >= 1 && month <= 12 && year >= 0) {
							return true;
						}
						
					} catch (Exception e) {
					}
				}
			}
		}
		
		return false;
	}
	
	public double getTime(int startHours, int endHours, int startMinutes, int endMinutes) {
		
		boolean startSmaller = true;
		
		if (startHours > endHours) {
			
			startSmaller = false;
			
			
		} else if (startHours == endHours) {		
			if (startMinutes > endMinutes) {
				
				startSmaller = false;
				
			} else if (startMinutes == endMinutes) {
				return 0; // return 0 if times are the same
			}
		}
				
				
			
		
		
		if (startSmaller) {
			return (double)(endHours - startHours) + ((double)(endMinutes - startMinutes) / 60);
		} else {
			return (double)(endHours + (24 - startHours)) + ((double)(endMinutes - startMinutes) / 60);
		}
	}
	
	
	public void setWorkTimes(ArrayList<WorkEntry> workTimes) {
		AddEntryPanel.workTimes = workTimes;
	}

}
