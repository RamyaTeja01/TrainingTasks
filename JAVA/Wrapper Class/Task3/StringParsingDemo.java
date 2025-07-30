package WrapperClass;

public class StringParsingDemo {
    public static void main(String[] args) {
        // Step 1: Input strings
        String intString = "12345678";
        String doubleString = "89.23";
        String booleanString = "true";

        // Step 2: Parse strings into primitives
        int intValue = Integer.parseInt(intString);
        double doubleValue = Double.parseDouble(doubleString);
        boolean booleanValue = Boolean.parseBoolean(booleanString);

        // Step 3: Print values and their types (using wrappers to show type)
        System.out.println("Integer value: " + intValue + ", Type: " + ((Object)intValue).getClass().getSimpleName());
        System.out.println("Double value: " + doubleValue + ", Type: " + ((Object)doubleValue).getClass().getSimpleName());
        System.out.println("Boolean value: " + booleanValue + ", Type: " + ((Object)booleanValue).getClass().getSimpleName());
    }

}
