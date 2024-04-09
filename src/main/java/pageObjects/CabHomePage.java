package pageObjects;
 
import java.time.Duration;
import java.util.List;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class CabHomePage extends BasePage {
	public CabHomePage(WebDriver driver) {
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath="//input[@id = 'fromCity']")
    WebElement fromCity;
	@FindBy(xpath="//span[@class='sr_city blackText']")
	List<WebElement> lstCity;
	@FindBy(xpath="//label[@for = 'toCity']")
	WebElement opt_toCity;
	@FindBy(xpath = "//input[@placeholder='To']")
	WebElement txt_toCity ;
	@FindBy(xpath="//*[@for='departure']")
	WebElement divDeparture;
	@FindBy(xpath="//*[@class='DayPicker-Day']")
	List<WebElement> lstDepartureDate;
	@FindBy(xpath="//*[@for='pickupTime']")
	WebElement btnTime;
	@FindBy(xpath="//*[contains(@class,'hrSlotItemParent')]")
	List<WebElement> lstHour;
	@FindBy(xpath="//*[contains(@class,'minSlotItemParent')]")
	List<WebElement> lstMin;
	@FindBy(xpath="//*[contains(@class,'hrSlotItemParent')]")
	List<WebElement> lstMer;
	@FindBy(xpath="//*[@class='applyBtnText']")
	WebElement btnApply;
	@FindBy(xpath="//a[text()='Search']")
	WebElement btnSearch;
	public Boolean verifyCabPage() {
		if(driver.getTitle().contains("Cab")) {
			return true;
		}
		return false;
	}
	public void selectfromcity(String fromcity) {
		//js = (JavascriptExecutor) driver ;
		//js.executeScript("arguments[0].click();",fromCity);
		//driver.findElement(By.xpath("//input[@id = 'fromCity']")).click();
		fromCity.click();
		for(WebElement x:lstCity) {
			if(x.getText().equalsIgnoreCase(fromcity)) {
				x.click();
				break;
			}
		}
	}
	public void selecttocity(String tocity) throws InterruptedException {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();",opt_toCity);
		Thread.sleep(2000);
		//txt_toCity.sendKeys(tocity);
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(tocity);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'"+tocity+"')]")));
		for(WebElement x:lstCity) {
			if(x.getText().contains(tocity)) {
				x.click();
				break;
			}
		}
	}
	public void selectdate(String departuredate) {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();",divDeparture);
		for(WebElement x : lstDepartureDate) {
			if(x.getText().contains(departuredate)) {
				x.click();
				break;
			}
		}
	} 
    public void selectTime(String hour, String min, String mer) throws InterruptedException
    {
    	Thread.sleep(2000);
    	js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();",btnTime);
		System.out.println("After Clicked");
		Thread.sleep(2000);
		for(WebElement x : lstHour) {
			if(x.getText().contains(hour)) {
				x.click();
				break;
			}
		}
		for(WebElement x : lstMin) {
			if(x.getText().contains(min)) {
				x.click();
				break;
			}
		}
		for(WebElement x : lstMer) {
			if(x.getText().contains(mer)) {
				x.click();
				break;
			}
		}
		btnApply.click();
    }	
	public void clickSearch() {
		btnSearch.click();
	}
}