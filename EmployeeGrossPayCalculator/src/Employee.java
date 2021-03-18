
// Class Employee definition

public class Employee{

// Instance variables to store data

	String id;

	String firstName;

	String lastName;

	double payRate;

	String payPeriodEndDate;

	double hoursWorked;

	double grossPay;

	double overTimeHour;

	double overTimePay;

	double regularPay;

// Default constructor to initialize instance variables

	Employee(){

			id = firstName = lastName = payPeriodEndDate = "";

			payRate = hoursWorked = grossPay = overTimeHour = overTimePay = regularPay = grossPay = 0;

	}// End of constructor

// Overrides toString() method to return employee information

	public String toString(){

		return "\n ID: " + id + "\n Name: " + firstName + " " + lastName + "\n Pay End Date Period: " + payPeriodEndDate

				+ "\n Regular Pay: " + payRate + "\n Hours Worked: " + hoursWorked +

				"\n Over Time Hour: " + overTimeHour + "\n Regular Pay: " + regularPay +

				"\n Over Time Pay" + overTimePay + "\n Gross Pay: " + grossPay;

		}// End of method

// Method to calculate gross pay

	void calculate(){

// Checks if the hours worked is greater than 40 which is regular hour

		if(hoursWorked > 40)

// Calculates over time

			overTimeHour = hoursWorked - 40;

// Calculates regular pay

		regularPay = hoursWorked * payRate;

// Calculates over time pay

		overTimePay = overTimeHour * payRate * 1.5;

// Calculates gross pay

		grossPay = regularPay + overTimePay;

	}// End of method

}// End of class