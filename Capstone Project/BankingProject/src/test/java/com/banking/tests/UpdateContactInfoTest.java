package com.banking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class UpdateContactInfoTest extends BaseTest {

    @Test
    public void updateContactInfo() {
        // Login
        driver.findElement(By.name("username")).sendKeys("john");
        driver.findElement(By.name("password")).sendKeys("demo");
        driver.findElement(By.cssSelector("input[value='Log In']")).click();

        // Navigate to Update Contact Info / Update Profile
        driver.findElement(By.linkText("Update Contact Info")).click();

        // Fill in new contact details
        driver.findElement(By.id("customer.address.street")).clear();
        driver.findElement(By.id("customer.address.street")).sendKeys("123 New Street");

        driver.findElement(By.id("customer.address.city")).clear();
        driver.findElement(By.id("customer.address.city")).sendKeys("New City");

        driver.findElement(By.id("customer.address.state")).clear();
        driver.findElement(By.id("customer.address.state")).sendKeys("New State");

        driver.findElement(By.id("customer.address.zipCode")).clear();
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("123456");

        driver.findElement(By.id("customer.phoneNumber")).clear();
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("9876543210");

        // Click Update Profile
        driver.findElement(By.xpath("//input[@value='Update Profile']")).click();

        // Wait for confirmation message
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String confirmation = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rightPanel .title"))).getText().trim();

        // Assert the update was successful
        Assert.assertEquals(confirmation, "Profile Updated", "❌ Contact info update failed!");
        System.out.println("✅ Contact info updated successfully.");
    }
}
