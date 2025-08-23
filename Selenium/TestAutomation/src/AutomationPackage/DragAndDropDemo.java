package AutomationPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropDemo {
    public static void main(String[] args) {
        // Setup ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        // Open the drag-and-drop test page
        driver.get("https://www.selenium.dev/selenium/web/dragAndDropTest.html");

        // Locate source and target elements
        WebElement srcEle = driver.findElement(By.id("test1"));
        WebElement targetEle = driver.findElement(By.id("test3"));

        // Perform drag and drop
        Actions a = new Actions(driver);
        a.dragAndDrop(srcEle, targetEle).build().perform();

        // Optional: Close browser
         driver.quit();
    }
}
