package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By totalPrice = By.id("totalp");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isItemInCart(String item) {
        List<WebElement> items = driver.findElements(
            By.xpath("//tbody[@id='tbodyid']//td[text()='" + item + "']")
        );
        return items.size() > 0;
    }

    public void deleteItem(String item) {
        driver.findElement(By.xpath("//tr[td[text()='" + item + "']]//a[text()='Delete']")).click();
    }

    public int getTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement total = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("totalp")));

        // Wait until it’s not empty
        wait.until(driver -> !total.getText().trim().isEmpty());

        return Integer.parseInt(total.getText().trim());
    }


    public void clickPlaceOrder() {
        driver.findElement(placeOrderBtn).click();
    }
}
