package pageObjects;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayHomePage extends BasePage {

	
	
	public HolidayHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath="//span[text() = 'Explore Europe']")
	WebElement divEurope;
	
	@FindBy(xpath="//a[normalize-space()='Italy']")
	WebElement btnItaly;

	public void clickexplore() {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();",divEurope);
	}
	
	public void clickItaly() {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();",btnItaly);
		windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
	}
}
