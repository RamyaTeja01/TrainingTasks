package MultiThreading;

public class RunnableCounter implements Runnable{
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
            try {
                // Add a small delay to see the output clearly
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }

    public static void main(String[] args) {
        // Create an object of RunnableCounter
        RunnableCounter counter = new RunnableCounter();

        // Wrap it in a Thread and start it
        Thread thread = new Thread(counter);
        thread.start();
    }

}
