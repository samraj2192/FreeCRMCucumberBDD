package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"FreeCRMCucumberBDD/src/test/resuorces/Parallel"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		monochrome = true
		
		)



public class MyTestRunner {

}
