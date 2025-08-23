package AutomationPackageTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDropDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));

        Actions actions = new Actions(driver);

        // Task 1: Drag column A → column B
        actions.dragAndDrop(columnA, columnB).perform();
        String headerA = columnA.findElement(By.tagName("header")).getText();
        String headerB = columnB.findElement(By.tagName("header")).getText();

        if (headerA.equals("B") && headerB.equals("A")) {
            System.out.println("✅ Task 1 Passed: Columns swapped!");
        } else {
            System.err.println("❌ Task 1 Failed!");
        }

        // Task 2: Drag column B → column A (reverse)
        actions.dragAndDrop(columnB, columnA).perform();
        headerA = columnA.findElement(By.tagName("header")).getText();
        headerB = columnB.findElement(By.tagName("header")).getText();

        if (headerA.equals("A") && headerB.equals("B")) {
            System.out.println("✅ Task 2 Passed: Columns reversed!");
        } else {
            System.err.println("❌ Task 2 Failed!");
        }

        // Task 3: Use click-hold-move-release sequence
        actions.clickAndHold(columnA)
                .moveToElement(columnB)
                .release()
                .perform();

        headerA = columnA.findElement(By.tagName("header")).getText();
        headerB = columnB.findElement(By.tagName("header")).getText();

        System.out.println("After click-hold-move-release → Column A: " + headerA + " , Column B: " + headerB);

        driver.quit();
    }
}
