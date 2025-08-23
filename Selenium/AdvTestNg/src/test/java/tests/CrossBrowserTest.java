package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	 @Test
	    public void verifySomething() {
	        System.out.println("Task 11 is running!");
	    }
 WebDriver driver;

 @Parameters("browser")
 @BeforeTest
 public void setup(String browser) {
     if (browser.equalsIgnoreCase("chrome")) {
         driver = new ChromeDriver();
     } else if (browser.equalsIgnoreCase("firefox")) {
         driver = new FirefoxDriver();
     }
 }

 @Test
 public void openGoogle() {
     driver.get("https://google.com");
     System.out.println("Browser title is: " + driver.getTitle());
     driver.quit();
 }

}
