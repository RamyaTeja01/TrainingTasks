package Week1;

import Week1.Student;
import Week1.StudentService;

public class StudentMainClass {
    public static void main(String[] args) {
        Student student = new Student(101, "MaheshBabu", "Film Institute");
        StudentService service = new StudentService();

        service.saveStudent(student);
        service.printStudent();
    }
}

