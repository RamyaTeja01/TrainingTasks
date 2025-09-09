package com.banking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class FindTransactionsTest {

    private WebDriver driver;
    private WebDriverWait wait;
    
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Login
        driver.findElement(By.name("username")).sendKeys("john123");
        driver.findElement(By.name("password")).sendKeys("Password123");
        driver.findElement(By.cssSelector("input.button")).click();

        // Click on "Find Transactions" link in left menu
        driver.findElement(By.linkText("Find Transactions")).click();

        // Enter date
        WebElement dateInput = driver.findElement(By.id("transactionDate"));
        dateInput.clear();                  // clear any placeholder
        dateInput.sendKeys("09-06-2025");   // type the date


        // Click Find by Date button
        driver.findElement(By.id("findByDate")).click();
    }

    @Test
    public void validateTransactionResults() {
        // Wait until results container is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultContainer")));

        // Validate header
        WebElement resultsHeader = driver.findElement(By.xpath("//div[@id='resultContainer']//h1"));
        Assert.assertEquals(resultsHeader.getText(), "Transaction Results", "❌ Transaction results not displayed!");

        // Validate date
        String date = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody/tr/td[1]")).getText();
        Assert.assertEquals(date, "09-06-2025", "❌ Date mismatch!");

        // Validate transaction description
        String description = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody/tr/td[2]")).getText();
        Assert.assertTrue(description.contains("Funds Transfer Received"), "❌ Transaction description mismatch!");

        // Validate credit amount
        String credit = driver.findElement(By.xpath("//table[@id='transactionTable']//tbody/tr/td[4]")).getText();
        Assert.assertEquals(credit, "$100.00", "❌ Credit amount mismatch!");

        System.out.println("✅ Transaction Results validated successfully!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
