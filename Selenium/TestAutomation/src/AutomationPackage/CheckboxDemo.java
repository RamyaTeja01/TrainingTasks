package AutomationPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class CheckboxDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open TutorialsPoint checkbox practice page
        driver.get("https://www.tutorialspoint.com/selenium/practice/check-box.php");
        // Expand Main Level 1
        WebElement mainLevel1Plus = driver.findElement(By.xpath("//li[@id='bs_1']/span[contains(@class,'plus')]"));
        mainLevel1Plus.click();
        

        // Expand Sub Level 1 (if you need Last Level 1-4)
        WebElement subLevel1Plus = driver.findElement(By.xpath("//li[@id='bf_1']/span[contains(@class,'plus')]"));
        subLevel1Plus.click();
        
     // Expand Sub Level 2 (if you need Last Level 5-8)
        WebElement subLevel2Plus = driver.findElement(By.xpath("//li[@id='bf_2']/span[contains(@class,'plus')]"));
        subLevel2Plus.click();
        
        // Task 5: Select "Level 1 checkbox" if not already selected
        WebElement chkLevel1 = driver.findElement(By.xpath("//input[@id='c_io_1']"));
        if (!chkLevel1.isSelected()) {
            chkLevel1.click();
        }
        System.out.println("'Last Level 1' selected? " + chkLevel1.isSelected());
        
        // Task 6: Select multiple checkboxes: 2, 3, and 4
        WebElement lastLevel2 = driver.findElement(By.xpath("//input[@id='c_io_2']"));
        WebElement lastLevel3 = driver.findElement(By.xpath("//input[@id='c_io_3']"));
        WebElement lastLevel4 = driver.findElement(By.xpath("//input[@id='c_io_4']"));
        
        if (!lastLevel2.isSelected()) lastLevel2.click();
        if (!lastLevel3.isSelected()) lastLevel3.click();
        if (!lastLevel4.isSelected()) lastLevel4.click();

        System.out.println("Multiple checkboxes selected? " + (lastLevel2.isSelected() && lastLevel3.isSelected() && lastLevel4.isSelected()));
        
        
        // Expand Main Level 2
        WebElement mainLevel2Plus = driver.findElement(By.xpath("//li[@id='bs_2']/span[contains(@class,'plus')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(mainLevel2Plus).click().perform();
//        mainLevel2Plus.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        
     // Expand Sub Level 3 (if you need Last Level 9-12)
        WebElement subLevel3Plus = driver.findElement(By.xpath("//li[@id='bf_3']/span[contains(@class,'plus')]"));
        actions.moveToElement(subLevel3Plus).click().perform();
//        subLevel3Plus.click();
        
     // Expand Sub Level 4 (if you need Last Level 13-16)
        WebElement subLevel4Plus = driver.findElement(By.xpath("//li[@id='bf_4']/span[contains(@class,'plus')]"));
        actions.moveToElement(subLevel4Plus).click().perform();
//        subLevel4Plus.click();

     // ==== Task 7: Select All Checkboxes ====
        List<WebElement> allCheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (WebElement cb : allCheckboxes) {
            if (!cb.isSelected()) {
            	actions.moveToElement(cb).click().perform();
//                cb.click();
            }
        }

        // Count selected checkboxes properly
        long selectedCount = allCheckboxes.stream()
                .filter(WebElement::isSelected)
                .count();
        System.out.println("Task 7: Selected " + selectedCount + " checkboxes out of " + allCheckboxes.size());

        // Close browser
        driver.quit();
    }
}
