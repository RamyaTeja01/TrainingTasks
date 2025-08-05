package FileHandling;

import java.io.*; 
public class WordsCountFile { 
	public static void main(String[] args) { 
		int wordCount = 0; 
		try { 
			BufferedReader reader = new BufferedReader(new FileReader("info1.txt")); 
			String line; 
			while ((line = reader.readLine()) != null) { 
				String[] words = line.trim().split("\\s+"); 
				wordCount += words.length; 
			} 
			reader.close(); 
			System.out.println("Total words: " + wordCount); 
			} catch (IOException e) { 
			e.printStackTrace(); 
		} 
	} 
} 
