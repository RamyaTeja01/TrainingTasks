package Collections.AdvancedConcepts;

import java.util.*;

class ComparatorExample {
    String name;
    int marks;

    ComparatorExample(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks;
    }

    public static void main(String[] args) {
        List<ComparatorExample> students = Arrays.asList(
            new ComparatorExample("Bob", 92),
            new ComparatorExample("Alice", 85),
            new ComparatorExample("Charlie", 78)
        );

        students.sort(Comparator.comparing(s -> s.name));
        System.out.println("Sorted by name:");
        for (ComparatorExample s : students) {
            System.out.println(s);
        }
    }
}
