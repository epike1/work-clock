package dataFunctions;

public class TableEntry {

	private String date = "";
	private double hoursWorked = 0;
	private int breakMinutes = 0;
	private double pay = 0;
	
	public TableEntry(String date, double hoursWorked, int breakMinutes, double pay) {
		this.date = date;
		this.hoursWorked = hoursWorked;
		this.breakMinutes = breakMinutes;
		this.pay = pay;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getBreakMinutes() {
		return breakMinutes;
	}

	public void setBreakMinutes(int breakMinutes) {
		this.breakMinutes = breakMinutes;
	}

	public double getPay() {
		return pay;
	}

	public void setPay(double pay) {
		this.pay = pay;
	}
	
	
}
