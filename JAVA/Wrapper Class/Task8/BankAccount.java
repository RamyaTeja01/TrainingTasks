package WrapperClass;

public class BankAccount {
    private String accountNumber;
    private Double balance;  // Using Double wrapper (can be null)

    // Constructor
    public BankAccount(String accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        // Handle null balance by setting default to 0.0
        if (balance == null) {
            this.balance = 0.0;
            System.out.println("Balance was null. Defaulting to 0.0");
        } else {
            this.balance = balance;
        }
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
        }
    }

    // Show balance
    public void showBalance() {
        System.out.println("Current Balance: ₹" + balance);
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Create BankAccount with null balance
        BankAccount account1 = new BankAccount("ACC123456", null);

        account1.showBalance();
        account1.deposit(5000.0);
        account1.withdraw(1200.0);
        account1.showBalance();

        System.out.println();

        // Create BankAccount with non-null balance
        BankAccount account2 = new BankAccount("ACC987654", 10000.0);

        account2.showBalance();
        account2.withdraw(3000.0);
        account2.deposit(1500.0);
        account2.showBalance();
    }
}
