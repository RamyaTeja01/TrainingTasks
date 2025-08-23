package AutomationPackage;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMEndToEnd {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Step 1: Open OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // Step 2: Login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.className("orangehrm-login-button")).click();

        // Step 3: Navigate to PIM
        driver.findElement(By.xpath("//span[text()='PIM']")).click();

        // Step 4: Add new employee
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();

        String firstName = "Sita";
        String lastName = "Ram";

        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);

        // Upload photo
//        String photoPath = "C:\\Users\\YourUser\\Pictures\\profile.jpg"; // change to your local image path
//        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(photoPath);

        // Save employee
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        // Step 5: Verify employee in list
        driver.findElement(By.xpath("//a[text()=\"Employee List\"]")).click();
        Thread.sleep(2000); // wait for list to load

        List<WebElement> employees = driver.findElements(By.xpath("//div[@role='row']//div[3]")); // third column = first name
        boolean found = false;
        for (WebElement emp : employees) {
            if (emp.getText().equals(firstName)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("✅ Employee added successfully: " + firstName + " " + lastName);
        } else {
            System.out.println("❌ Employee not found in list.");
        }

        // Step 6: Logout
        driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        driver.quit();
    }
}
