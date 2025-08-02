package Collections;

import java.util.*;

public class IteratorDemo {
    public static void main(String[] args) {
        // Task 4.1: Use an Iterator to remove elements starting with 'A'
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Andrew", "Charlie", "Angela", "David"));

        System.out.println("Original List: " + names);

        Iterator<String> itr = names.iterator();
        while (itr.hasNext()) {
            String name = itr.next();
            if (name.startsWith("A")) {
                itr.remove();  // Safe removal using Iterator
            }
        }

        System.out.println("After removing names starting with 'A': " + names);

        System.out.println("\n----------------------------\n");

        // Task 4.2: ListIterator for bi-directional traversal
        List<String> cities = new ArrayList<>(Arrays.asList("Delhi", "Mumbai", "Chennai", "Kolkata"));

        ListIterator<String> listItr = cities.listIterator();

        System.out.println("Forward Traversal:");
        while (listItr.hasNext()) {
            System.out.println(listItr.next());
        }

        System.out.println("Backward Traversal:");
        while (listItr.hasPrevious()) {
            System.out.println(listItr.previous());
        }
    }
}

