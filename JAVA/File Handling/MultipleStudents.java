package FileHandling;

import java.io.*;
import java.util.*;

class Student4 implements Serializable {
    String name;
    int rollNo;
    int marks;

    Student4(String name, int rollNo, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String toString() {
        return name + " - " + rollNo + " - " + marks;
    }
}

public class MultipleStudents {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 101, 90));
        students.add(new Student("Bob", 102, 85));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("students.ser"));
        oos.writeObject(students);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("students.ser"));
        List<Student> retrieved = (List<Student>) ois.readObject();
        ois.close();

        retrieved.forEach(System.out::println);
    }
}
