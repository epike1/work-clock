package dataFunctions;

import java.text.DecimalFormat;

public class WorkEntry {

    private String date;
    private double hours;

    public WorkEntry(String date, double hours) {

        setDate(date);
        setHours(hours);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public double calculateTotalPay(double pay, int breaks) {
    	DecimalFormat df = new DecimalFormat("#.##"); // used to convert to two decimal places to format easier
        return Double.parseDouble(df.format(pay * (getHours() - ((double)breaks / 60))));
    }
}
