package Collections;

import java.util.*;

public class SetsDemo {
    public static void main(String[] args) {
        // Task 2.1: Set Properties using HashSet
        Set<String> languages = new HashSet<>();

        // Adding elements (including duplicates)
        languages.add("Java");
        languages.add("Python");
        languages.add("C++");
        languages.add("Java");    // duplicate
        languages.add("Python");  // duplicate

        // HashSet does not allow duplicates
        System.out.println("HashSet (no duplicates): " + languages);

        // Task 2.2: Sorted Set using TreeSet
        Set<Integer> numbers = new TreeSet<>();

        numbers.add(50);
        numbers.add(20);
        numbers.add(70);
        numbers.add(40);
        numbers.add(10);

        // TreeSet automatically sorts elements
        System.out.println("TreeSet (sorted order): " + numbers);
    }
}
