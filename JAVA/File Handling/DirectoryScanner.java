package FileHandling;

import java.io.File; 
public class DirectoryScanner { 
	public static void main(String[] args) { 
		File dir = new File("."); 
		File[] files = dir.listFiles(); 
		for (File file : files) { 
		System.out.println((file.isDirectory() ? "DIR " : "FILE") + " - " + file.getName() + " - " + file.length() + " bytes"); 
		} 
	} 
} 
