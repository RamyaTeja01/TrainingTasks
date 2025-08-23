package AutomationPackageTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class DynamicLoadingDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        try {
            // Task 1: Click “Start”
            WebElement startBtn = driver.findElement(By.xpath("//div[@id='start']/button[contains(text(),'Start')]"));
            startBtn.click();

            // Explicit wait until text is visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@id='finish']/h4[contains(text(),'Hello World!')]")
            ));

            // Print the text
            System.out.println("✅ Task 1 Passed: Text appeared → " + result.getText());

            // Task 2: Demonstrating XPath with contains()
            WebElement header = driver.findElement(By.xpath("//h3[contains(text(),'Dynamically Loaded Page Elements')]"));
            System.out.println("✅ Task 2 Passed: Header located with contains() → " + header.getText());

        } catch (NoSuchElementException e) {
            // Task 3: Handle NoSuchElementException gracefully
            System.err.println("❌ Element not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("❌ Timeout: Element did not appear within wait time");
        } finally {
            driver.quit();
        }
    }
}
