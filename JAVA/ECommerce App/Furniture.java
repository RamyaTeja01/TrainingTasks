package ECommerceApp;

public class Furniture extends Product {
    private String material;

    public Furniture(String id, String name, double price, int stock, String material) {
        super(id, name, price, stock);
        this.material = material;
    }

    public void displayDetails() {
        System.out.println("Furniture: " + name + " | Material: " + material + " | Price: ₹" + price);
    }
}
