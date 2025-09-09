package com.banking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FundTransferTest extends BaseTest {

    @Test
    public void transferFundsBetweenAccounts() {
        // Login
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

        // Navigate to Transfer Funds
        driver.findElement(By.linkText("Transfer Funds")).click();

        // Enter amount
        driver.findElement(By.id("amount")).sendKeys("100");

        // Select from and to accounts (use existing values from HTML)
        new Select(driver.findElement(By.id("fromAccountId"))).selectByValue("13788");
        new Select(driver.findElement(By.id("toAccountId"))).selectByValue("13899");

        // Click Transfer
        driver.findElement(By.xpath("//input[@value='Transfer']")).click();

        // Wait for the result container to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("showResult")));

        // Get confirmation header
        String confirmation = driver.findElement(By.xpath("//div[@id='showResult']/h1")).getText().trim();
        System.out.println("Confirmation message: " + confirmation);

        // Assertion
        Assert.assertEquals(confirmation, "Transfer Complete!", "❌ Transfer not successful!");
    }
}
