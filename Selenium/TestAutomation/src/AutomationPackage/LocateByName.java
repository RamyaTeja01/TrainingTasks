package AutomationPackage;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateByName {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		WebElement textBox = driver.findElement(By.name("my-text"));
     	textBox.sendKeys("jdbc");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		String response = textBox.getAttribute("value");
		System.out.println("Response is : "+ response);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.quit();
	}

}
