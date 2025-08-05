package FileHandling;

import java.io.*;
import java.util.*; 
public class ContactManager { 
	public static void main(String[] args) throws IOException { 
		Scanner sc = new Scanner(System.in); 
		BufferedWriter writer = new BufferedWriter(new 
		FileWriter("contacts.txt", true)); 
		System.out.print("Enter name: "); 
		String name = sc.nextLine(); 
		System.out.print("Enter phone: "); 
		String phone = sc.nextLine(); 
		writer.write(name + " - " + phone + "\n"); 
		writer.close(); 
		System.out.println("All Contacts:"); 
		BufferedReader reader = new BufferedReader(new 
		FileReader("contacts.txt")); 
		String line; 
		while ((line = reader.readLine()) != null) 
		System.out.println(line); 
		reader.close(); 
		sc.close(); 
	} 
}
