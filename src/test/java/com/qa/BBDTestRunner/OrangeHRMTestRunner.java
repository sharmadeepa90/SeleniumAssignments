package com.qa.BBDTestRunner;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features= "C:\\Users\\sharmadeep\\eclipse-workspace\\com.qa.devlabs.selenium\\src\\test\\java\\com\\qa\\Features\\OrangeHRM.feature",
		glue="com.qa.StepDefinition",
		dryRun = false,
		strict = true,
		monochrome = true,
		format = {"pretty" , "html:test-output"},

		// {"~@SmokeTest"}
		// {"@SmokeTest"}
		// {"@SmokeTest, @UsabilityTest"} --> either or 
		// {"@SmokeTest", "@UsabilityTest"} --> Anding
		tags= {"@SmokeTest, @RegressionalTest",}
		)


public class OrangeHRMTestRunner {
	

}