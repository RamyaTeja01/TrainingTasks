

package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataDrivenDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Workbook  wb = null;
        
        try {
			FileInputStream file = new FileInputStream(new File("TestData.xlsx"));
			wb = new XSSFWorkbook(file);
			Sheet sheet = wb.getSheetAt(0);
			
			for(int i = 1; i<= sheet.getLastRowNum();i++) {
				Row row = sheet.getRow(i);
				String username = row.getCell(0).getStringCellValue();
				String password = row.getCell(1).getStringCellValue();
				
				System.out.println("Username : "+username + " Password : " + password);
		        driver.get("https://www.demoblaze.com/index.html");
		        driver.findElement(By.id("signin2")).click();
		        
		     // Wait for modal username field to be visible
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
		        
		        driver.findElement(By.id("sign-username")).sendKeys(username);
		        driver.findElement(By.id("sign-password")).sendKeys(password);
		        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

		        // Wait until alert is present
		        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		        String alertText = alert.getText();
		        System.out.println("Alert text: " + alertText);
		        
		        
		        if(alertText.contains("Sign up successful.")) {
		        	System.out.println("Register success for : " + username);
		        } else {
		        	System.out.println("Register failed for: " + username);
		        }
		        
		     // Close the alert
		        alert.accept();
		        
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			driver.quit();
			wb.close();
		}

	}

}




