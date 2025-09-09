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

public class BillPaymentTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");

        // 🔹 Login first (mandatory before Bill Pay)
        driver.findElement(By.name("username")).sendKeys("john");  // replace with valid username
        driver.findElement(By.name("password")).sendKeys("demo"); // replace with valid password
        driver.findElement(By.cssSelector("input.button")).click();

        // Wait for successful login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Bill Pay")));
    }

    @Test
    public void payBill() {
        // Navigate to Bill Pay page
        driver.findElement(By.linkText("Bill Pay")).click();

        // Input Payee Info
        String payeeName = "gbfv";
        String payAmount = "100";

        driver.findElement(By.name("payee.name")).sendKeys(payeeName);
        driver.findElement(By.name("payee.address.street")).sendKeys("123 Main Street");
        driver.findElement(By.name("payee.address.city")).sendKeys("New York");
        driver.findElement(By.name("payee.address.state")).sendKeys("NY");
        driver.findElement(By.name("payee.address.zipCode")).sendKeys("10001");
        driver.findElement(By.name("payee.phoneNumber")).sendKeys("9876543210");

        // Account numbers
        driver.findElement(By.name("payee.accountNumber")).sendKeys("123456");
        driver.findElement(By.name("verifyAccount")).sendKeys("123456");

        // Amount
        driver.findElement(By.name("amount")).sendKeys(payAmount);

        // From Account (choose first one)
        WebElement fromAccountDropdown = driver.findElement(By.name("fromAccountId"));
        fromAccountDropdown.findElement(By.xpath("//option[1]")).click();
        String selectedAccount = fromAccountDropdown.findElement(By.xpath("//option[1]")).getText();

        // Submit Payment
        driver.findElement(By.xpath("//input[@value='Send Payment']")).click();

        // ✅ Assertions on confirmation page
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#billpayResult h1.title")));
        Assert.assertEquals(title.getText().trim(), "Bill Payment Complete", "❌ Payment title mismatch!");

        WebElement confirmedPayee = driver.findElement(By.id("payeeName"));
        Assert.assertEquals(confirmedPayee.getText().trim(), payeeName, "❌ Payee name mismatch!");

        WebElement confirmedAmount = driver.findElement(By.id("amount"));
        Assert.assertTrue(confirmedAmount.getText().contains("$" + payAmount), "❌ Amount mismatch!");

        WebElement confirmedAccount = driver.findElement(By.id("fromAccountId"));
        Assert.assertEquals(confirmedAccount.getText().trim(), selectedAccount, "❌ From account mismatch!");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
