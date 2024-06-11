// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import dataFunctions.*;
import screenFunctions.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<WorkEntry> workList = new ArrayList<WorkEntry>();
        workList.add(new WorkEntry("09/06/2024", 15.00, 5, 40));
        workList.add(new WorkEntry("10/06/2024", 15.00, 5, 40));
        workList.add(new WorkEntry("09/07/2024", 15.00, 5, 40));
        workList.add(new WorkEntry("09/05/2024", 15.00, 5, 40));
        workList.add(new WorkEntry("08/06/2024", 15.00, 5, 40));
        workList.add(new WorkEntry("09/06/2023", 15.00, 5, 40));

        workList = trackerFunctions.sortByDays(workList);
    }
}