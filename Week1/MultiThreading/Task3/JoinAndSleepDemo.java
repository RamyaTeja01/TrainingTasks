package MultiThreading;

public class JoinAndSleepDemo extends Thread{
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread1 : " + i);
            try {
                // Sleep for 1/2 second
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread1 was interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        // Create and start Thread1
        JoinAndSleepDemo thread1 = new JoinAndSleepDemo();
        thread1.start();

        try {
            // Main thread waits for thread1 to finish
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        // After thread1 is done
        System.out.println("Main thread done.");
    }

}
