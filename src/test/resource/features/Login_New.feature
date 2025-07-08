Feature: Login Page Functionality
	

Scenario: Login with valid credentials
	
Given I on the login page
When I enter valid "username" and "password" into email and password fields
And  I click on login button
Then I should be redirected to swaglab page
	
	
Scenario: Login with invalid credentials
	 
Given I on the login page
When I enter invalid "username" and "password" into email and password fields
And I click on login button
Then I should be see error message "errorMessage"

Scenario: Click on logi button without entering username and password
	 
Given I on the login page
When I dont enter "username" and "password" into email and password fields
And I click on login button
Then I should be see error message1 "errorMessage"