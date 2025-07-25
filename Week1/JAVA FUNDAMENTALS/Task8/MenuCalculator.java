package JavaFundamentals;


public class MenuCalculator {
    public static void main(String[] args) {
        int a = 8, b = 4;
        int choice = 3; // we can change this to simulate menu input

        switch (choice) {
            case 1: System.out.println("Add: " + (a + b)); break;
            case 2: System.out.println("Subtract: " + (a - b)); break;
            case 3: System.out.println("Multiply: " + (a * b)); break;
            case 4: System.out.println("Divide: " + (a / b)); break;
            default: System.out.println("Invalid choice");
        }
    }
}

