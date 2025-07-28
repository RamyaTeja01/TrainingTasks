package MultiThreading;


class BankAccount { 
    int balance = 2000; 
 
    synchronized void withdraw(int amount, String customer) { 
        if (balance >= amount) { 
            balance -= amount; 
            System.out.println("Balance: " + balance); 
        } else { 
            System.out.println(customer + " insufficient funds"); 
        } 
    } 
} 
public class BankAccountSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 BankAccount account = new BankAccount(); 
		 
	        Runnable user1 = () -> account.withdraw(1000, "c1"); 
	        Runnable user2 = () -> account.withdraw(800, "c2"); 
	        Runnable user3=  () -> account.withdraw(500,"c3");
	 
	        new Thread(user1).start(); 
	        new Thread(user2).start();
	        new Thread(user3).start();
	}

}
