package Collections;

import java.util.*;

public class ListsDemo {
    public static void main(String[] args) {
        // Task 1.1: Basic ArrayList Operations
        List<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("C");
        languages.add("C++");
        languages.add("Ruby");
        languages.add("Python");

        // Remove the 2nd element (index 1 -> "C")
        languages.remove(1);

        System.out.println("After removing 2nd element: " + languages);
        // Expected Output: [Java, C++, Ruby, Python]

        // Task 1.2: Sorting a List
        List<Integer> numbers = Arrays.asList(5, 1, 9, 3, 7);

        // Sort in Ascending Order
        List<Integer> ascending = new ArrayList<>(numbers);
        Collections.sort(ascending);
        System.out.println("Ascending Order: " + ascending);

        // Sort in Descending Order
        List<Integer> descending = new ArrayList<>(numbers);
        descending.sort(Collections.reverseOrder());
        System.out.println("Descending Order: " + descending);

        // Task 1.3: Remove Duplicates from a List
        List<String> techList = Arrays.asList("Java", "C", "Java", "Python");

        // Use LinkedHashSet to maintain insertion order and remove duplicates
        Set<String> uniqueTech = new LinkedHashSet<>(techList);
        System.out.println("After removing duplicates: " + uniqueTech);
    }
}
