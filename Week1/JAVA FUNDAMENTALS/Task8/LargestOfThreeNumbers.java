package JavaFundamentals;


import java.util.Scanner;

public class LargestOfThreeNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter three numbers : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int result = largest(num1, num2, num3);
		System.out.println("Largest of three given numbers is "+result);
	}
	public static int largest(int num1,int num2,int num3) {
		if(num1>=num2 && num1>=num3)
		{
			return num1;
		}
		else if(num2>=num1 && num2>=num3)
		{
			return num2;
		}
		else
		{
			return num3;
		}

	}

}
