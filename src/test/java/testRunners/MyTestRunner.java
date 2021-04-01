package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"/Selenium/cucumberPOM/src/test/resuorces/AppFeatures/AccountsPage.feature"},
		glue = {"stepdefinitions", "AppHooks"},
		plugin = {"pretty"},
		monochrome = true
		
		)



public class MyTestRunner {

}
