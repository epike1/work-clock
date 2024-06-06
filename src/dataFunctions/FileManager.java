package dataFunctions;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private static final File infoFile = new File("src/info.txt");

    private static final File workFile = new File("src/work.txt");

    public static void setFile() { // checks if files already exists and creates if they do not

        try {

            if (infoFile.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            if (workFile.createNewFile()) {
                System.out.println("File created.");
            } else {
                System.out.println("File already exists.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkInfoFile() { // checks if info file has data

        int numOfLines = 0;

        try {
            BufferedReader infoReader = new BufferedReader(new FileReader(infoFile));
            while (infoReader.readLine() != null) numOfLines++; // go through each line and check for text
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numOfLines >= 2;
    }

    public static void updateInfo(String name, double pay, ArrayList<int[]> breakList) {

        try {
            BufferedWriter infoWriter = new BufferedWriter(new FileWriter(infoFile));

            infoWriter.write(name);
            infoWriter.write(Double.toString(pay));

            for (int[] list : breakList) { // write each break range and break time in one line each
                StringBuilder line = new StringBuilder();

                for (int num : list) {
                    line.append(num).append(" ");
                }

                infoWriter.write(line.toString());
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



            while (true) {

                int[] breakList = {0, 0, 0};
                String[] numList =  infoReader.readLine().split(" ");

                if (numList.length == 0) {
                    break;
                } else {

                    for (int i = 0; i < numList.length; i++) {
                        breakList[i] = Integer.parseInt(numList[i]);
                    }

                }

                infoList.add(breakList);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return infoList;
    };

    public static void writeWorkTime(ArrayList<String[]> workTimes) {

        try {
            BufferedWriter workWriter = new BufferedWriter(new FileWriter(workFile));

            for (String[] list : workTimes) {

                StringBuilder line = new StringBuilder();

                for (String str : list) {
                    line.append(str).append(" ");
                }

                workWriter.write(line.toString());
            }

            workWriter.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<String[]> getWorkTime() {

        ArrayList<String[]> workList = new ArrayList<String[]>();

        try {

            BufferedReader workReader = new BufferedReader(new FileReader(workFile));

            while (true) {
                String[] line = workReader.readLine().split(" ");

                if (line.length == 0) {
                    break;
                } else {
                    workList.add(line);
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return workList;
    }
}
