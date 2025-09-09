package com.example.steps;

import com.example.pages.*;
import com.example.support.DriverManager;
import io.cucumber.java.en.*;
import org.junit.Assert;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class LoginSteps {

    private final LoginPage loginPage;
    private final HomePage homePage;
    private final CartPage cartPage;
    private final CheckoutPage checkoutPage;
//    private final DriverManager dm;

    public LoginSteps(DriverManager dm) {
        this.loginPage = new LoginPage(dm.driver);
        this.homePage= new HomePage(dm.driver);
        this.cartPage= new CartPage(dm.driver);
        this.checkoutPage= new CheckoutPage(dm.driver);
        }

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        loginPage.openLoginPage();
    }

    @When("I login with username {string} and password {string}")
    public void i_login_with_username_and_password(String username, String password) {
        loginPage.clickLogin();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.submitLogin();
    }

    @Then("I should see a welcome {string} message")
    public void i_should_see_a_welcome_message(String username) {
        String message = loginPage.getWelcomeMessage();
        assertTrue(message.contains("Welcome " + username));
    }
    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        String error = loginPage.getErrorMessage();
        assertTrue(error.contains("User does not exist.") || error.contains("Wrong password."));
    }

    @When("I logout")
    public void i_logout() {
        loginPage.logout();
    }

    @Then("I should be back on the login page")
    public void i_should_be_back_on_the_login_page() {
        assertTrue(loginPage.isLoginButtonDisplayed());
    }

    @When("I add item {string} to cart")
    public void items_adding_to_cart(String item) {
        homePage.goHome();
        homePage.openItem(item);
        homePage.addToCart();
        homePage.goHome();
    }

    @Then("I move to cart page")
    public void move_to_cart_page() {
        homePage.goToCart();
    }

    @Then("check whether item {string} added to the cart or not")
    public void check_item_in_cart(String item) {
        assertTrue(cartPage.isItemInCart(item));
    }

    @Then("delete item {string} from cart")
    public void delete_item_from_cart(String item) {
        cartPage.deleteItem(item);
    }

    @Then("the total should be {int}")
    public void the_total_should_be(Integer expectedTotal) {
        Assert.assertEquals(expectedTotal.intValue(), cartPage.getTotal());
    }

    @Then("I place the order with name {string}, country {string}, city {string}, card {string}, month {string}, year {string}")
    public void i_place_the_order_with_details(String name, String country, String city, String card, String month, String year) {
        cartPage.clickPlaceOrder();
        checkoutPage.fillDetails(name, country, city, card, month, year);
        checkoutPage.purchase();
    }

    @Then("I should see order confirmation details")
    public void i_should_see_order_confirmation_details() {
        String title = checkoutPage.getConfirmationTitle();
        String details = checkoutPage.getConfirmationDetails();

        System.out.println("==== Order Confirmation ====");
        System.out.println("Title: " + title);
        System.out.println("Details:\n" + details);
        System.out.println("============================");

        assertTrue(title.contains("Thank you"));
        assertTrue(details.contains("Id:"));
        checkoutPage.confirmOK();
    }
}
