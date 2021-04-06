package Parallel;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import cucumberPOM.pages.ContactPageSuccessPage;
import cucumberPOM.pages.ContactUsPage;
import cucumberPOM.qa.factory.DriverFactory;
import cucumberPOM.qa.util.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {
	private ContactUsPage contactUs= new ContactUsPage(DriverFactory.getDriver());
	private ContactPageSuccessPage successPage;
	
	@Given("user anvigates to contact us page")
	public void user_anvigates_to_contact_us_page() {
	    DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=contact");
	}

	@When("user fills form with given sheetname {string} and rownumber {int}")
	public void user_fills_form_with_given_sheetname_and_rownumber(String SheetName, Integer RowNumber) throws InvalidFormatException, IOException {
	    ExcelReader exclReader = new ExcelReader();
	    List<Map<String, String>> testdata = exclReader.getData("C:\\Users\\Welcome\\Documents\\automation.xlsx", SheetName);
	    String heading = testdata.get(RowNumber).get("subjectheading");
	    String mail = testdata.get(RowNumber).get("email");
	    String messg = testdata.get(RowNumber).get("message");
	    
	    contactUs.fillContactUsForm(heading, mail, messg);
	}

	@When("user clicks on send button")
	public void user_clicks_on_send_button() {
		successPage = contactUs.clickSend();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}

	@Then("it shows a message {string}")
	public void it_shows_a_message(String ExpectedMessage) {
		Assert.assertEquals(ExpectedMessage, successPage.getSuccessMessage());
	}


}
