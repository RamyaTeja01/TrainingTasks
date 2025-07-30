package WrapperClass;

import java.util.ArrayList;
import java.util.List;

public class AutoBoxingAndUnBoxingDemo {
    public static void main(String[] args) {
        // Step 1: Declare a List<Double> and add primitive double values
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(15.5);
        doubleList.add(27.0);
        doubleList.add(19.25);
        doubleList.add(8.75);

        // Step 2: Retrieve values and calculate sum
        double sum = 0.0;
        for (Double value : doubleList) {
            sum += value; // Unboxing happens here automatically
        }

        // Step 3: Calculate and display average
        double average = sum / doubleList.size();

        // Step 4: Print results
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average: " + average);
    }
}
