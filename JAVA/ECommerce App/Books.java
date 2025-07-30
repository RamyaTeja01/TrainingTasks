package ECommerceApp;


public class Books extends Product {
    private String author;

    public Books(String id, String name, double price, int stock, String author) {
        super(id, name, price, stock);
        this.author = author;
    }

    public void displayDetails() {
        System.out.println("Book: " + name + " | Author: " + author + " | Price: ₹" + price);
    }
}
