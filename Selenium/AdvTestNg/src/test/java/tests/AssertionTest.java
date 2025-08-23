package tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
	 @Test
	    public void verifySomething() {
	        System.out.println("Task 10 is running!");
	    }
 WebDriver driver;

 @Test
 public void testTitle() {
     driver = new ChromeDriver();
     driver.get("https://google.com");

     Assert.assertEquals(driver.getTitle(), "Google");
     Assert.assertTrue(driver.findElement(By.name("q")).isDisplayed());

     driver.quit();
 }

}
