package AutomationPackageTwo;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ExceptionHandlingDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        // ===== Task 1: Handle NoSuchElementException =====
        try {
            WebElement fakeElement = driver.findElement(By.id("doesNotExist"));
            System.out.println("Element found: " + fakeElement.getText());
        } catch (NoSuchElementException e) {
            System.out.println("❌ NoSuchElementException handled → Element not found!");
        }

        // ===== Task 2: Handle TimeoutException =====
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement invisibleElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("stillNotHere"))
            );
            System.out.println("Element became visible: " + invisibleElement.getText());
        } catch (TimeoutException e) {
            System.out.println("⏰ TimeoutException handled → Element did not appear in time!");
        }

        driver.quit();
    }
}

