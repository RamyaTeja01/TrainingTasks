package ExceptionHandling;

import ExceptionHandling.Employee.Employee;
import static ExceptionHandling.Employee.Employee.companyName;
import static ExceptionHandling.Employee.Employee.displayCompanyDetails;

public class EmployeeMain {
	public static void main(String[] args) {
	     Employee e1 = new Employee("Ramya", 1234);
	     e1.displayEmployeeDetails();

	     System.out.println("Static Imported Company Name: " + companyName);
	     displayCompanyDetails();
	     
	}

}
