package FileHandling;

import java.io.*; 
public class CopyFileToFile { 
public static void main(String[] args) { 
try { 
BufferedReader reader = new BufferedReader(new 
FileReader("info1.txt")); 
BufferedWriter writer = new BufferedWriter(new 
FileWriter("copy.txt")); 
String line; 
while ((line = reader.readLine()) != null) 
writer.write(line + "\n"); 
reader.close(); 
writer.close(); 
System.out.println("File copied."); 
} catch (IOException e) { 
e.printStackTrace(); 
} 
} 
} 
