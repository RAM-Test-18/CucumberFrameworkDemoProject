package com.swagLab.Qa.TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags="",features= {"src/test/resource/features"},publish =true,glue= {"com.swagLab.Qa.StepDefinition","hooks"},
plugin= {"pretty","html:reports/cucumber_Reports/ExecutionReports.html"})
public class TestRunner extends AbstractTestNGCucumberTests{
	
	
	
	

}
