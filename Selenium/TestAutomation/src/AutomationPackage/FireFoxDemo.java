package AutomationPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class FireFoxDemo {
	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium_automation\\geckodriver-v0.34.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		try {
			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			WebElement searchBox=driver.findElement(By.name("q"));
			searchBox.sendKeys("cheese!!!");
			searchBox.submit();
			Thread.sleep(5000);
			String pageTitle=driver.getTitle();
			System.out.println("Page title after search :"+pageTitle);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
			
		}
		finally {
			
		}
		
	}

}
