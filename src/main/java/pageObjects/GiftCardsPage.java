package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardsPage extends BasePage {
	
	@FindBy(xpath="//label[@for='Occasions']")
	WebElement optOccasions;
	
	@FindBy(xpath="//h3[contains(text(),'Staycation')]")
	WebElement btnStaycation;

	public GiftCardsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickOccasions() {
		optOccasions.click();	
	}
	
	public void clickStaycation() {
		btnStaycation.click();
		
	}

}
