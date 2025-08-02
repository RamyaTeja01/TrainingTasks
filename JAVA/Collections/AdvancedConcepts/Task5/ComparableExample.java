package Collections.AdvancedConcepts;

import java.util.*;

class ComparableExample implements Comparable<ComparableExample> {
    String name;
    int marks;

    ComparableExample(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public int compareTo(ComparableExample other) {
        return Integer.compare(this.marks, other.marks);
    }

    public String toString() {
        return name + " - " + marks;
    }

    public static void main(String[] args) {
        List<ComparableExample> students = Arrays.asList(
            new ComparableExample("Alice", 85),
            new ComparableExample("Bob", 92),
            new ComparableExample("Charlie", 78)
        );

        Collections.sort(students);
        System.out.println("Sorted by marks:");
        for (ComparableExample s : students) {
            System.out.println(s);
        }
    }
}