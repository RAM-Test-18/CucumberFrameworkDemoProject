package com.swagLab.Qa.Utils;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Input{
	

	public static WebDriver driver ;
	
	public static WebDriverWait wait;
	
	public static String mBrowserName = null;
	
	public static String mainWindow = null;
	
	public static boolean m_Task_Passed = true;
	
	public static boolean m_Task_Failed = false;
	
	public static boolean m_Task_Result = false;
	
	public static int IMPLICIT_WAIT = 180;
	
	public static int PAGELOAD_WAT =300;
	
	public static int LOAD=30;
	
	
	
	
	public static Boolean setBrowser(String browsername) 
	{
		m_Task_Result =m_Task_Failed;
		if(browsername!=null)
		{
			mBrowserName =	browsername;
			m_Task_Result = m_Task_Passed;
		}
		return m_Task_Result;	
	}
	
	public static String TimeStamp() {
		return (new SimpleDateFormat().format(new Date()));
	}
	
	
	public static String randomName() {
		
		Date d = new Date();
		
		return d.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
	
	
	public static Boolean urlNavigation(String baseURL) throws InterruptedException 
	{
		m_Task_Result = m_Task_Passed;
		
		if(mBrowserName.equals("Chrome") || mBrowserName.equalsIgnoreCase("Google Chrome"))
		{
			driver = new ChromeDriver();
			System.out.println(TimeStamp().toString()+ ": Chrome Browser is Selected.");
			m_Task_Result=m_Task_Passed;
		}else if(mBrowserName.equals("Edge") || mBrowserName.equalsIgnoreCase("Microsoft Edge")) 
		{
			driver = new EdgeDriver();
			System.out.println(TimeStamp().toString()+ ": Edge Browser is Selected.");
			m_Task_Result=m_Task_Passed;
	
	   }else if(mBrowserName.equals("Firefox") || mBrowserName.equalsIgnoreCase("Mozilla Firefox"))
	   {
		   driver = new FirefoxDriver();
		   System.out.println(TimeStamp().toString() + " : Firefox Browser is Selected.");
		   m_Task_Result=m_Task_Passed;
	   }else
	   {
		   m_Task_Result = m_Task_Failed; 
	   }
		
		if(m_Task_Result) 
		{
			wait = new WebDriverWait(driver,Duration.ofSeconds(IMPLICIT_WAIT));
			mainWindow = driver.getWindowHandle();
			driver.manage().window().maximize();
			driver.get(baseURL);
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICIT_WAIT));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
			
			do {
				
			}while(!waitForPageToLoad(LOAD).booleanValue());	
		}else 
		{
			System.out.println("Browser Seletion is Failed.");
		}
		
	return m_Task_Result;
	}
	
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	public static void scrollToElement(By scrollElement) 
	{
		if(scrollElement!=null) 
		{
			JavascriptExecutor jse = (JavascriptExecutor)Input.getDriver();
			WebElement scrollEle = Input.getDriver().findElement(scrollElement);
			jse.executeScript("arguments[0].scrollIntoView(true);",scrollEle);
		}

	}
	
	
	public static void textEnter(By textToEnetrElement, String messageToPass) 
	{
		if(textToEnetrElement!=null && messageToPass!=null) 
			driver.findElement(textToEnetrElement).sendKeys(new CharSequence[] {messageToPass});	
	}
	
	public static void clickOn(By clickElement , String typeOfClick)
	{
		if(clickElement!=null && typeOfClick!=null)
		{
			if(typeOfClick.equalsIgnoreCase("click")) 
			{
				driver.findElement(clickElement).click();
			}else if(typeOfClick.equalsIgnoreCase("right click")) 
			{
				Actions actions = new Actions(Input.getDriver());
				WebElement rightClickElement = driver.findElement(clickElement);
				actions.contextClick(rightClickElement).perform();
			}else if(typeOfClick.equalsIgnoreCase("double click")) 
			{
				Actions actions = new Actions(Input.getDriver());
				WebElement doubleClickElement = driver.findElement(clickElement);
				actions.doubleClick(doubleClickElement).build().perform();
			}	
		}
		
	}
	
	public static void mouseHover(By hoverElement) 
	{
		if(hoverElement!=null)
		{
			Actions actions = new Actions(Input.getDriver());
			WebElement hoverEle = driver.findElement(hoverElement);
			actions.moveToElement(hoverEle).perform();
		}
		
	}
	
	
	public static String getElementText(By elementText) 
	{
		String cellData=null;
		if(elementText!=null) 
			cellData = driver.findElement(elementText).getText();
		return cellData;
	}
	
	public static boolean isElementPresent(By element_to_check) {
	    m_Task_Result = m_Task_Passed;
	    if (driver.findElements(element_to_check).isEmpty())
	      m_Task_Result = m_Task_Failed; 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
	    return m_Task_Result;
	  }
	
	public static void visibilityOfElement (By element) {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(IMPLICIT_WAIT));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));	
	}
	
	public static Boolean waitForPageToLoad(int timeInSeconds) throws InterruptedException {
		m_Task_Result = m_Task_Failed;
		JavascriptExecutor js = (JavascriptExecutor)Input.getDriver();
		 String jsCommand = "return document.readyState";
		js.executeScript(jsCommand, new Object[0]).toString().equals("complete");
		m_Task_Result = m_Task_Passed;
		
		for(int i=0;i<timeInSeconds;i++) {
			
			TimeUnit.SECONDS.sleep(3L);
			
			if(js.executeScript(jsCommand, new Object[0]).toString().equals("complete")) {
				break;
			}	
		}
		
		return Boolean.valueOf(m_Task_Result);
		
	}
	

	
	public static void dropDown(By dropdownElement, String optionToSelect) {
		
		
		if(dropdownElement!=null && optionToSelect!=null) 
		{
			Select dropDown = new Select(driver.findElement(dropdownElement));
			dropDown.selectByVisibleText(optionToSelect);
		}	
	}
	
	
	 public static void scrollUp() {
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("window.scrollTo(0, 0)", new Object[0]);
		  }
	
}

