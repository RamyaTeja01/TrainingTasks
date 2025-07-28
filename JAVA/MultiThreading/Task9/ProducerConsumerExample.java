package MultiThreading;

class Buffer { 
    private int data; 
    private boolean available = false; 
 
    synchronized void produce(int value) { 
        while(available) { 
            try { wait(); } catch (InterruptedException e) {} 
        } 
        data = value; 
        System.out.println("Produced: " + data); 
        available = true; 
        notify(); 
    } 
 
    synchronized void consume() { 
        while(!available) { 
            try { wait(); } catch (InterruptedException e) {} 
        } 
        System.out.println("Consumed: " + data); 
        available = false; 
        notify(); 
    } 
} 
 
public class ProducerConsumerExample { 
    public static void main(String[] args) { 
        Buffer b = new Buffer(); 
 
        Thread producer = new Thread(() -> { 
            for(int i = 1; i <= 5; i++) b.produce(i); 
        }); 
 
        Thread consumer = new Thread(() -> { 
            for(int i = 1; i <= 5; i++) b.consume(); 
        }); 
 
        producer.start(); consumer.start(); 
    } 
} 
