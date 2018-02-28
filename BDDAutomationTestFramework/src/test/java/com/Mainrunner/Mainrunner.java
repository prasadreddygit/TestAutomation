package com.Mainrunner;

import cucumber.api.cli.Main;

public class Mainrunner {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Main.main(new String[]{"-g", "com.AutomationFramework.GherkinImplementaion", "Feature/sample.feature"});

        // My stepdefinition is inside java package at cucumber.sample.test
        // My feature file is inside src/test/resources/features/featurefile.feature

      
	}

}
