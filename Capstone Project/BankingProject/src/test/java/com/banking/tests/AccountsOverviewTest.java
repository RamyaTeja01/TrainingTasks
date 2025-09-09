package com.banking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class AccountsOverviewTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // Login
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input.button")).click();

        // Navigate to Accounts Overview
        driver.findElement(By.linkText("Accounts Overview")).click();
    }

    @Test
    public void verifyAccountsOverviewPageLoads() {
        WebElement title = driver.findElement(By.cssSelector("h1.title"));
        Assert.assertEquals(title.getText(), "Accounts Overview", "❌ Accounts Overview page did not load!");
        System.out.println("✅ Accounts Overview page loaded successfully.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
