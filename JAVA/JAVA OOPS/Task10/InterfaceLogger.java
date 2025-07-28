package Week1;

interface Logger
{
	default void logInfo()
	{
		System.out.println("Interface is started");
	}
	
	static void logError()
	{
		System.out.println("This is the static method in Interface");
	}
}
public class InterfaceLogger implements Logger{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceLogger log = new InterfaceLogger();
		log.logInfo();
		Logger.logError();
	}

}
