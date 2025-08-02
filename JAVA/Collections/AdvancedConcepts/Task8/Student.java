package Collections.AdvancedConcepts;

import java.util.*;

class Student {
    String id;
    String name;
    int marks;

    Student(String id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + marks;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("S1", "Alice", 85),
            new Student("S2", "Bob", 90),
            new Student("S3", "Charlie", 75)
        );

        Map<String, Student> studentMap = new HashMap<>();
        for (Student s : students) {
            studentMap.put(s.id, s);
        }

        for (Map.Entry<String, Student> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}

