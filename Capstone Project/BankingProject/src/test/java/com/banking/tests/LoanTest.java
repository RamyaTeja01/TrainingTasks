package com.banking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoanTest extends BaseTest {

    @Test
    public void applyForLoan() {
        // Login
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

        // Navigate to Request Loan page
        driver.findElement(By.linkText("Request Loan")).click();

        // Enter loan details
        driver.findElement(By.id("amount")).sendKeys("5000");
        driver.findElement(By.id("downPayment")).sendKeys("500");

        // Select from account
        new Select(driver.findElement(By.id("fromAccountId"))).selectByIndex(0);

        // Click Apply Now
        driver.findElement(By.xpath("//input[@value='Apply Now']")).click();

        // Wait for the loan result container
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("requestLoanResult")));

        // Validate header
        String header = driver.findElement(By.xpath("//div[@id='requestLoanResult']/h1")).getText().trim();
        Assert.assertEquals(header, "Loan Request Processed", "❌ Loan header incorrect");

        // Get loan status
        String status = driver.findElement(By.id("loanStatus")).getText().trim();

        if (status.equalsIgnoreCase("Approved")) {
            // Approved case
            String loanAccountId = driver.findElement(By.id("newAccountId")).getText().trim();
            Assert.assertFalse(loanAccountId.isEmpty(), "❌ Loan approved but no account ID generated!");
            System.out.println("✅ Loan Approved. New Account ID: " + loanAccountId);
        } else if (status.equalsIgnoreCase("Denied")) {
            // Denied case
            String denialMsg = driver.findElement(By.id("loanRequestDenied")).getText().trim();
            Assert.assertTrue(denialMsg.contains("You do not have sufficient funds"), "❌ Loan denial message not found!");
            System.out.println("✅ Loan Denied. Reason: " + denialMsg);
        } else {
            Assert.fail("❌ Unknown loan status: " + status);
        }
    }
}
