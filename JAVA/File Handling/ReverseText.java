package FileHandling;

import java.util.Scanner; 
public class ReverseText { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter text: "); 
		String input = sc.nextLine(); 
		String reversed = new StringBuilder(input).reverse().toString(); 
		System.out.println("Reversed: " + reversed); 
		sc.close(); 
	} 
} 
