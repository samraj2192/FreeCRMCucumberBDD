package Parallel;


import org.testng.annotations.DataProvider;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
		features = {"/Selenium/cucumberPOM/src/test/resuorces/Parallel"},
		glue = {"Parallel"},
		plugin = {"pretty",
				  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				  "timeline:test-output-thread/"},
		monochrome = true
		
		)

public class ParallelRun extends AbstractTestNGCucumberTests {
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
