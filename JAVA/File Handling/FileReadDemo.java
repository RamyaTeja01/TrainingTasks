package FileHandling;

import java.io.*; 
public class FileReadDemo { 
	public static void main(String[] args) { 
		try { 
			BufferedReader reader = new BufferedReader(new FileReader("info1.txt")); 
			String line; 
			while ((line = reader.readLine()) != null) 
				System.out.println(line); 
			    reader.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
	} 
} 

