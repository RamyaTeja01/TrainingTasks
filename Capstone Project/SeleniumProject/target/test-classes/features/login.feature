Feature: Login
  As a user
  I want to log into the site
  So that I can access my secure area

  Background:
    Given I am on the login page

  # Uses the-internet.herokuapp.com known test login
  Scenario: Successful login and logout
    When I login with username "ramyateja" and password "RamyaTeja@01"
    Then I should see a welcome "ramyateja" message
    When I logout
    Then I should be back on the login page


  Scenario Outline: Invalid login shows an error message
    When I login with username "<user>" and password "<pass>"
    Then I should see an error message

    Examples:
      | user     | pass                  |
      | wrong    | SuperSecretPassword!  |
      | tomsmith | wrong                 |
      
      
   Scenario: Adding Items to cart and placing order
	When I add item "Samsung galaxy s6" to cart
	When I add item "Nokia lumia 1520" to cart
	Then I move to cart page
	Then check whether item "Samsung galaxy s6" added to the cart or not
	Then check whether item "Nokia lumia 1520" added to the cart or not
	Then delete item "Nokia lumia 1520" from cart
	When I add item "Nexus 6" to cart
	Then I move to cart page
	Then the total should be 1010
	Then I place the order with name "Name", country "Country", city "City", card "123", month "11", year "2025"	
    Then I should see order confirmation details  