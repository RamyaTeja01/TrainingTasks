package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.Alert;

public class HomePage {
    private WebDriver driver;

    private By homeLink = By.xpath("//a[text()='Home ']");
    private By cartLink = By.id("cartur");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goHome() {
        driver.findElement(homeLink).click();
    }

    public void openItem(String itemName) {
        driver.findElement(By.xpath("//a[text()='" + itemName + "']")).click();
    }

    public void addToCart() {
        driver.findElement(By.linkText("Add to cart")).click();

        // Handle the alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }


    public void goToCart() {
        driver.findElement(cartLink).click();
    }
}
