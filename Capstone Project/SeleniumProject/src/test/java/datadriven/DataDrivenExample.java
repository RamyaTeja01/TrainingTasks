package datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class DataDrivenExample {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "signupData", parallel = true)
    public Object[][] getData() throws IOException {
        FileInputStream file = new FileInputStream(new File("TestData.xlsx"));
        Workbook wb = new XSSFWorkbook(file);
        Sheet sheet = wb.getSheetAt(0);

        Object[][] data = new Object[sheet.getLastRowNum()][2];

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue();
            data[i - 1][1] = row.getCell(1).getStringCellValue();
        }

        wb.close();
        file.close();
        return data;
    }

    @Test(dataProvider = "signupData")
    public void signupTest(String username, String password) {
        System.out.println("Thread: " + Thread.currentThread().getId() + " | Username: " + username);

        driver.get("https://www.demoblaze.com/index.html");
        driver.findElement(By.id("signin2")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));

        driver.findElement(By.id("sign-username")).sendKeys(username);
        driver.findElement(By.id("sign-password")).sendKeys(password);
        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertText = alert.getText();
        System.out.println("Alert text: " + alertText);

        if (alertText.contains("Sign up successful.")) {
            System.out.println("Register success for : " + username);
        } else {
            System.out.println("Register failed for: " + username);
        }

        alert.accept();
    }
}
