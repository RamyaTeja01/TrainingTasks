package AutomationPackage;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        // Open the alerts page
        driver.get("https://www.selenium.dev/selenium/web/alerts.html");

        // Locate and click the alert button
        WebElement ele = driver.findElement(By.xpath("//*[@id=\"alert\"]"));
        ele.click();

        //Switch to alert
        Alert al = driver.switchTo().alert();

        // Accept the alert
        al.accept();

        // Close browser
        driver.quit();

    }
}
