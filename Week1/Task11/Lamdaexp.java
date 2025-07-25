package Week1;

@FunctionalInterface
interface Calculate {
	int operation(int x,int y);
	
}
public class Lamdaexp {
	public static void main(String args[]) {
		Calculate add=(x,y)-> x+y;
		Calculate sub=(x,y)->x-y;
		Calculate mul=(x,y)->x*y;
		Calculate div=(x,y)->x/y;
		
		System.out.println("Addition : "+add.operation(2, 3));
		System.out.println("Subtraction : "+sub.operation(5,2));
		System.out.println("Multiplication : "+mul.operation(5, 8));
		System.out.println("Division : "+div.operation(8, 2));
	}

}
