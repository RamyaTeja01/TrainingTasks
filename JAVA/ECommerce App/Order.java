package ECommerceApp;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> products;
    private boolean isCancelled = false;
    private double totalAmount;

    public Order(Customer customer, List<Product> products) {
        this.customer = customer;
        this.products = products;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    public void placeOrder(Payment payment, Discountable discountable) {
        if (isCancelled) {
            System.out.println("Order is cancelled.");
            return;
        }

        customer.displayCustomer();
        for (Product p : products) {
            if (!p.isInStock()) {
                System.out.println(p.name + " is out of stock.");
                return;
            }
            p.displayDetails();
        }

        double discounted = discountable.applyDiscount(totalAmount);
        System.out.println("Total after discount: ₹" + discounted);
        payment.amount = discounted;
        payment.processPayment();

        products.forEach(Product::reduceStock);
    }

    public void cancelOrder() {
        isCancelled = true;
        System.out.println("Order cancelled successfully.");
    }
}