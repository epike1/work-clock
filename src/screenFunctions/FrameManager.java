package screenFunctions;
import screenForms.*;
import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import dataFunctions.FileManager;
import dataFunctions.WorkEntry;
public class FrameManager {

    private static JFrame frame = new JFrame();
    private static String name = "";
    private static double pay = 0;
    private static ArrayList<int[]> breakTimes = new ArrayList<int[]>();
    private static ArrayList<WorkEntry> workTimes = new ArrayList<WorkEntry>();

    private static void updatePane(JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);

        frame.revalidate();
        frame.repaint();
    }

    public static void updateInfo(String name, double pay, ArrayList<int[]> breakTimes) {
    	FrameManager.name = name;
    	FrameManager.pay = pay;
    	FrameManager.breakTimes = breakTimes;
    }
    
    public static void updateInfo(String name, double pay) {
    	FrameManager.name = name;
    	FrameManager.pay = pay;
    }
    
    public static void updateInfo(ArrayList<int[]> breakTimes) {
    	FrameManager.breakTimes = breakTimes;
    }
    
    public static void updateWorkTimes(ArrayList<WorkEntry> workTimes) { // as it is only called when work entries are added, automatically save to file
    	FrameManager.setWorkTimes(workTimes);
    	FileManager.writeWorkTime(workTimes);
    }

    public static void createTitle(JFrame newFrame) {

        frame = newFrame;

        updatePane(new StartPanel());
        FormatFunctions.titleDelay();
    }

    public static void sendSignal(PanelName panel) { // panels will send signals to frame manager to switch panels

        switch (panel) {

            case FirstTime:
                updatePane(new FirstTimePanel());
                break;
            case MainMenu:
            	
            	FileManager.updateInfo(FrameManager.name, FrameManager.pay, FrameManager.breakTimes); // saves all information to the info file
                updatePane(new MainMenuPanel());
                break;
            case NameAndPay:
            	
            	NameAndPayPanel nameAndPayPanel = new NameAndPayPanel();
            	
            	nameAndPayPanel.setName(name);
            	
            	nameAndPayPanel.setPay(pay);
            	
            	nameAndPayPanel.updateLabels();
            	
                updatePane(nameAndPayPanel);
                
                break;
                
            case BreakTimes:
            	
            	BreakTimesPanel breakTimesPanel = new BreakTimesPanel();
            	
            	breakTimesPanel.setBreakList(breakTimes);
            	
            	breakTimesPanel.refreshTable();
            	
            	updatePane(breakTimesPanel);
            	
            	updateInfo(breakTimesPanel.getBreakList());
            	
            	break;
            	
            case TrackerMenu:
            	
            	updatePane(new TrackerMenuPanel());
            	
            	break;
            	
            case AddEntry:
            	
            	AddEntryPanel addEntryPanel = new AddEntryPanel();
            	
            	addEntryPanel.setWorkTimes(workTimes);
            	
            	updatePane(addEntryPanel);
            	
            	break;
            	
            case SortByDays:
            	
            	DisplayEntriesPanel  displayDaysPanel = new DisplayEntriesPanel();
            	
            	displayDaysPanel.setBreakTimes(breakTimes);
            	displayDaysPanel.setPay(pay);
            	displayDaysPanel.sortByDays(workTimes);
            	
            	updatePane(displayDaysPanel);
            	
            	break;
            case SortByWeeks:
            	
            	DisplayEntriesPanel  displayWeeksPanel = new DisplayEntriesPanel();
            	
            	displayWeeksPanel.setBreakTimes(breakTimes);
            	displayWeeksPanel.setPay(pay);
            	displayWeeksPanel.sortByWeeks(workTimes);
            	
            	updatePane(displayWeeksPanel);
            	
            	break;
        }
    }
    
    public static void quitProgram() {
    	frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

	public static ArrayList<WorkEntry> getWorkTimes() {
		return workTimes;
	}

	public static void setWorkTimes(ArrayList<WorkEntry> workTimes) {
		FrameManager.workTimes = workTimes;
	}
}
