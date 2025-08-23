import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestAutomationDemo {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		System.out.println("Starting");
		driver.get("https://www.calculator.net");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.quit();
		System.out.println("Closed Browser....");
		
	}

}
