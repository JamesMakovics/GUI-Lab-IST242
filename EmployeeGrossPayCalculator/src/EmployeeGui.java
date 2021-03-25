import java.io.*;
import java.util.*;
import javax.swing.*;

//author James Makovics and Tony Feliciano


// Driver class EmployeeGui definition

public class EmployeeGui {

// Declares employee array of objects

	Employee emp[];

// Default constructor

	EmployeeGui(){

// Calls the read file method to read the file contents and store it in the employee array

readFile("C:\\Users\\delta\\Documents\\GitHub\\GUI-Lab-IST242\\Employees.txt"); //Employees File Path Goes HERE!

// Calls the function accept employee information

acceptData();

	}// End of constructor

// Function to read file contents and store it in the employee array of objects

void readFile(String fileName){

// Scanner class object declared

	Scanner sc;

// Try block begins

	try{

// Opens the file for reading

		sc = new Scanner(new File(fileName));

// Record counter

		int no = 0;

// Loops till end

		while(sc.hasNext()){

// Increase the record counter

			no++;

// Reads data

			sc.next();

		}// End of while loop

// Closes the file

		sc.close();

// Re opens the file for reading

		sc = new Scanner(new File(fileName));

// Creates array of objects of record size no

		emp = new Employee[no];

// Loops till end of records

		for(int c = 0; c < no; c++)

// Initializes each object using default constructor

			emp[c] = new Employee();

// Reset the record counter to zero

		no = 0;

// Loops till end of the file

		while(sc.hasNext()){

// Reads data from file

			String data = sc.next();

// Split the data using delimiter comma

			String data1[] = data.split(",");

// Stores the data in instance variables

			emp[no].id = data1[0];
			emp[no].firstName = data1[1];
			emp[no].lastName = data1[2];

// Converts the data to double and stores it in instance variable payRate
			emp[no].payRate = Double.parseDouble(data1[3]);

// Increase the index counter

			no++;

}// End of while loop

// Close the file

		sc.close();

}// End of try method

// Catch method to handle FileNotFoundException exception

	catch(FileNotFoundException fe){

		fe.printStackTrace();

		}// End of catch exception

	}// End of method

// Method that accepts input from the user

	void acceptData(){

// Variable to store record found status

		int found, x;

// Loops till valid id entered by the user

		do{

// Sets the found status to zero for id entered by the user

			found = 0;

// Accepts input id from the user

			String id = JOptionPane.showInputDialog("Enter ID");

// Loops till end of the array

			for(x = 0; x < emp.length; x++){

// Compares employee's id with user input id

				if(emp[x].id.equalsIgnoreCase(id)){

// Set the found status to one

					found = 1;

// End of the for loop

					break;

				}// End of if condition

			}// End of for loop

// Checks if found value is zero id not found

			if(found == 0)

// Displays error message "Employee ID is not found"

				JOptionPane.showMessageDialog(null, "ID not found. \nPlease re-enter", "ERROR", JOptionPane.INFORMATION_MESSAGE);

// Else record is found

			else{

// Accepts the date

				String date = JOptionPane.showInputDialog("Enter Pay Period End Date.");

// Accepts the hours worked by employee

				double work = Double.parseDouble(JOptionPane.showInputDialog("Enter Hours Worked."));

// Stores the data in instance variables of x index position of array of Employee class object

				emp[x].payPeriodEndDate = date;
				emp[x].hoursWorked = work;

// Calls the method calculate to figure out gross pay for the found record

				emp[x].calculate();

// Displays the employee information by calling toString() method implicitly

				JOptionPane.showMessageDialog(null, emp[x], "Employee Information.", JOptionPane.INFORMATION_MESSAGE);

// End of the while loop

				break;

			}// End of else

		}while(true); // End of do - while loop

	}// End of acceptData method

// main method definition

	public static void main(String[] args){

// Calls the constructor using anonymous object

		new EmployeeGui();

		}// End of main

	}// End of EmployeeGui class