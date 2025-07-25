package JavaFundamentals;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Enter a positive number or enter -1 to stop: ");
            n = sc.nextInt();
        } while (n != -1);

        sc.close();
    }
}

