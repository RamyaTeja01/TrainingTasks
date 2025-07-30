package ECommerceApp;

public abstract class Product {
    protected String id, name;
    protected double price;
    protected int stock;

    public Product(String id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public abstract void displayDetails();
    public double getPrice() { 
    	return price; 
    }
    public boolean isInStock() { 
    	return stock > 0; 
    }
    public void reduceStock() { 
    	if(stock > 0) stock--; 
    }
}
