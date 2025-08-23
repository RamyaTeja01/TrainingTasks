package tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidersTest {

    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][] {
            {"admin", "admin123"},
            {"user", "user123"}
        };
    }

    @Test(dataProvider = "data")
    public void testLogin(String user, String pass) {
        System.out.println("Testing login with: " + user + " / " + pass);
        // Add your login logic here
    }
}

