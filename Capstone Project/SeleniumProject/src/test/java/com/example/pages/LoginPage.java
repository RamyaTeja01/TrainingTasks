package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.support.DriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
	
    private WebDriver driver;
    
    private By loginButton = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By submitLogin = By.xpath("//button[text()='Log in']");
    private By welcomeUser = By.id("nameofuser");
    private By logoutButton = By.id("logout2");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openLoginPage() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(submitLogin).click();
    }

    public String getWelcomeMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement welcome = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser"))
        );
        return welcome.getText();
    }
    public String getErrorMessage() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        return text;
    }
    public void logout() {
        driver.findElement(logoutButton).click();
    }

    public boolean isLoginButtonDisplayed() {
        return driver.findElement(loginButton).isDisplayed();
    }
}
