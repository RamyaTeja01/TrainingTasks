package AutomationPackage;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLoginTest {
    public static void main(String[] args) {
        
        // Initialize Chrome WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        try {
            // Open OrangeHRM login page
            driver.get("https://opensource-demo.orangehrmlive.com/");
            driver.manage().window().maximize();
            
            // Enter username
            WebElement username = driver.findElement(By.name("username"));
            username.sendKeys("Admin");
            
            // Enter password
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("admin123");
            
            // Click login button
            WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
            loginBtn.click();
            
            // Wait for page to load and verify title
            String expectedTitle = "OrangeHRM";
            String actualTitle = driver.getTitle();
            
            if (actualTitle.equals(expectedTitle)) {
                System.out.println("✅ Login successful. Title matched: " + actualTitle);
            } else {
                System.out.println("❌ Login failed. Expected: " + expectedTitle + ", but got: " + actualTitle);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser
            driver.quit();
        }
    }
}

