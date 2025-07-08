package com.swagLab.Qa.PageObjects;

import org.openqa.selenium.By;

public class LoginPage extends CartPage{
	

	public static By userName = By.id("user-name");
	public static By password = By.id("password");
	public static By loginButton = By.id("login-button");
	
	
    public static By errorMessage = By.cssSelector("#login_button_container > div > form > h3");
	
	

}
