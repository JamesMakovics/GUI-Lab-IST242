import java.io.*;
import java.util.*;
import javax.swing.*;

// Driver class EmployeeGui definition

public class EmployeeGui {

// Declares employee class array of objects

	Employee emp[];

// Default constructor

	EmployeeGui(){

// Calls the method to read the file contents and store it in employee array of objects

readFile("C:\\Users\\delta\\Documents\\GitHub\\GUI-Lab-IST242\\Employees.txt");

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

// Loops till end of the file

		while(sc.hasNext()){

// Increase the record counter

			no++;

// Reads data

			sc.next();

		}// End of while loop

// Close the file

		sc.close();

// Re opens the file for reading

		sc = new Scanner(new File(fileName));

// Creates array of objects of record size no

		emp = new Employee[no];

// Loops till number of records

		for(int c = 0; c < no; c++)

// Initializes each object using default constructor

			emp[c] = new Employee();

// Reset the record counter to zero`

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

}// End of try block

// Catch block to handle FileNotFoundException exception

	catch(FileNotFoundException fe){

		fe.printStackTrace();

		}// End of catch block

	}// End of method

// Method to accept data from the user

	void acceptData(){

// Variable to store record found status

		int found, x;

// Loops till valid id entered by the user

		do{

// Sets the found status to zero for each id entered by the user

			found = 0;

// Accept the id from the user

			String id = JOptionPane.showInputDialog("Enter ID");

// Loops till end of the record

			for(x = 0; x < emp.length; x++){

// Checks current employee id with user entered id

				if(emp[x].id.equalsIgnoreCase(id)){

// Set the found status to one for found

					found = 1;

// Come out of the for loop

					break;

				}// End of if condition

			}// End of for loop

// Checks if found value is zero id not found

			if(found == 0)

// Displays error message

				JOptionPane.showMessageDialog(null, "ID not found. \nPlease reenter", "ERROR", JOptionPane.INFORMATION_MESSAGE);

// Otherwise, record found

			else{

// Accept the date

				String date = JOptionPane.showInputDialog("Enter Pay Period End Date.");

// Accepts the hours worked

				double work = Double.parseDouble(JOptionPane.showInputDialog("Enter Hours Worked."));

// Stores the data in instance variables of x index position of array of Employee class object

				emp[x].payPeriodEndDate = date;
				emp[x].hoursWorked = work;

// Calls the method to calculate gross pay for the found record

				emp[x].calculate();

// Displays the employee information by calling toString() method implicitly

				JOptionPane.showMessageDialog(null, emp[x], "Employee Information.", JOptionPane.INFORMATION_MESSAGE);

// Come out of the while loop

				break;

			}// End of else

		}while(true); // End of do - while loop

	}// End of method

// main method definition

	public static void main(String[] args){

// Calls the constructor using anonymous object

		new EmployeeGui();

		}// End of main method

	}// End of driver class