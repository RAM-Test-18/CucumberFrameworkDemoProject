package com.swagLab.Qa.PageObjects;

import org.openqa.selenium.By;

import com.swagLab.Qa.BasePack.BaseClass;

public class CartPage extends BaseClass{

	
	public static By addToCartButton_First = By.cssSelector("#inventory_container > div > div:nth-child(1) > div.pricebar > button");
	
	
	public static By addToCartButton_Second = By.cssSelector("#inventory_container > div > div:nth-child(2) > div.pricebar > button");
	
	public static By numberItemsInShoppingCart = By.cssSelector("#shopping_cart_container > a > span");
	
	public static By removeItemFromCart_First = By.cssSelector("#cart_contents_container>div>div:nth-child(1)>div:nth-child(3)>div.cart_item_label>div.item_pricebar>button");
	
	public static By removeItemFromCart_Second = By.cssSelector("#cart_contents_container>div>div:nth-child(1)>div:nth-child(4)>div.cart_item_label>div.item_pricebar>button");
	
	public static By continueShoppingButton = By.cssSelector("a[class='btn_secondary']");
	
	public static By menuIcon = By.cssSelector("#page_wrapper>div#menu_button_container>div>div:nth-child(3)>div>button");
	
	public static By logoutButton = By.cssSelector("#logout_sidebar_link");
	
	
	
	
	
	
}
