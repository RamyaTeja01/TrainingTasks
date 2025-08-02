package WrapperClass;

import java.util.Arrays;

public class WrapperSortExample {
    public static void main(String[] args) {
        // Step 1: Create an array of Integer objects
        Integer[] numbers = {45, 72, 18, 90, 33, 90};  // Wrapper class used

        // Step 2: Sort the array (ascending)
        Arrays.sort(numbers);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Step 3: Find the 2nd highest value
        // Traverse from end and find the second distinct highest
        int highest = numbers[numbers.length - 1];
        Integer secondHighest = null;

        for (int i = numbers.length - 2; i >= 0; i--) {
            if (!numbers[i].equals(highest)) {
                secondHighest = numbers[i];
                break;
            }
        }

        if (secondHighest != null) {
            System.out.println("2nd Highest Value: " + secondHighest);
        } else {
            System.out.println("All values are the same. No 2nd highest found.");
        }
    }
}