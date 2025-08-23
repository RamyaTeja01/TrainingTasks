package AutomationPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");

        // Locate dropdown
        WebElement countryDropdown = driver.findElement(By.xpath("//select"));

        // Wrap it with Select class
        Select select = new Select(countryDropdown);

        // --------- Task 10: Select by Visible Text ---------
        select.selectByVisibleText("India");
        String selectedCountry = select.getFirstSelectedOption().getText();
        System.out.println("Task 10 - Selected Country: " + selectedCountry);
        if(selectedCountry.equals("India")) {
            System.out.println("✅ Validation Passed: India is selected");
        } else {
            System.out.println("❌ Validation Failed");
        }

        Thread.sleep(2000);

        // --------- Task 11: Select by Index & Value ---------
        // Select 5th option (index starts from 0, so 4 = 5th element)
        select.selectByIndex(4);
        System.out.println("Task 11 - Selected by Index (5th option): " + select.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        // Select by value (USA)
        select.selectByValue("USA");
        System.out.println("Task 11 - Selected by Value (USA): " + select.getFirstSelectedOption().getText());

        Thread.sleep(2000);

        // --------- Task 12: Print All Dropdown Options ---------
        List<WebElement> allOptions = select.getOptions();
        System.out.println("Task 12 - All Country Options:");
        for(WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        System.out.println("✅ Validation: Printed all country names successfully.");

        driver.quit();
    }
}

