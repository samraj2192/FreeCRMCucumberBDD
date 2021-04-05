package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Selenium/cucumberPOM/src/test/resuorces/AppFeatures"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "timeline:test-output-thread/"},
		monochrome = true
		
		)



public class MyTestRunner {

}
