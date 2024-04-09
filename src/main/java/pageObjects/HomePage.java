package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFactory.BaseClass;

public class HomePage extends BasePage {


	public HomePage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));;
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	
	
	@FindBy(xpath = "//iframe[contains(@title,'notification-frame')]")
	WebElement divAdverse;
	
	@FindBy(xpath="//a[@class='close']")
    WebElement btnCloseAd;
	
	@FindBy(xpath="//a[@href='https://www.makemytrip.com/cabs/']")
	WebElement divCabs;
	
//    @FindBy(xpath="//input[@id = 'fromCity']")
//    WebElement fromCity;
    
//	@FindBy(xpath="//span[@class='sr_city blackText']")
//	List<WebElement> lstCity;
	
//	@FindBy(xpath="//label[@for = 'toCity']")
//	WebElement toCity;
	
//	@FindBy(xpath="//*[@for='departure']")
//	WebElement divDeparture;
//	
//	@FindBy(xpath="//*[@class='DayPicker-Day']")
//	List<WebElement> lstDepartureDate;
//	
//	@FindBy(xpath="//*[@for='pickupTime']")
//	WebElement btnTime;
//	
//	@FindBy(xpath="//*[contains(@class,'hrSlotItemParent']")
//	List<WebElement> lstHour;
//	
//	@FindBy(xpath="//*[contains(@class,'minSlotItemParent')]")
//	List<WebElement> lstMin;
//	
//	@FindBy(xpath="//*[contains(@class,'hrSlotItemParent')]")
//	List<WebElement> lstMer;
//	
//	@FindBy(xpath="//*[@class='applyBtnText']")
//	WebElement btnApply;
//	
//	@FindBy(xpath="//a[text()='Search']")
//	WebElement btnSearch;
	
	@FindBy(xpath="//span[text() = 'Holiday Packages']")
	WebElement divHoliday;
	
//	@FindBy(xpath="//span[text() = 'Explore Europe']")
//	WebElement divEurope;
//	
//	@FindBy(xpath="//a[normalize-space()='Italy']")
//	WebElement btnItaly;
	
	@FindBy(xpath="//span[text()='Gift Cards']")
	WebElement btnGiftCards;
	
	@FindBy(xpath="//span[text()='Where2Go']")
	WebElement btnWhere2Go;
	
	public boolean Adverse() {
		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(divAdverse));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(btnCloseAd));
			driver.findElement(By.className("close")).click();
			return true;
		}catch(Exception n) {return false;}
	}
	
	public boolean verifyHomePage() {
		return driver.getTitle().contains("MakeMyTrip");
	}
	
	public void navigateCabs()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		js.executeScript("arguments[0].click();",divCabs);	
	
	}
	
//	public void selectfromcity(String fromcity) {
//		for(WebElement x:lstCity) {
//			if(x.getText().equals(fromcity)) {
//				x.click();
//				break;
//			}
//		}
//	}
//	
//	public void selecttocity(String tocity) {
//		for(WebElement x:lstCity) {
//			if(x.getText().equals(tocity)) {
//				x.click();
//				break;
//			}
//		}
//	}
//	public void selectdate(String departuredate) {
//		for(WebElement x : lstDepartureDate) {
//			if(x.getText().contains(departuredate)) {
//				x.click();
//				break;
//			}
//		}
//	} 
//    public void selectTime(String hour, String min, String mer) {
//		for(WebElement x : lstHour) {
//			if(x.getText().contains(hour)) {
//				x.click();
//				break;
//			}
//		}
//		for(WebElement x : lstMin) {
//			if(x.getText().contains(min)) {
//				x.click();
//				break;
//			}
//		}
//		for(WebElement x : lstMer) {
//			if(x.getText().contains(mer)) {
//				x.click();
//				break;
//			}
//		}
//		btnApply.click();
//    }	
//    
//	public void clickSearch() {
//		btnSearch.click();
//	}	
	
	public void clickholidaypackage() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",divHoliday);
	}
	
//	public void clickexplore() {
//		js = (JavascriptExecutor) driver ;
//		js.executeScript("arguments[0].click();",divEurope);
//	}
//	
//	public void clickItaly() {
//		js = (JavascriptExecutor) driver ;
//		js.executeScript("arguments[0].click();",btnItaly);
//		windows = new ArrayList<>(driver.getWindowHandles());
//		driver.switchTo().window(windows.get(1));
//	}
	
	
	public void navigateGiftCards() {
		btnGiftCards.click();
		windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
	}
	
	public void navigateWhere2Go() {
		//btnWhere2Go.click();
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();",btnWhere2Go );
		windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
	}
}


