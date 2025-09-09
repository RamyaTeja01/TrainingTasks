package com.banking.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class RegisterTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    public void testUserRegistration() {
        // Fill the registration form
        driver.findElement(By.id("customer.firstName")).sendKeys("John");
        driver.findElement(By.id("customer.lastName")).sendKeys("Doe");
        driver.findElement(By.id("customer.address.street")).sendKeys("123 Main St");
        driver.findElement(By.id("customer.address.city")).sendKeys("New York");
        driver.findElement(By.id("customer.address.state")).sendKeys("NY");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("10001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1234567890");
        driver.findElement(By.id("customer.ssn")).sendKeys("123-45-6789");

        // Unique username to avoid conflicts
        String username = "john" + System.currentTimeMillis();
        driver.findElement(By.id("customer.username")).sendKeys(username);
        driver.findElement(By.id("customer.password")).sendKeys("Password123");
        driver.findElement(By.id("repeatedPassword")).sendKeys("Password123");

        // Submit form
        driver.findElement(By.cssSelector("input.button[value='Register']")).click();

        // Verify registration success
        WebElement title = driver.findElement(By.cssSelector("h1.title"));
        Assert.assertEquals(title.getText(), "Welcome " + username, "❌ Registration failed!");
        System.out.println("✅ Registration successful for user: " + username);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
