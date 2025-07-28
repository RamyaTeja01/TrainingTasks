package MultiThreading;

public class MyPrinterThread extends Thread{
	// Override the run() method
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello from Thread!");
            try {
                // Sleep for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle exception
                System.out.println("Thread was interrupted");
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of MyPrinterThread
        MyPrinterThread thread = new MyPrinterThread();

        // Start the thread
        thread.start();
       
    }

}
