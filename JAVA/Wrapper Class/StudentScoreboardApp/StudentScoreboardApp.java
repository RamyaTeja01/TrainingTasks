package WrapperClass;

import java.util.*;

public class StudentScoreboardApp {
    public static void main(String[] args) {
        // Step 1: Create Map to hold student names and their scores
        Map<String, List<Integer>> studentScores = new HashMap<>();

        // Adding sample data
        studentScores.put("Ramya", Arrays.asList(85, 92, 79));
        studentScores.put("Ravi", Arrays.asList(88, 91, 90));
        studentScores.put("Teja", Arrays.asList(70, 75, 80));

        // To track highest scorer
        String topScorer = null;
        double highestAverage = 0.0;

        // Step 2: Process each student
        for (Map.Entry<String, List<Integer>> entry : studentScores.entrySet()) {
            String name = entry.getKey();
            List<Integer> marks = entry.getValue();

            // Calculate average using unboxing
            int sum = 0;
            for (int mark : marks) {  // unboxing from Integer to int
                sum += mark;
            }
            double average = (double) sum / marks.size();

            // Print student details
            System.out.println("Student: " + name);
            System.out.println("Scores: " + marks);
            System.out.println("Average: " + average);
            System.out.println();

            // Find highest scorer
            if (average > highestAverage) {
                highestAverage = average;
                topScorer = name;
            }
        }

        // Step 3: Display top scorer
        System.out.println("Top Scorer: " + topScorer + " with average score of " + highestAverage);
    }
}