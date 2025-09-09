package com.banking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class OpenAccountTest extends BaseTest {

    @Test
    public void openNewAccount() {
        // Login
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

        // Navigate to "Open New Account"
        driver.findElement(By.linkText("Open New Account")).click();

        // Select account type and funding account
        new Select(driver.findElement(By.id("type"))).selectByVisibleText("SAVINGS");
        new Select(driver.findElement(By.id("fromAccountId"))).selectByIndex(0);
        driver.findElement(By.cssSelector("input[value='Open New Account']")).click();

        // Wait for result container to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("openAccountResult")));

        // Get header text
        String confirmation = driver.findElement(By.xpath("//div[@id='openAccountResult']/h1")).getText().trim();
        Assert.assertTrue(confirmation.contains("Account Opened"), "❌ Account not opened! Found: " + confirmation);

        // Get new account ID
        String accountId = driver.findElement(By.id("newAccountId")).getText();
        System.out.println("✅ New account created with ID: " + accountId);
    }
}
