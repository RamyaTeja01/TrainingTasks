package AutomationPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FormDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		driver.get("https://www.selenium.dev/selenium/web/formPage.html");
		WebElement email= driver.findElement(By.xpath("//*[@id=\"email\"]"));
		email.sendKeys("alex@gmail.com");
		WebElement age= driver.findElement(By.xpath("//*[@id=\"age\"]"));
		age.sendKeys("20");
		//driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();
		//String response=driver.findElement(By.xpath("//*[@id=\"greeting\"]")).getAccessibleName();
		//System.out.println("Response: "+ response);
		//checkbox
		driver.findElement(By.xpath("//*[@id=\"checky\"]")).click();
		//dropdown /html/body/form[3]/select[11]
		WebElement dd=driver.findElement(By.xpath("/html/body/form[3]/select[1]"));
		Select select= new Select(dd);
		WebElement web_ele=select.getFirstSelectedOption();
		System.out.println("Default Selected: "+web_ele.getText());
		select.selectByValue("one");
		List<WebElement> selectedOption =select.getAllSelectedOptions();
		for(WebElement opt:selectedOption) {
			System.out.println("Selected Option is:"+ opt.getText());
		}
				///html/body/form[3]/select[11]
				//radio button
		WebElement radioBtn= driver.findElement(By.xpath("//*[@id=\"cheese\"]"));
		radioBtn.click();
		boolean result=radioBtn.isSelected();
		System.out.println("Radio is selected: "+result);
	}
}

