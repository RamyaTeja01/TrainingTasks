package ECommerceApp;

public class Customer {
    private String name, email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void displayCustomer() {
        System.out.println("Customer: " + name + " | Email: " + email);
    }
}
