package ExceptionHandling.Employee;

public class Employee {

	    public static String companyName = "WIPRO";

	    private String empName;
	    private int empId;

	    public Employee(String name, int empId) {
	        this.empName = name;
	        this.empId = empId;
	    }

	    public void displayEmployeeDetails() {
	        System.out.println("Employee Name: " + empName + ", Employee Id: " + empId);
	    }

	    public static void displayCompanyDetails() {
	        System.out.println("Company Name: " + companyName);
	    }

}
