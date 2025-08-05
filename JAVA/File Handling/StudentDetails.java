package FileHandling;

import java.io.*; 
class Student implements Serializable { 
	String name; 
	int rollNo; 
	int marks; 
	Student(String name, int rollNo, int marks) { 
			this.name = name; 
			this.rollNo = rollNo; 
			this.marks = marks; 
	} 
} 
public class StudentDetails { 
	public static void main(String[] args) throws Exception { 
		Student s = new Student("Rahul", 101, 85); 
		ObjectOutputStream oos = new ObjectOutputStream(new 
		FileOutputStream("student.ser")); 
		oos.writeObject(s); 
		oos.close(); 
		ObjectInputStream ois = new ObjectInputStream(new 
		FileInputStream("student.ser")); 
		Student obj = (Student) ois.readObject(); 
		ois.close(); 
		System.out.println("Deserialized Student:\nName: " + obj.name + ", Roll No: " + obj.rollNo + ", Marks: " + obj.marks); 
	} 
} 

