package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Where2GoPage extends BasePage {

	public Where2GoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*[text()='Trekking Hotspots']")
	WebElement divTrekSpots ;
	
	public Boolean verifyWhere2GoPage() {
		if(driver.getTitle().contains("Where2Go")) {
			return true ;
		}
		return false ;
	}
	
	public void clickOptTrekking_Hotspots() {
		//js = (JavascriptExecutor) driver ;
		//js.executeScript("arguments[0].click();", divTrekSpots);
		divTrekSpots.click();
	}
}
