package com.TestRunner;


import org.junit.runner.RunWith;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(
		features = "Feature"
		,glue={"com.AutomationFramework.GherkinImplementaion"},tags= {"@testid2,@testid1"},
		plugin = {"com.AutomationFramework.Report.Report"}
				

		)
public class TestRunner {
	 

}
