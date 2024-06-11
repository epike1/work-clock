package screenFunctions;
import java.util.ArrayList;
import dataFunctions.WorkEntry;
public class trackerFunctions {


    private static double convertDateToDecimal(String date) {

        String[] dateList = date.split("/");
        double year = Double.parseDouble(dateList[2]); // year takes up columns above 0
        double month = Double.parseDouble(dateList[1]) / Math.pow(10, 2); // month takes up tenths and hundredths
        double day = Double.parseDouble(dateList[0]) / Math.pow(10, 4); // day takes up rest of columns

        return day + month + year;


    }
    private static boolean compareDates(String dateOne, String dateTwo) { // uses a double to represent dates, ex. June 6th, 2024 is 06.062024

        double decimalOne = convertDateToDecimal(dateOne);
        double decimalTwo = convertDateToDecimal(dateTwo);
        return decimalOne > decimalTwo;
    }
    public static ArrayList<WorkEntry> sortByDays(ArrayList<WorkEntry> workEntryList) {

        for (WorkEntry i : workEntryList) {

            System.out.print(i.getDate() + " ");
        }
        System.out.println();
        sort(workEntryList, 0, workEntryList.size() - 1);
        for (WorkEntry i : workEntryList) {

            System.out.print(i.getDate() + " ");
        }

        return workEntryList;
    }

    private static void merge(ArrayList<WorkEntry> arr, int l, int m, int r) // algorithm directly used to use with compareDates
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        WorkEntry[] L = new WorkEntry[n1];
        WorkEntry[] R = new WorkEntry[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);

        // Merge the temp arrays

        // Initial indices of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (compareDates(R[j].getDate(), L[i].getDate())) {
                arr.set(k, L[i]);
                i++;
            }
            else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    private static void sort(ArrayList<WorkEntry> arr, int l, int r)
    {
        if (l < r) {

            // Find the middle point
            int m = l + (r - l) / 2;

            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
}
