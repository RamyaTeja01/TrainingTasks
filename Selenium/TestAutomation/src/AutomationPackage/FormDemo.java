package AutomationPackage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php"); // practice form :contentReference[oaicite:1]{index=1}

        // Fill in basic details
        driver.findElement(By.name("name")).sendKeys("Ramya");
        driver.findElement(By.name("email")).sendKeys("ramya@example.com");

        // Select gender (e.g., Female)
        driver.findElement(By.xpath("//div[label[normalize-space()='Female']]//input[@type='radio']")).click();

        // Mobile number
        driver.findElement(By.id("mobile")).sendKeys("9876543210");

        // Date of Birth
        WebElement dob = driver.findElement(By.id("dob"));
        dob.clear();
        dob.sendKeys("12-12-1995");

        // Subjects
        driver.findElement(By.id("subjects")).sendKeys("Maths");
//        driver.findElement(By.id("subject")).sendKeys(Keys.ENTER);

        // Hobbies (select checkbox)
        driver.findElement(By.xpath("//div[label[normalize-space()='Reading']]//input[@type='checkbox']")).click();

        // Upload picture
        WebElement photoInput = driver.findElement(By.xpath("//input[@id='picture']"));
        photoInput.sendKeys("C:\\Users\\KRT\\OneDrive\\Pictures\\Screenshots\\Screenshot (66).png"); // adjust path

        // Current Address
        driver.findElement(By.xpath("//textarea[@id='picture']")).sendKeys("Hyderabad, India");

        // State selection
        Select stateDropdown = new Select(driver.findElement(By.id("state")));
        stateDropdown.selectByVisibleText("NCR");

        // City selection
        Select cityDropdown = new Select(driver.findElement(By.id("city")));
        cityDropdown.selectByVisibleText("Agra");

        // Submit form
        driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();

        // Validation: check for success notification
        boolean success = driver.getPageSource().contains("Thank you") ||
                         driver.getPageSource().contains("submitted");

        System.out.println("Form submitted successfully? " + success);

        driver.quit();
    }
}
