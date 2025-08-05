package FileHandling;

import java.io.*; 
public class LineWordCharCount { 
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new FileReader("info1.txt")); 
		int lines = 0, words = 0, chars = 0; 
		String line; 
		while ((line = br.readLine()) != null) { 
			lines++; 
			String[] wordList = line.split("\\s+"); 
			words += wordList.length; 
			chars += line.replace(" ", "").length(); 
		} 
		br.close(); 
		System.out.println("Lines: " + lines); 
		System.out.println("Words: " + words); 
		System.out.println("Characters (no spaces): " + chars); 
	} 
} 
