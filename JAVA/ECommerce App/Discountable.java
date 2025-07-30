package ECommerceApp;

@FunctionalInterface
public interface Discountable {
    double applyDiscount(double price);
}