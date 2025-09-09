package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
    private WebDriver driver;

    private By name = By.id("name");
    private By country = By.id("country");
    private By city = By.id("city");
    private By card = By.id("card");
    private By month = By.id("month");
    private By year = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private By confirmationPopup = By.cssSelector(".sweet-alert.showSweetAlert.visible");
    private By confirmTitle = By.tagName("h2");
    private By confirmDetails = By.cssSelector("p.lead.text-muted");
    private By okButton = By.xpath("//button[text()='OK']");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillDetails(String n, String c, String ci, String cr, String m, String y) {
        driver.findElement(name).sendKeys(n);
        driver.findElement(country).sendKeys(c);
        driver.findElement(city).sendKeys(ci);
        driver.findElement(card).sendKeys(cr);
        driver.findElement(month).sendKeys(m);
        driver.findElement(year).sendKeys(y);
    }

    public void purchase() {
        driver.findElement(purchaseBtn).click();
    }

    public String getConfirmationTitle() {
        return driver.findElement(confirmationPopup).findElement(confirmTitle).getText();
    }

    public String getConfirmationDetails() {
        return driver.findElement(confirmationPopup).findElement(confirmDetails).getText();
    }

    public void confirmOK() {
        driver.findElement(okButton).click();
    }
}
