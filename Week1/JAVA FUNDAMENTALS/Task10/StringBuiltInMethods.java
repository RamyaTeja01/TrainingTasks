package JavaFundamentals;

public class StringBuiltInMethods 
{
	public static void main(String[] args) 
	{
		String s = "String BuiltIn Methods";
		System.out.println("Length of given String : " + s.length());
		System.out.println(s.toUpperCase());
		System.out.println(s.toLowerCase());
		System.out.println(s.substring(5));
		System.out.println("Index of 'g': " + s.indexOf('g'));
	}
}
