package Collections;

import java.util.*;

public class UtilityClassDemo {
    public static void main(String[] args) {
        // Task 7.1: Reverse a List
        List<String> languages = new ArrayList<>(Arrays.asList("Java", "Python", "C++", "JavaScript", "Ruby"));
        
        System.out.println("Original List:");
        System.out.println(languages);

        Collections.reverse(languages);

        System.out.println("Reversed List:");
        System.out.println(languages);

        System.out.println("\n-------------------------\n");

        // Task 7.2: Frequency of "Java"
        List<String> techList = Arrays.asList("Java", "C", "Java", "Python", "Java", "C++");

        int javaCount = Collections.frequency(techList, "Java");

        System.out.println("List: " + techList);
        System.out.println("Frequency of 'Java': " + javaCount);
    }
}
