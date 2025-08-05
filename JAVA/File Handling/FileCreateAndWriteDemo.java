package FileHandling;

import java.io.FileWriter;
import java.io.IOException;

public class FileCreateAndWriteDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("info1.txt");
		fw.write("Java is a poweful language");
		fw.append("Learn java step by step");
		fw.close();
		FileWriter fw1 = new FileWriter("info2.txt");
		fw1.write("Java is a poweful language");
		fw1.append("Learn java step by step");
		fw1.close();
		System.out.println("File written successfully");
	}

}
