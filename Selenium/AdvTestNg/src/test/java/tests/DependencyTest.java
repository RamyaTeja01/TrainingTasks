package tests;

import org.testng.annotations.Test;

public class DependencyTest {

    @Test
    public void startApp() {
        System.out.println("App started");
    }

    @Test(dependsOnMethods = {"startApp"})
    public void login() {
        System.out.println("Logged in");
    }
}
