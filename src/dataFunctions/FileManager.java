package dataFunctions;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final File infoFile = new File("work-clock-ver0.2/src/info.txt");

    private static final File workFile = new File("work-clock-ver0.2/src/work.txt");

    public static void setFile() { // checks if files already exists and creates if they do not

        try {

            infoFile.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            workFile.createNewFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkInfoFile() { // checks if info file has data

        int numOfLines = 0;

        try {
            BufferedReader infoReader = new BufferedReader(new FileReader(infoFile));
            while (infoReader.readLine() != null) numOfLines++; // go through each line and check for text
            infoReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return numOfLines >= 2;
    }

    public static void updateInfo(String name, double pay, ArrayList<int[]> breakList) {

        try {
            BufferedWriter infoWriter = new BufferedWriter(new FileWriter(infoFile));

            infoWriter.write(name);
            infoWriter.newLine();
            infoWriter.write(Double.toString(pay));
            infoWriter.newLine();

            for (int[] list : breakList) { // write each break range and break time in one line each
                StringBuilder line = new StringBuilder();

                for (int num : list) {
                    line.append(num).append(" ");
                }

                infoWriter.write(line.toString());
                infoWriter.newLine();
            }

            infoWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Object> getInfo() {

        ArrayList<Object> infoList = new ArrayList<>();

        try {

            BufferedReader infoReader = new BufferedReader(new FileReader(infoFile));

            infoList.add(infoReader.readLine()); // getting name
            infoList.add(infoReader.readLine()); // getting pay


            ArrayList<int[]> breakList = new ArrayList<int[]>();
            while (true) {

                int[] breakEntry = {0, 0, 0};
                String numString = infoReader.readLine();
                if (numString != null) {
                	String[] numList =  numString.split(" ");
                
                

                

                for (int i = 0; i < numList.length; i++) {
                       breakEntry[i] = Integer.parseInt(numList[i]);
                }

                breakList.add(breakEntry);
                
                } else {
                	break;
                }
            }
            
            infoList.add(breakList);
            infoReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return infoList;
    };

    public static void writeWorkTime(ArrayList<WorkEntry> workTimes) {

        try {
            BufferedWriter workWriter = new BufferedWriter(new FileWriter(workFile));

            for (WorkEntry entry : workTimes) {

                StringBuilder line = new StringBuilder();

                line.append(entry.getDate()).append(" ");
                line.append(entry.getHours()).append(" ");

                workWriter.write(line.toString());
                workWriter.newLine();
            }

            workWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public static ArrayList<WorkEntry> getWorkTimes() {

        ArrayList<WorkEntry> workList = new ArrayList<WorkEntry>();

        try {

            BufferedReader workReader = new BufferedReader(new FileReader(workFile));

            while (true) {
                String entryString = workReader.readLine();
                
                if (entryString == null) {
                	break;
                } else {
                	String[] entryList = entryString.split(" ");
                	workList.add(new WorkEntry(entryList[0], Double.parseDouble(entryList[1])));
                }

            }
            
            workReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return workList;
    }
    
    @SuppressWarnings("unchecked")
	public static ArrayList<int[]> convertFromObjectList(Object object) { // converts object list to array list of integer lists
    	
    	ArrayList<int[]> arrayList = new ArrayList<int[]>();
    	
    	
    	if (object instanceof ArrayList<?>) {
    		arrayList = (ArrayList<int[]>) object;
    	}
    	
    	return arrayList;
    }

    
}