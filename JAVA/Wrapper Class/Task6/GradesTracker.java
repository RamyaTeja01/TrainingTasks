package WrapperClass;

import java.util.ArrayList;
import java.util.Collections;

public class GradesTracker {
    public static void main(String[] args) {
        // Create an ArrayList of Integer
        ArrayList<Integer> marks = new ArrayList<>();

        // Add 5 student marks using autoboxing
        marks.add(85);  // autoboxed to Integer.valueOf(85)
        marks.add(72);
        marks.add(90);
        marks.add(68);
        marks.add(77);

        System.out.println("Original Marks: " + marks);

        // Remove the lowest mark
        Integer minMark = Collections.min(marks);
        marks.remove(minMark);  // removes first occurrence
        System.out.println("After removing lowest mark (" + minMark + "): " + marks);

        // Calculate max, min, and average
        int max = Collections.max(marks);
        int min = Collections.min(marks);
        double avg = 0;
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }
        avg = (double) sum / marks.size();

        // Print the results
        System.out.println("Max Mark: " + max);
        System.out.println("Min Mark: " + min);
        System.out.println("Average: " + avg);
    }
}
