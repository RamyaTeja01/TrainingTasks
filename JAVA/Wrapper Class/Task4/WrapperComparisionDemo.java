package WrapperClass;

public class WrapperComparisionDemo {
    public static void main(String[] args) {
        // Autoboxing: Integer objects created automatically
        Integer a = 100;
        Integer b = 100;

        // Using 'new' keyword: explicitly creates new objects
        Integer x = new Integer(100);
        Integer y = new Integer(100);

        // Comparisons
        System.out.println("a == b: " + (a == b));               // true (cached)
        System.out.println("a.equals(b): " + a.equals(b));       // true

        System.out.println("x == y: " + (x == y));               // false (different objects)
        System.out.println("x.equals(y): " + x.equals(y));       // true

        System.out.println("a == x: " + (a == x));               // false(different memory)
        System.out.println("a.equals(x): " + a.equals(x));       // true
    }
}
