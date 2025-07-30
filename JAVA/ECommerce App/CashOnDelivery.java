package ECommerceApp;

public class CashOnDelivery extends Payment {
    public CashOnDelivery(double amount) {
        super(amount);
    }
    public void processPayment() {
        System.out.println("Payment of ₹" + amount + " will be collected on delivery.");
    }
}