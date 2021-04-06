package cucumberPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {
	
	private WebDriver driver;
	
	private By Sub_Heading = By.cssSelector("div.selector select#id_contact");
	private By email = By.cssSelector("p.form-group input#email");
	private By send_button = By.cssSelector("div.submit button#submitMessage");
	private By message = By.cssSelector("div.form-group textarea#message");
	//private By successMessg = By.cssSelector("div#center_column p");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getContactUsPageTitle() {
		return driver.getTitle();
	}
	
	public void fillContactUsForm(String heading, String mail, String messg) {
		Select select = new Select(driver.findElement(Sub_Heading));
		select.selectByVisibleText(heading);
		driver.findElement(email).sendKeys(mail);
		driver.findElement(message).sendKeys(messg);
	}
	
	public ContactPageSuccessPage clickSend() {
		driver.findElement(send_button).click();
		return new ContactPageSuccessPage(driver);
	}
	
	

}
