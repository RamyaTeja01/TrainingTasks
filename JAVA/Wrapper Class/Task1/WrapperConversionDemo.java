package WrapperClass;

public class WrapperConversionDemo {
    public static void main(String[] args) {

        // Step 1: Primitive values
        int intPrimitive = 25;
        double doublePrimitive = 67.5;
        char charPrimitive = 'R';

        // Step 2: Convert primitives to wrappers using valueOf()
        Integer intWrapper = Integer.valueOf(intPrimitive);
        Double doubleWrapper = Double.valueOf(doublePrimitive);
        Character charWrapper = Character.valueOf(charPrimitive); // valueOf is used here too

        // Step 3: Convert wrappers back to primitives using xxxValue()
        int intBack = intWrapper.intValue();
        double doubleBack = doubleWrapper.doubleValue();
        char charBack = charWrapper.charValue();

        // Step 4: Print everything
        System.out.println("Original int: " + intPrimitive + ", Wrapper: " + intWrapper + ", Back to int: " + intBack);
        System.out.println("Original double: " + doublePrimitive + ", Wrapper: " + doubleWrapper + ", Back to double: " + doubleBack);
        System.out.println("Original char: " + charPrimitive + ", Wrapper: " + charWrapper + ", Back to char: " + charBack);
    }
}
