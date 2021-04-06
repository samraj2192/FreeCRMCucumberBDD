package cucumberPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPageSuccessPage {
	private WebDriver driver;
	private By successMessg = By.cssSelector("div#center_column p");
	
	public ContactPageSuccessPage(WebDriver driver) {
		this.driver = driver;
	}
	public String getSuccessMessage() {
		return driver.findElement(successMessg).getText();
	}

}
