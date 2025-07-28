package MultiThreading;

class Counter {
    int count = 0; 
}

class CounterThread extends Thread {
    Counter counter;

    public CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.count++;  
        }
    }
}

public class SharedCounterWithoutSync {
    public static void main(String[] args) {
        Counter c = new Counter();

        CounterThread t1 = new CounterThread(c);
        CounterThread t2 = new CounterThread(c);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }

        System.out.println("Final Counter Value: " + c.count);//Likely less than 2000
    }
}
