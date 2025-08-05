package FileHandling;

import java.io.*; 
public class MergeFiles { 
	public static void main(String[] args) throws IOException { 
		BufferedWriter bw = new BufferedWriter(new FileWriter("merged.txt")); 
		BufferedReader br1 = new BufferedReader(new FileReader("info1.txt")); 
		BufferedReader br2 = new BufferedReader(new FileReader("info2.txt")); 
		String line; 
		while ((line = br1.readLine()) != null) bw.write(line + "\n"); 
		while ((line = br2.readLine()) != null) bw.write(line + "\n"); 
		br1.close(); br2.close(); bw.close(); 
	} 
}
