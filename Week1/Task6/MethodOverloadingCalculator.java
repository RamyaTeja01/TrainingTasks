package Week1;


class AdditionOverloading {
    int add(int num1, int num2) {
        return num1 + num2;
    }

    double add(double num1, double num2) {
        return num1 + num2;
    }

    String add(String firstName, String lastName) {
        return firstName.concat(" " + lastName);
    }
}

public class MethodOverloadingCalculator {
    public static void main(String[] args) {
        AdditionOverloading add = new AdditionOverloading();

        int intResult = add.add(5, 5);
        double doubleResult = add.add(25.0, 26.5);
        String stringResult = add.add("Ramya", "Teja");

        System.out.println("Addition of integers: " + intResult);
        System.out.println("Addition of doubles: " + doubleResult);
        System.out.println("Concatenation of strings: " + stringResult);
    }
}
