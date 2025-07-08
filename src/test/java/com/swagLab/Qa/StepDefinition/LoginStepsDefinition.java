package com.swagLab.Qa.StepDefinition;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.swagLab.Qa.PageObjects.LoginPage;
import com.swagLab.Qa.Utils.Input;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepsDefinition extends LoginPage {
	
	
	@Given("I on the login page")
	public void i_on_the_login_page() throws InterruptedException
	{
		Input.urlNavigation("https://www.saucedemo.com/v1/index.html");
		
	}

	@When("I enter valid \"username\" and \"password\" into email and password fields")
	public void i_enter_valid_username_and_password_into_email_and_password_fields() throws InterruptedException 
	{

		Input.textEnter(userName, "standard_user");
		Input.textEnter(password, "secret_sauce");
		
	}
	@And("I click on login button")
	public void i_click_on_login_button() throws InterruptedException 
	{
	
		Input.clickOn(loginButton, "click");
	}

	@Then("I should be redirected to swaglab page")
	public void I_should_be_redirected_to_swaglab_page() throws InterruptedException 
	{
		Assert.assertEquals(Input.getDriver().getTitle(), "Swag Labs123");
		TimeUnit.SECONDS.sleep(3);
	}


	@When("I enter invalid \"username\" and \"password\" into email and password fields")
	public void i_enter_invalid_username_and_password_into_email_and_password_fields() throws InterruptedException 
	{
	
		Input.textEnter(userName, "standard");
		Input.textEnter(password, "secret");
	}
	
	@Then("I should be see error message \"errorMessage\"")
	public void i_should_be_see_error_message() 
	{
	
		Assert.assertEquals(Input.getElementText(LoginPage.errorMessage), "Epic sadface: Username and password do not match any user in this service");
	}


	@When("I dont enter \"username\" and \"password\" into email and password fields")
	public void I_dont_enter_username_and_password_into_email_and_password_fields() throws InterruptedException 
	{
	
		Input.textEnter(userName,"");
		Input.textEnter(password,"");
	}
	
	
	@Then("I should be see error message1 \"errorMessage\"")
	public void i_should_be_see_error_message1() 
	{
	
		Assert.assertEquals(Input.getElementText(LoginPage.errorMessage), "Epic sadface: Username is required");
	}

	
	
	
	

}
