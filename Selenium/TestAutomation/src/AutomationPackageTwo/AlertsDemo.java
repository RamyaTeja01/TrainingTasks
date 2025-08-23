package AutomationPackageTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class AlertsDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://www.tutorialspoint.com/selenium/practice/alerts.php");

        // Task 1: JS Alert
        driver.findElement(By.xpath("//button[text()='Alert' and contains(@onclick,'showAlert()')]")).click();
        Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("JS Alert says: " + alert1.getText());
        alert1.accept();

        // Task 2: JS Confirm (Confirm box)
        driver.findElement(By.xpath("//button[text()='Click Me' and contains(@onclick,'myDesk()')]")).click();
        Alert alert2 = wait.until(ExpectedConditions.alertIsPresent());
        alert2.accept();
        String resultConfirm = driver.findElement(By.id("desk")).getText();
        if (resultConfirm.toLowerCase().contains("ok")) {
            System.out.println("Confirm result OK: " + resultConfirm);
        } else {
            System.err.println("Unexpected confirm result: " + resultConfirm);
        }

        // Task 3: JS Prompt (Prompt box)
        driver.findElement(By.xpath("//button[text()='Click Me' and contains(@onclick,'myPromp')]")).click();
        Alert alert3 = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Prompt says: " + alert3.getText());
        String name = "Ramya";  // replace with your name
        alert3.sendKeys(name);
        alert3.accept();
     // TutorialsPoint doesn't display the entered name, so we just log
        System.out.println("Prompt accepted with name: " + name);
//        String resultPrompt = driver.findElement(By.id("demo2")).getText();
//        if (resultPrompt.contains(name)) {
//            System.out.println("Prompt result OK: " + resultPrompt);
//        } else {
//            System.err.println("Unexpected prompt result: " + resultPrompt);
//        }

        driver.quit();
    }
}

