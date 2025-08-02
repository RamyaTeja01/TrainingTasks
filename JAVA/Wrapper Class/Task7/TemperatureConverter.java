package WrapperClass;

import java.util.ArrayList;

public class TemperatureConverter {
    public static void main(String[] args) {
        // Input temperature strings
        String[] tempStrings = {"36", "38", "40"};

        // List to store Fahrenheit values
        ArrayList<Double> fahrenheitList = new ArrayList<>();

        System.out.println("Celsius to Fahrenheit Conversion:");

        for (String tempStr : tempStrings) {
            // Convert string to integer (Celsius)
            int celsius = Integer.parseInt(tempStr);

            // Convert to Fahrenheit
            double fahrenheit = (celsius * 9.0 / 5.0) + 32;

            // Store in ArrayList (autoboxing)
            fahrenheitList.add(fahrenheit);

            // Print both Celsius and Fahrenheit
            System.out.println(celsius + "°C = " + fahrenheit + "°F");
        }

        // Optionally, print the full Fahrenheit list
        System.out.println("\nFahrenheit List: " + fahrenheitList);
    }
}
