package WrapperClass;

public class GenericsDemo<T> {
    private T value;

    // Method to store a value
    public void setValue(T value) {
        this.value = value;
    }

    // Method to retrieve the value
    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        // Instantiate Box for Integer (autoboxing from int to Integer)
    	GenericsDemo<Integer> intBox = new GenericsDemo<>();
        intBox.setValue(56);  // autoboxing
        Integer intValue = intBox.getValue();
        System.out.println("Integer Value: " + intValue);

        // Instantiate Box for Double (autoboxing from double to Double)
        GenericsDemo<Double> doubleBox = new GenericsDemo<>();
        doubleBox.setValue(12.345);  // autoboxing
        Double doubleValue = doubleBox.getValue();
        System.out.println("Double Value: " + doubleValue);
    }
}
