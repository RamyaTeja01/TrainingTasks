package AutomationPackage;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowSwitchingDemo {
    public static void main(String[] args) {
        // Setup ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        // Open the updated test page with a frame
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");

        // Click the link that opens a new window
        driver.findElement(By.xpath("//*[@id=\"a-link-that-opens-a-new-window\"]")).click();

        // Store the original window handle
        String w = driver.getWindowHandle();

        // Get all window handles
        Set<String> windows = driver.getWindowHandles();
        // Switch to each window and print the div text
        for (String s : windows) {
            driver.switchTo().window(s);
            WebElement ele = driver.findElement(By.xpath("/html/body/div"));
            System.out.println(ele.getText());
        }

        // Optional: close the driver
        driver.quit();
    }
}
