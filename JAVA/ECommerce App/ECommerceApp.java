package ECommerceApp;

import java.util.Arrays;

public class ECommerceApp {
    public static void main(String[] args) {
        Product phone = new Electronics("E101", "OnePlus 12", 59999, 3, "OnePlus", 24);
        Product shirt = new Clothing("C202", "Denim Shirt", 1999, 10, "M", "Cotton");
        Product book = new Books("B301", "Atomic Habits", 499, 5, "James Clear");
        Product table = new Furniture("F404", "Dining Table", 9999, 1, "Wood");

        Customer customer = new Customer("Ramya Teja", "ramya@gmail.com");

        Order order = new Order(customer, Arrays.asList(phone, shirt, book, table));

        Discountable discount = (price) -> price * 0.50;

        Payment payment = new CashOnDelivery(1234);

        order.placeOrder(payment, discount);

       
    }
}