package ECommerceApp;

public class Clothing extends Product {
    private String size, fabric;

    public Clothing(String id, String name, double price, int stock, String size, String fabric) {
        super(id, name, price, stock);
        this.size = size;
        this.fabric = fabric;
    }

    public void displayDetails() {
        System.out.println("Clothing: " + name + " | Size: " + size + " | Fabric: " + fabric + " | Price: ₹" + price);
    }
}