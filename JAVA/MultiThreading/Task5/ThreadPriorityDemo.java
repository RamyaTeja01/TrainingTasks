package MultiThreading;


class PriorityTask extends Thread {
    public void run() {
        System.out.println(getName() + " priority: " + getPriority());
    }
}

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        PriorityTask t1 = new PriorityTask();
        PriorityTask t2 = new PriorityTask();
        PriorityTask t3 = new PriorityTask();

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.setPriority(Thread.MIN_PRIORITY);  
        t2.setPriority(Thread.NORM_PRIORITY); 
        t3.setPriority(Thread.MAX_PRIORITY);   

        t1.start();
        t2.start();
        t3.start();
    }
}
