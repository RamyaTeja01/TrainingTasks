package AutomationPackage;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTask {
    public static void main(String[] args) {
        
    	WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // === LOGIN ===
        // By NAME for username & password
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");

        // By CLASS NAME for Login button
        driver.findElement(By.className("orangehrm-login-button")).click();

        // === SECTION 9: By ID ===
        // We'll use a dashboard element that has an ID (search input in Admin page)
        driver.findElement(By.xpath("//span[text()='Admin']")).click();
        WebElement searchInputByID = driver.findElement(By.id("app")); // app container has ID
        System.out.println("Found element by ID: " + searchInputByID.getTagName());

        // === SECTION 12: By TAG NAME ===
        // Find all hyperlinks on dashboard
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total hyperlinks: " + links.size());
        for (WebElement link : links) {
            System.out.println(link.getAttribute("href"));
        }

        // === SECTION 13: By XPATH ===
        // Absolute XPath (less recommended, but for practice)
//        driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")).click();
        // Relative XPath
        driver.findElement(By.xpath("//span[text()='Admin']")).click();

        // === SECTION 14: By CSS Selector ===
        // Locate the search box in Admin tab
        WebElement searchBox = driver.findElement(By.cssSelector("input[placeholder='Search']"));
        searchBox.sendKeys("Admin");

        driver.quit();
    }
}

