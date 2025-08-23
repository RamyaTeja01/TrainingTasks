package AutomationPackageTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/iframe");

        // Task 1: Switch into iframe and type "Hello Selenium"
        driver.switchTo().frame("mce_0_ifr"); // iframe has id="mce_0_ifr"
        WebElement editor = driver.findElement(By.id("tinymce"));

        // Clear using CTRL + A + DELETE (works for TinyMCE body)
        editor.sendKeys(Keys.CONTROL + "a");
        editor.sendKeys(Keys.DELETE);

        editor.sendKeys("Hello Selenium");
        System.out.println("✅ Task 1 Done: Typed 'Hello Selenium'");

        // Task 2: Clear text and type your full name
        editor.sendKeys(Keys.CONTROL + "a");
        editor.sendKeys(Keys.DELETE);
        editor.sendKeys("Ramya Teja");
        System.out.println("✅ Task 2 Done: Typed full name");

        // Task 3: Switch back to default content and verify page header
        driver.switchTo().defaultContent();
        WebElement header = driver.findElement(By.tagName("h3"));
        if (header.isDisplayed()) {
            System.out.println("✅ Task 3 Passed: Page header is visible → " + header.getText());
        } else {
            System.err.println("❌ Task 3 Failed: Header not visible");
        }

        driver.quit();
    }
}
