package AutomationPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MultiSelectDropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/select-menu.php");

        // ---- Locate input element by same XPath ----
        WebElement dropdownInput = driver.findElement(By.xpath("//input[@id='demo-multiple-select-input']"));

        // Use JS click to avoid ElementClickInterceptedException
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", dropdownInput);

        // Select options
        String[] toSelect = {"Books", "Movies, Music & Games", "Health & Beauty"};
        for (String value : toSelect) {
            WebElement option = driver.findElement(By.xpath("//div[text()='" + value + "']"));
            option.click();
            Thread.sleep(500);
        }

        // Print selected items
        List<WebElement> selected = driver.findElements(By.xpath("//span[@class='mbsc-textfield-tag-text mbsc-ios']"));
        System.out.println("Selected options:");
        for (WebElement s : selected) {
            System.out.println("  - " + s.getText());
        }
        
     // --- Validation ---
        boolean isValid = true;
        for (String value : toSelect) {
            boolean found = selected.stream().anyMatch(opt -> opt.getText().equals(value));
            if (!found) {
                isValid = false;
                System.out.println("❌ Missing in UI: " + value);
            }
        }

        if (isValid) {
            System.out.println("✅ Validation Passed: All expected values are selected correctly.");
        } else {
            System.out.println("❌ Validation Failed: Some expected values are missing.");
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
