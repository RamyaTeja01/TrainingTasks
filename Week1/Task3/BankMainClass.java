package Week1;

public class BankMainClass 
{
	// Main method for testing
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount acc = new BankAccount("FED12345", 2000.0);

        // Using getters
        System.out.println("Account Number: " + acc.getAccountNumber());
        System.out.println("Balance       : ₹" + acc.getBalance());

        // Using deposit and withdraw
        acc.deposit(2500);
        acc.withdraw(1300);

        // Using setters
        acc.setAccountNumber("FED67890");
        acc.setBalance(10000);  // Using setter to directly set balance

        // Updated info
        System.out.println("Updated Account Number: " + acc.getAccountNumber());
        System.out.println("Updated Balance       : ₹" + acc.getBalance());
    }
}
