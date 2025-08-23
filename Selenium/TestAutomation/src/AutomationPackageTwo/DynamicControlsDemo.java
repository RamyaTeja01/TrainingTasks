package AutomationPackageTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.function.Function;

public class DynamicControlsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // ========== Task 1 ==========
        System.out.println("===== Task 1: Waiting for 'It's gone!' with Thread.sleep() =====");
        WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeBtn.click();
        Thread.sleep(4000); // BAD practice but for demo
        String goneMsg = driver.findElement(By.id("message")).getText();
        System.out.println("Message: " + goneMsg);

        // ========== Task 2 ==========
        System.out.println("\n===== Task 2: Explicit Wait for input enabled =====");
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait waitInput = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputBox = waitInput.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='input-example']/input"))
        );
        System.out.println("✅ Input box enabled: " + inputBox.isEnabled());

        // ========== Task 3 ==========
        System.out.println("\n===== Task 3: Explicit Wait for button clickable =====");
        WebElement disableBtn = driver.findElement(By.xpath("//button[text()='Disable']"));
        disableBtn.click();
        WebDriverWait waitButton = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitButton.until(ExpectedConditions.elementToBeClickable(disableBtn));
        String disableMsg = driver.findElement(By.id("message")).getText();
        System.out.println("Message after disable: " + disableMsg);

        // ========== Task 4 ==========
        System.out.println("\n===== Task 4: Fluent Wait for message =====");

        // Handle Add/Remove toggle safely
        WebElement toggleBtn;
        try {
            toggleBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
        } catch (NoSuchElementException e) {
            toggleBtn = driver.findElement(By.xpath("//button[text()='Add']"));
        }
        toggleBtn.click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        WebElement messageElement = fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver d) {
                WebElement msg = d.findElement(By.id("message"));
                return msg.isDisplayed() ? msg : null;
            }
        });

        System.out.println("Fluent Wait message: " + messageElement.getText());

        driver.quit();
    }
}
