package JavaFundamentals;

import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        System.out.println("Average: " + average(arr));
        System.out.println("Minimum: " + minimum(arr));
        System.out.println("Maximum: " + maximum(arr));
        sc.close();
    }

    public static int average(int[] a) {
        int sum = 0;
        for (int num : a) sum += num;
        return sum / a.length;
    }

    public static int minimum(int[] a) {
        int min = a[0];
        for (int num : a) if (num < min) min = num;
        return min;
    }

    public static int maximum(int[] a) {
        int max = a[0];
        for (int num : a) if (num > max) max = num;
        return max;
    }
}

