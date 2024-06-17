package screenForms;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import screenFunctions.*;
import dataFunctions.*;
import java.util.ArrayList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayEntriesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static ArrayList<int[]> breakTimes = new ArrayList<int[]>();
	private static ArrayList<TableEntry> entryList = new ArrayList<TableEntry>();
	private static double pay = 0;
	private JTable entryTable;
	private JScrollPane scrollPane;
	private JLabel trackerLabel;

	/**
	 * Create the panel.
	 */
	public DisplayEntriesPanel() {
		setPreferredSize(new Dimension(750, 550));
		setBackground(new Color(46, 45, 52));
		setLayout(null);
		
		JButton backButton = new JButton("McGo Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 63, 730, 350);
		add(scrollPane);
		
		entryTable = new JTable();
		refreshTable();
		
		trackerLabel = new JLabel("Tracker - Sorted by McDays");
		trackerLabel.setForeground(Color.WHITE);
		trackerLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		trackerLabel.setBounds(138, 11, 482, 41);
		add(trackerLabel);

	}
	
	public void sortByDays(ArrayList<WorkEntry> workTimes) {
		
		trackerLabel.setText("Tracker - Sorted by McDays");
		ArrayList<TableEntry> newList = new ArrayList<TableEntry>();
		
		ArrayList<WorkEntry> sortedList = new ArrayList<WorkEntry>();
		
		if (!workTimes.isEmpty()) {
			sortedList = trackerFunctions.sortByDays(workTimes);
			
			for (WorkEntry entry : sortedList) {
				newList.add(new TableEntry (
						entry.getDate(),
						entry.getHours() - ((double)getBreaks(entry.getHours()) / 60),
						getBreaks(entry.getHours()),
						entry.calculateTotalPay(pay, getBreaks(entry.getHours()))
				));
			}
		}
		
		setEntryList(newList);
		
		refreshTable();
	}
	
	public void sortByWeeks(ArrayList<WorkEntry> workTimes) {
		
		trackerLabel.setText("McTracker - Sorted by McWeeks");
		ArrayList<TableEntry> newList = new ArrayList<TableEntry>();
		
		ArrayList<WorkEntry> sortedList = trackerFunctions.sortByDays(workTimes);
		
		int len = sortedList.size();
		int i = 0;
		
		while (len != 0) {
				
			int limit = len;
			
			if (len >= 7) {
				limit = 7;
			}
				
				TableEntry tableEntry = new TableEntry(
						sortedList.get(i).getDate() + " - " + sortedList.get(len - 1).getDate(),
						0,
						0,
						0);
				
				double totalHours = 0;
				int totalBreaks = 0;
				double totalPay = 0;
				
				for (int j = 0 ; j < limit ; j++) {
					
					totalHours += sortedList.get(i).getHours() - ((double)getBreaks(sortedList.get(i).getHours()) / 60);
					totalBreaks += getBreaks(sortedList.get(i).getHours());
					totalPay += sortedList.get(i).calculateTotalPay(pay, getBreaks(sortedList.get(i).getHours()));
					
					i++;
					len--;
				}
				
				tableEntry.setHoursWorked(totalHours);
				tableEntry.setBreakMinutes(totalBreaks);
				tableEntry.setPay(totalPay);
				newList.add(tableEntry);
			
		}
		
		setEntryList(newList);
		
		refreshTable();
		
	}
	
	private int getBreaks(double hours) {
		
		if (!breakTimes.isEmpty()) {
			
			for (int[] list : breakTimes) {
				
				if (list[0] <= hours && hours < list[1]) {
					
					return list[2];
					
				}
			}
			
		} 
		
		return 0;
	}
	
	private void refreshTable() {
		
		String[] columnNames = { "McDate", "McHours Worked", "McBreaksTaken", "McPay Earned" };
		Object[][] objectList = new Object[DisplayEntriesPanel.entryList.size()][];
		
		if (!DisplayEntriesPanel.entryList.isEmpty()) {
			
			
			for (int i = 0 ; i < DisplayEntriesPanel.entryList.size(); i++) {
				TableEntry entry = DisplayEntriesPanel.entryList.get(i);
				
				objectList[i] = new Object[] {
						entry.getDate(),
						String.format("%.2f hours", entry.getHoursWorked()),
						String.format("%d minutes", entry.getBreakMinutes()),
						String.format("$%.2f", entry.getPay())
						}; 
			}
			
		
			
		} else { // if empty create one row to display
			objectList = new Object[][]{ new Object[]{"NO ENTRIES", "NO HOURS", "NO BREAKS", "NO PAY"}};
		}
		
		entryTable = new JTable(objectList, columnNames) {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		entryTable.setEnabled(false);
		entryTable.setRowSelectionAllowed(false);
		entryTable.setFont(new Font("Tahoma", Font.BOLD, 12));
		entryTable.setRowHeight(48);
		
		entryTable.setSize(new Dimension(700, 300));
		scrollPane.setViewportView(entryTable);
	}
	
	public void setEntryList(ArrayList<TableEntry> entryList) {
		DisplayEntriesPanel.entryList = entryList;
	}
	public void setBreakTimes(ArrayList<int[]> breakTimes) {
		DisplayEntriesPanel.breakTimes = breakTimes;
	}
	
	public void setPay(double pay) {
		DisplayEntriesPanel.pay = pay;
	}
}
