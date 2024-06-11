package dataFunctions;

public class WorkEntry {

    private String date;
    private double pay;
    private double hours;
    private int breakTime;

    public WorkEntry(String date, double pay, double hours, int breakTime) {

        setDate(date);
        setPay(pay);
        setHours(hours);
        setBreakTime(breakTime);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public double getPay() {
        return pay;
    }


    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getHours() {
        return hours;
    }

    public void setBreakTime(int breakTime) {
        this.breakTime = breakTime;
    }

    public int getBreakTime() {
        return breakTime;
    }

    public double calculateTotalPay() {
        return getPay() * (int)(getHours() - getBreakTime());
    }
}
