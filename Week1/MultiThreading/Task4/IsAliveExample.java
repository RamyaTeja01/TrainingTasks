package MultiThreading;

class IsAliveTask extends Thread
{
	public void run()
	{
		System.out.println("Thread1 Executing...");
	}
}

class IsAliveTask2 extends Thread
{
	public void run()
	{
		System.out.println("Thread2 Executing...");
	}
}

public class IsAliveExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsAliveTask obj1 = new IsAliveTask ();
		IsAliveTask2 obj2 = new IsAliveTask2();
		
		System.out.println("Before Thread1 start : "+obj1.isAlive());
		System.out.println("Before Thread2 start : "+obj2.isAlive());
		obj1.start();
		obj2.start();
		System.out.println("After Thread1 start : "+obj1.isAlive());
		System.out.println("After Thread2 start : "+obj1.isAlive());
		
		try
		{
			obj1.join();
			obj2.join();
		}
		catch(Exception ex)
		{
			System.out.println("Interupted");
		}
		
		System.out.println("After Join for thread1 : "+obj1.isAlive());
		System.out.println("After join for thread2 : "+obj2.isAlive());
	}

}
