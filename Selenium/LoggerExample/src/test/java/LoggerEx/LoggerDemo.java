package LoggerEx;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.testng.Assert; 
public class LoggerDemo { 
private static final Logger log = LogManager.getLogger(LoggerDemo.class); 
@Test 
public void testLogin() { 
	WebDriver driver = new ChromeDriver();
	log.info("Starting login test"); 
	driver.get("https://example.com"); 
	log.debug("Navigated to application"); 
	log.warn("This is a warning example"); 
	log.error("This is an error example"); 
	Assert.assertTrue(true); 
	log.info("Test completed"); 
	} 
} 
