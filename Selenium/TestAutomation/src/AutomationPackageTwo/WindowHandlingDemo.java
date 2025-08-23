package AutomationPackageTwo;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowHandlingDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // Open AUT
        driver.get("https://the-internet.herokuapp.com/windows");

        // Store parent window handle
        String parentWindow = driver.getWindowHandle();

        // Task 1: Click on "Click Here" → switch to new tab → print title
        driver.findElement(By.linkText("Click Here")).click();

        // Switch to new window
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        System.out.println("Child Window Title: " + driver.getTitle());

        // Task 2: Close child window → switch back to parent window
        driver.close();  // closes current(child) window
        driver.switchTo().window(parentWindow);

        // Task 3: Verify parent page text is still visible
        WebElement heading = driver.findElement(By.tagName("h3"));
        if (heading.isDisplayed()) {
            System.out.println("Parent Page Text Verified: " + heading.getText());
        } else {
            System.err.println("Parent page text NOT visible!");
        }

        driver.quit();
    }
}

