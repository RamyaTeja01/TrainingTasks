package ECommerceApp;

public class Electronics extends Product {
    private String brand;
    private int warrantyMonths;

    public Electronics(String id, String name, double price, int stock, String brand, int warrantyMonths) {
        super(id, name, price, stock);
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public void displayDetails() {
        System.out.println("Electronics: " + name + " | Brand: " + brand + " | Warranty: " + warrantyMonths + " months | Price: ₹" + price);
    }
}
