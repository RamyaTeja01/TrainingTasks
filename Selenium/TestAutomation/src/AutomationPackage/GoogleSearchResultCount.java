package AutomationPackage;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchResultCount {
    public static void main(String[] args) throws InterruptedException {
        // Create ChromeDriver instance
        WebDriver driver = new ChromeDriver();

        // Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // 1. Open Google
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        // 2. Locate search box and search for "Selenium WebDriver"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");
        searchBox.sendKeys(Keys.RETURN);

        // 3. Wait a moment for results to load (better: use WebDriverWait in real automation)
        Thread.sleep(2000);

        // 4. Locate the element showing results count
        WebElement resultsStats = driver.findElement(By.id("result-stats"));
        System.out.println("Search Results: " + resultsStats.getText());

        // 5. Close the browser
        driver.quit();
    }
}
