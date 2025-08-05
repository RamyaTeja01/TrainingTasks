package FileHandling;

import java.io.*; 
public class ReplaceWords { 
	public static void main(String[] args) throws IOException { 
		BufferedReader br = new BufferedReader(new FileReader("info1.txt")); 
		BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt")); 
		String line; 
		while ((line = br.readLine()) != null) 
		bw.write(line.replace("Java", "Python") + "\n"); 
		br.close(); 
		bw.close(); 
	} 
} 
