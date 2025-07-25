package Week1;

import Week1.Student;

public class StudentService {

    private Student student;

    // Save student object
    public void saveStudent(Student student) {
        this.student = student;
    }

    // Print student details
    public void printStudent() {
        if (student != null) {
            System.out.println("Student Details:");
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Branch: " + student.getBranch());
        } else {
            System.out.println("No student saved.");
        }
    }
}
