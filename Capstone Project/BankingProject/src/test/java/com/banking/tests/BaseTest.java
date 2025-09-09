package com.banking.tests;

import com.banking.support.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    private DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        driverManager = new DriverManager();
        driver = driverManager.getDriver();
        driver.get("http://parabank.parasoft.com/parabank/index.htm"); // default app URL
    }

    @AfterMethod
    public void tearDown() {
        if (driverManager != null) {
            driverManager.quitDriver();
        }
    }
}
