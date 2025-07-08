package com.swagLab.Qa.StepDefinition;

import java.util.concurrent.TimeUnit;

import com.swagLab.Qa.PageObjects.LoginPage;
import com.swagLab.Qa.Utils.Input;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Z_CartStepDefinition extends LoginPage{
	

	

	@Then("I should be redirected to homepage")
	public void i_should_be_redirected_to_homepage() 
	{
		if(Input.getDriver().getTitle().contains("Swag Lab")) 
		{
			System.out.println("Successfully Logged into Application.");
		}else 
		{
			System.out.println("Failed to Log into Application.");
		}
		
	}

	@And("I click on  addtocart button {int} times")
	public void i_click_on_addtocart_button_times(Integer int1) throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(2);
		Input.clickOn(addToCartButton_First, click);
		Input.clickOn(addToCartButton_Second, click);
		TimeUnit.SECONDS.sleep(2);
	}

	@Then("I should see {int} items add to shopping cart")
	public void i_should_see_items_add_to_shopping_cart(Integer int1) throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(2);
		Input.mouseHover(numberItemsInShoppingCart);
		TimeUnit.SECONDS.sleep(2);
		if(Integer.parseInt(Input.getElementText(numberItemsInShoppingCart))==2) 
		{
			System.out.println("2 Items are Added into Cart.");
		} else 
		{
			System.out.println("Failed to add 2 Items to Cart.");
		}
	}

	@And("I click on shopping cart icon")
	public void i_click_on_shopping_cart_icon() throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(2);
		Input.clickOn(numberItemsInShoppingCart, click);
	}

	@And("I click on remove button")
	public void i_click_on_remove_button() throws InterruptedException 
	{
		
		if(Input.isElementPresent(removeItemFromCart_First))
		{
			TimeUnit.SECONDS.sleep(2);
			Input.clickOn(removeItemFromCart_First, click);
			TimeUnit.SECONDS.sleep(2);
			Input.clickOn(removeItemFromCart_Second, click);
			
			
		}else
		{
			System.out.println("No Element is present.");
		}
	}

	@Then("I should see all items removed from shopping cart")
	public void i_should_see_all_items_removed_from_shopping_cart() 
	{
		if(Input.isElementPresent(continueShoppingButton))
		{
			System.out.println("Successfully Removed 2 items from cart.");
			
		}else
		{
			System.out.println("Failed to remove 2 Items to Cart.");
		}
		
	}

	@And("I click on continue shopping button")
	public void i_click_on_continue_shopping_button() throws InterruptedException
	{
		TimeUnit.SECONDS.sleep(2);
		Input.clickOn(continueShoppingButton, click);
	}

	@Then("I should logout from application")
	public void i_should_logout_from_application() throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(2);
		Input.clickOn(menuIcon, click);
		TimeUnit.SECONDS.sleep(2);
		Input.clickOn(logoutButton, click);
		
	}
	
	
	
}
