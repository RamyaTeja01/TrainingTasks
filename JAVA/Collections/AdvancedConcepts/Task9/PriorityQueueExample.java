package Collections.AdvancedConcepts;

import java.util.*;

class PriorityQueueExample {
    String name;
    int marks;

    PriorityQueueExample(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks;
    }

    public static void main(String[] args) {
        List<PriorityQueueExample> students = Arrays.asList(
            new PriorityQueueExample("Alice", 88),
            new PriorityQueueExample("Bob", 92),
            new PriorityQueueExample("Charlie", 75),
            new PriorityQueueExample("David", 95),
            new PriorityQueueExample("Eve", 89)
        );

        PriorityQueue<PriorityQueueExample> maxHeap = new PriorityQueue<>(
            (a, b) -> b.marks - a.marks
        );
        maxHeap.addAll(students);

        System.out.println("Top 3 scorers:");
        for (int i = 0; i < 3 && !maxHeap.isEmpty(); i++) {
            System.out.println(maxHeap.poll());
        }
    }
}

