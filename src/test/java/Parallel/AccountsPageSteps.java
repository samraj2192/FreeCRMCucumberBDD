package Parallel;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumberPOM.pages.AccountsPage;
import cucumberPOM.pages.LoginPage;
import cucumberPOM.qa.factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage; 
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable Credential) {
		List<Map<String, String>> credList =  Credential.asMaps();
		String Username = credList.get(0).get("username");
		String Password = credList.get(0).get("password");
		DriverFactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginpage.doLogin(Username, Password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountsPage.getAccountsPageTitle();
		System.out.println("title of Page is : " + title);
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable SectioName) {
		List<String> expectedNames =  SectioName.asList();
		System.out.println("Expected " + expectedNames);
		System.out.println("Actual " + accountsPage.getAccountSectionList());
//		for(String Names : accountsPage.getAccountSectionList()) {
//			int i = 0;
//			Assert.assertTrue(expectedNames.get(i).equals(Names));
//			i++;
//		}
		Assert.assertTrue(expectedNames.containsAll(accountsPage.getAccountSectionList()));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
	    Assert.assertTrue(accountsPage.getAccountSectionCount() == expectedCount);
	}

}
