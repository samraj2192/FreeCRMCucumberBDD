package cucumberPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1. By locators:
	private By email = By.id("email");
	private By Password = By.id("passwd");
	private By signinButton = By.id("SubmitLogin");
	private By ForgotPasswordLink = By.linkText("Forgot your password?");
	
	//2. constructor of the page
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions: features(behavior) of the page
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean isForwardLinkExist() {
		return driver.findElement(ForgotPasswordLink).isDisplayed();
	}
	
	public void enterUserName(String username) {
		driver.findElement(email).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(Password).sendKeys(pwd);
	}
	
	public void clickSignin() {
		driver.findElement(signinButton).click();
	}
	
	public AccountsPage doLogin(String UN, String Pwd) {
		System.out.println("login with : " + UN + " " + Pwd);
		driver.findElement(email).sendKeys(UN);
		driver.findElement(Password).sendKeys(Pwd);
		driver.findElement(signinButton).click();
		return new AccountsPage(driver);
	}
}
