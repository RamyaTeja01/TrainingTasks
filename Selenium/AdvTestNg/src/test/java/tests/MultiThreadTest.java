package tests;

import org.testng.annotations.Test;

public class MultiThreadTest {

    @Test(threadPoolSize = 3, invocationCount = 6, timeOut = 1000)
    public void testMultiThread() {
        System.out.println("Thread ID: " + Thread.currentThread().getId());
    }
}
