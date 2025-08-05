package FileHandling;

import java.io.*; 
public class ExceptionHandling { 
		public static void main(String[] args) { 
			try { 
					BufferedReader reader = new BufferedReader(new 
					FileReader("nofile.txt")); 
					reader.readLine(); 
				} catch (FileNotFoundException e) { 
					System.out.println("File not found. Please check the file name."); 
				} catch (IOException e) { 
					e.printStackTrace(); 
			} 
	} 
} 
