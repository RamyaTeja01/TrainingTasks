package AutomationPackageTwo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class DatePickerDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://jqueryui.com/datepicker/");

        // Switch to iframe
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        WebElement dateInput = driver.findElement(By.id("datepicker"));

        // Task 1: Select 15th of current month
        dateInput.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));
        driver.findElement(By.xpath("//a[text()='15']")).click();
        System.out.println("Task 1 -> Selected: " + dateInput.getAttribute("value"));

        // Task 2: Select a date 2 months ahead (same day-of-month)
        dateInput.click(); // reopen calendar
        for (int i = 0; i < 2; i++) {
            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Next']")));
            nextBtn.click();
        }
        driver.findElement(By.xpath("//a[text()='15']")).click(); // pick 15th again
        System.out.println("Task 2 -> Selected: " + dateInput.getAttribute("value"));

        // Task 3: Select today’s date dynamically using LocalDate
        LocalDate today = LocalDate.now();
        String formattedToday = today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        dateInput.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + formattedToday + "';", dateInput);

        System.out.println("Task 3 -> Selected Today: " + dateInput.getAttribute("value"));

        driver.quit();
    }
}
