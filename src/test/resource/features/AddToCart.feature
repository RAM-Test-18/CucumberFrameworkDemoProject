Feature: Add items to cart

Scenario: Addding 2 items to cart

Given I on the login page
When I enter valid "username" and "password" into email and password fields
And I click on login button
Then I should be redirected to homepage
And I click on  addtocart button 2 times
Then I should see 2 items add to shopping cart
And I click on shopping cart icon
And I click on remove button
Then I should see all items removed from shopping cart
And I click on continue shopping button
Then I should logout from application

