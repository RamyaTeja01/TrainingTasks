package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {
    WebDriver driver;

    @Parameters({"url", "browser"})
    @Test
    public void openSite(String url, String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.get(url);
        System.out.println("Opened site: " + url + " on " + browser);
        driver.quit();
    }
}

