package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTest implements ITestListener {
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
    }
}
