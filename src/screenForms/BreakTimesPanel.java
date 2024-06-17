package screenForms;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTable;

import screenFunctions.FormatFunctions;
import screenFunctions.FrameManager;
import screenFunctions.PanelName;

import javax.swing.JScrollPane;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BreakTimesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable breakTable;
	private JScrollPane scrollPane;
	private static ArrayList<int[]> breakList = new ArrayList<int[]>();
	private JTextField breakField;
	private JTextField minField;
	private JTextField maxField;

	/**
	 * Create the panel.
	 */
	public BreakTimesPanel() {
		setPreferredSize(new Dimension(750, 550));
		setBackground(new Color(46, 45, 52));
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(700, 300));
		scrollPane.setPreferredSize(new Dimension(700, 300));
		scrollPane.setBounds(10, 11, 730, 270);
		add(scrollPane);
		
		refreshTable();
		
		JLabel workLabel = new JLabel("Work Hours (0 to 24)");
		workLabel.setForeground(Color.WHITE);
		workLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		workLabel.setBounds(10, 304, 364, 41);
		add(workLabel);
		
		JLabel breakLabel = new JLabel("Break Time (Minutes)");
		breakLabel.setForeground(Color.WHITE);
		breakLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		breakLabel.setBounds(10, 366, 402, 41);
		add(breakLabel);
		
		JLabel toLabel = new JLabel("to");
		toLabel.setForeground(Color.WHITE);
		toLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		toLabel.setBounds(544, 304, 44, 41);
		add(toLabel);
		
		breakField = new JTextField();
		breakField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		breakField.setColumns(10);
		breakField.setBounds(422, 366, 103, 41);
		add(breakField);
		
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkValues();
				refreshTable();
			}
		});
		
		
		submit.setFont(new Font("Tahoma", Font.BOLD, 22));
		submit.setBorder(null);
		submit.setBackground(new Color(241, 194, 50));
		submit.setBounds(544, 366, 157, 41);
		add(submit);
		
		minField = new JTextField();
		minField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		minField.setColumns(10);
		minField.setBounds(422, 304, 103, 41);
		add(minField);
		
		maxField = new JTextField();
		maxField.setFont(new Font("Tahoma", Font.PLAIN, 24));
		maxField.setColumns(10);
		maxField.setBounds(598, 304, 103, 41);
		add(maxField);
		
		JButton nextButton = new JButton("McNext");
		nextButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!breakList.isEmpty()) {
					FrameManager.updateInfo(getBreakList());
					FrameManager.sendSignal(PanelName.MainMenu);
				} else {
					FormatFunctions.errorMessage("Information Missing", "Must have at least one range to continue. Set break time value to 0 to ignore giving break times.");
				}
			}
		});
		nextButton.setForeground(new Color(241, 194, 50));
		nextButton.setFont(new Font("Tahoma", Font.BOLD, 34));
		nextButton.setBorder(null);
		nextButton.setBackground(new Color(91, 15, 0));
		nextButton.setActionCommand("McNext");
		nextButton.setBounds(10, 437, 297, 102);
		add(nextButton);
		
		

	}
	
	private void checkValues()  { // when pressing submit, values entered will be checked
		
		String minStr = minField.getText().trim();
		String maxStr = maxField.getText().trim();
		String breakStr = breakField.getText().trim();
		
		minField.setText("");
		maxField.setText("");
		breakField.setText("");
		boolean overlap = false;
		
		try {
		
				int min = Integer.parseInt(minStr);
				int max = Integer.parseInt(maxStr);
				int breakTime = Integer.parseInt(breakStr);
				
				if (min >= 0 && max <= 24) { // checks if range is between 0 and 24, as working for 24 hours in a day is maximum
					
				
					if (min < max) { // checks if valid range is given
					
					for (int[] i : breakList) { // checks if ranges overlap
					
						int currentMin = i[0];
						int currentMax = i[1];
					
						if ((min <= currentMax && max <= currentMin) || min >= currentMax) {
							continue;
						}
						
						FormatFunctions.errorMessage("Invalid range.", "Ranges with different break times cannot overlap.");
						overlap = true;
						break;
					}
					
					if (!overlap) {
						
						if (breakTime >= 0) {
						breakList.add(new int[] {min, max, breakTime});
						} else {
							FormatFunctions.errorMessage("Invalid Break Time.", "Break time must be greater than or equal to 0.");
						}
					}
					
					} else {
						FormatFunctions.errorMessage("Invalid minimum and maximum.", "Maximum must be greater than minimum.");
					}
					
				} else {
					FormatFunctions.errorMessage("Invalid minimum and maximum.", "Minimum must be greater than 0, maximum must be less than 24.");
				}
				
		} catch (Exception e) {
			FormatFunctions.errorMessage("Invalid Values", "All values given must be of type integer.");
		}
	}
	
	public void refreshTable() {
		
		String[] columnNames = { "Start", "End", "Break Time" };
		Object[][] objectList = new Object[breakList.size()][];
		
		if (!breakList.isEmpty()) {
		
			for (int i = 0; i < breakList.size() ; i++) { // converting array list of integer arrays to 2D object arrays to be used in JTable
				
				Object[] numList = new Object[breakList.get(i).length];
				
				for (int j = 0 ; j < breakList.get(i).length ; j++) {
					
					numList[j] = breakList.get(i)[j];
				}
				
				objectList[i] = numList;
				
			}
		} else { // if empty create one row to display
			objectList = new Object[][]{ new Object[]{"NO BREAK TIMES GIVEN", 0, 0}};
		}
		
		breakTable = new JTable(objectList, columnNames) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		breakTable.setEnabled(false);
		breakTable.setRowSelectionAllowed(false);
		breakTable.setFont(new Font("Tahoma", Font.BOLD, 24));
		breakTable.setRowHeight(48);
		
		breakTable.setSize(new Dimension(700, 300));
		scrollPane.setViewportView(breakTable);
	}
	
	public void setBreakList(ArrayList<int[]> breakList) {
		BreakTimesPanel.breakList = breakList;
	}
	
	public ArrayList<int[]> getBreakList() {
		return BreakTimesPanel.breakList;
	}

}
