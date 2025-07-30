package ECommerceApp;


public class CardPayment extends Payment {
    private String cardNumber;
    public CardPayment(double amount, String cardNumber) {
        super(amount);
        this.cardNumber = cardNumber;
    }
    public void processPayment() {
        System.out.println("Paid ₹" + amount + " using Card ending: " + cardNumber.substring(cardNumber.length() - 4));
    }
}
