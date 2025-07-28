package JavaFundamentals;

public class DefaultValues {

	byte b;
	short s;
	int i;
	long l;
	double d;
	char c;
	float f;
	boolean flag;
	
	public void printValues()
	{
		System.out.println("byte : "+b);
		System.out.println("char : "+c);
		System.out.println("short : "+s);
		System.out.println("int : "+i);
		System.out.println("long : "+l);
		System.out.println("double : "+d);
		System.out.println("float : "+f);
		System.out.println("boolean : "+flag);
	}
	public static void main(String[] args) 
	{
		DefaultValues obj = new DefaultValues();
		obj.printValues();
	}

}
