package AutomationPackage;

import java.sql.DriverAction;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByLink {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		
		WebElement link = driver.findElement(By.linkText("Return to index"));
		link.click();
		
		driver.quit();

	}

}
