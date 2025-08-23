package AutomationPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InputBoxesDemo {
    public static void main(String[] args) {
    	WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://www.w3schools.com/html/html_forms.asp");

        // ===== Task 3: Basic Text Field Entry =====
        WebElement firstName = driver.findElement(By.id("fname"));
        WebElement lastName = driver.findElement(By.id("lname"));

        firstName.clear();
        firstName.sendKeys("John");
        lastName.clear();
        lastName.sendKeys("Doe");

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Validate that the new page contains the entered data
        String pageSource = driver.getPageSource();
        if (pageSource.contains("John") && pageSource.contains("Doe")) {
            System.out.println("✅ Passed: Correct data displayed.");
        } else {
            System.out.println("❌ Failed: Data not found.");
        }

        driver.quit();
    }
}

