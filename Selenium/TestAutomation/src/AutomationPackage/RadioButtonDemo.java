package AutomationPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/radio-button.php");

        // --- Task 1: Select Yes radio button ---
        WebElement yesRadio = driver.findElement(By.xpath("//input[@value='igottwo']"));
        yesRadio.click();
        Thread.sleep(1000);

        if (yesRadio.isSelected()) {
            System.out.println("✅ Yes radio button is selected.");
        } else {
            System.out.println("❌ Yes radio button not selected.");
        }

        // --- Task 2: Switch from Yes-> Impressive ---
        WebElement impressiveRadio = driver.findElement(By.xpath("//input[@value='igotthree']"));

        // Select Male first
        impressiveRadio.click();
        Thread.sleep(1000);
        System.out.println("Impressive selected: " + impressiveRadio.isSelected());

        // Now switch to Yes
        yesRadio.click();
        Thread.sleep(1000);

        System.out.println("Yes selected: " + yesRadio.isSelected());
        System.out.println("Impressive selected after switching: " + impressiveRadio.isSelected());

        if (yesRadio.isSelected() && !impressiveRadio.isSelected()) {
            System.out.println("✅ Switched from Impressive to Yes successfully.");
        } else {
            System.out.println("❌ Switch did not work properly.");
        }

        driver.quit();
    }
}

