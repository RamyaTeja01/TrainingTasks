package ExceptionHandling;


interface RemoteControl{
	abstract void turnOn();
	default void batteryStatus() {
		System.out.println("Battery Status--Working");
	}
	static void info() {
		System.out.println("Remote Control Info..");
	}
	
}
class TV implements RemoteControl{
	 public void turnOn() {
	        System.out.println("TV ON.");
	    }
}
interface Printable {
    void print();
}

interface Scannable {
    void scan();
}
class MultifunctionPrinter implements Printable, Scannable {
    public void print() {
        System.out.println("Printing document...");
    }

    public void scan() {
        System.out.println("Scanning document...");
    }
}


public class MultiFunctionPrinterMain {
	public static void main(String[] args) {
		RemoteControl myTv = new TV();
		myTv.turnOn();
		myTv.batteryStatus();
		
		RemoteControl.info();
		
		MultifunctionPrinter mfp = new MultifunctionPrinter();
		mfp.print();
		mfp.scan();
	}

}