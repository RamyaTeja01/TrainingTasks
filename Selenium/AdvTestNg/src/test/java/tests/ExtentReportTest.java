package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExtentReportTest {
    ExtentReports extent;
    ExtentTest test;
    WebDriver driver;

    @BeforeTest
    public void startReport() {
        // Initialize Extent Report
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("report.html");
        extent.attachReporter(spark);

        // Initialize WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void demoReport() {
        test = extent.createTest("Google Test");
        driver.get("https://google.com");
        test.pass("Opened Google successfully");
    }

    @AfterTest
    public void endReport() {
        driver.quit();      // Close browser
        extent.flush();     // Write report to file
    }
}

