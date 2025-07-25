package JavaFundamentals;

public class OperatorExamples {
    public static void main(String[] args) {
        int x = 4;
        System.out.println("Pre-increment: " + (++x)); // 5
        System.out.println("Post-increment: " + (x++)); // 5
        System.out.println("After post: " + x); // 6

        int a = 8;  // 1000
        int b = 2;  // 0010
        System.out.println("a >> 1: " + (a >> 1)); // 4
        System.out.println("a << 1: " + (a << 1)); // 16

        int p = 10, q = 20;
        System.out.println("Logical AND: " + (p < q && p > 5)); // true
        System.out.println("Bitwise AND: " + (p < q & p > 5)); // true
    }
}
