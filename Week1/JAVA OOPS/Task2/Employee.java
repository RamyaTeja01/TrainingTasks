package Week1;

class EmployeeCount {
    static int count = 0;

    // Constructor increments count
    EmployeeCount() {
        count++;
    }

    // Getter method
    static int getCount() {
        return count;
    }
}

public class Employee {
    public static void main(String[] args) {
        // Create multiple EmployeeCount objects
        EmployeeCount e1 = new EmployeeCount();
        EmployeeCount e2 = new EmployeeCount();
        EmployeeCount e3 = new EmployeeCount();
        EmployeeCount e4 = new EmployeeCount();
        EmployeeCount e5 = new EmployeeCount();
    	


        // Print the total number of employees created
        System.out.println("Total number of employees: " + EmployeeCount.getCount());
    }
}
 
