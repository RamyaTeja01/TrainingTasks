package AutomationPackageTwo;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.stream.Collectors;

public class WebTableDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");

        // ===== Task 1: Print all rows and columns of table1 =====
        System.out.println("===== Task 1: Print all rows & columns =====");
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col : cols) {
                System.out.print(col.getText() + " | ");
            }
            System.out.println();
        }

        // ===== Task 2: Print email IDs of all users =====
        System.out.println("\n===== Task 2: Emails =====");
        List<WebElement> emails = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[3]"));
        for (WebElement email : emails) {
            System.out.println(email.getText());
        }

        // ===== Task 3: Find and print due amount of user "Smith" =====
        System.out.println("\n===== Task 3: Due amount of Smith =====");
        String smithDue = driver.findElement(By.xpath("//table[@id='table1']//tr[td[contains(text(),'Smith')]]/td[4]")).getText();
        System.out.println("Smith's due: " + smithDue);

        // ===== Task 4: Sort by Last Name and verify order =====
        System.out.println("\n===== Task 4: Verify sorting by Last Name =====");
        // Click on "Last Name" header
        driver.findElement(By.xpath("//table[@id='table1']//span[text()='Last Name']")).click();

        // Fetch all last names
        List<WebElement> lastNameElements = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr/td[1]"));
        List<String> actualOrder = lastNameElements.stream().map(WebElement::getText).collect(Collectors.toList());

        // Copy and sort to compare
        List<String> sortedOrder = new ArrayList<>(actualOrder);
        Collections.sort(sortedOrder);

        if (actualOrder.equals(sortedOrder)) {
            System.out.println("✅ Sorting Verified: Last Names are sorted alphabetically.");
        } else {
            System.out.println("❌ Sorting Failed!");
            System.out.println("Actual: " + actualOrder);
            System.out.println("Expected: " + sortedOrder);
        }

        driver.quit();
    }
}

