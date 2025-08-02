package Collections;

import java.util.*;

public class MapsDemo {
    public static void main(String[] args) {
        // Task 3.1: Basic Map Operations
        Map<Integer, String> studentMap = new HashMap<>();

        // Add 5 entries
        studentMap.put(101, "Ramya");
        studentMap.put(102, "Ravi");
        studentMap.put(103, "Teja");
        studentMap.put(104, "Shyam");
        studentMap.put(105, "Bhavani");

        // Remove one entry
        studentMap.remove(103); // removes Teja

        // Iterate using entrySet()
        System.out.println("Student Roll Numbers:");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println("Roll No: " + entry.getKey() + ", Name: " + entry.getValue());
        }

        // Separator
        System.out.println("\n----------------------------\n");

        // Task 3.2: Frequency Counter
        String input = "hello";
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char ch : input.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        System.out.println("Character Frequency for \"" + input + "\":");
        System.out.println(freqMap);

        // Separator
        System.out.println("\n----------------------------\n");

        // Task 3.3: Sort Map by Keys
        Map<Integer, String> unsortedMap = new HashMap<>();
        unsortedMap.put(50, "Fifty");
        unsortedMap.put(20, "Twenty");
        unsortedMap.put(40, "Forty");
        unsortedMap.put(10, "Ten");
        unsortedMap.put(30, "Thirty");

        // Create TreeMap from HashMap
        TreeMap<Integer, String> sortedMap = new TreeMap<>(unsortedMap);

        System.out.println("Sorted Map by Keys:");
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
