package WrapperClass;

import java.util.Optional;

public class WrapperNullExample {
    public static void main(String[] args) {
        // Step 1: Declare a Double object and set it to null
        Double num = null;

        // Step 2: Try to unbox → This will throw NullPointerException
        try {
            double value = num;  // auto-unboxing
            System.out.println("Value: " + value);
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException during unboxing.");
        }

        // Step 3: Fix using default value strategy
        double safeValue = (num != null) ? num : 50.0;
        System.out.println("Safe unboxed value using ternary: " + safeValue);

        // Step 4: Fix using Optional
        Optional<Double> optionalNum = Optional.ofNullable(num);
        double optionalValue = optionalNum.orElse(35.0);
        System.out.println("Safe unboxed value using Optional: " + optionalValue);
    }
}
