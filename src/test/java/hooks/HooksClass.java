package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.swagLab.Qa.Utils.Input;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass {
	
	
	@Before
	public void setUp()
	{
		Input.setBrowser("Edge");
	}
	
	@After
	public void tearDown(Scenario scenario) 
	{
		String scenarioName =scenario.getName().replaceAll(" ", "_");
		
		if(scenario.isFailed()) 
		{
			 byte[] screenshotFile = ((TakesScreenshot)Input.getDriver()).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(screenshotFile, "image/png", scenarioName);
			
			
		}
		
		
		
		Input.getDriver().quit();
	}
	
	

}
