package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseFactory.BaseClass;
import utilities.WriteData;

public class TrekkingPage extends BasePage{

	public TrekkingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(xpath = "//div[@class='fromTextWraper']")
	WebElement optCity;
	
	@FindBy(xpath = "//h5[text()='Chennai']")
	WebElement optChennai;
	
	@FindBy(xpath = "//a[text()='Chennai']")
	WebElement txtChennai;
	
	@FindBy(xpath = "(//*[@role='slider'])[3]")
	WebElement slider ;
	
	@FindBy(xpath = "//input[@placeholder='Enter Your City']")
	WebElement txtCity;
	
	@FindBy(xpath = "//div[@class='suggestion__item']")
	WebElement sugbox_City;
	
	@FindBy(xpath = "//h3[contains(@class,'DestinationCard')]")
	List<WebElement> trekking_Place ;
	
	@FindBy(xpath = "//span[@class='price']")
	List<WebElement> trekking_Price ;
	
	public Boolean verifyTrekkingPage() {
		if(driver.getTitle().contains("Trekking")){
			return true;
		}
		return false;
	}
	
	public void selectCity() {
		optCity.click();
		optChennai.click();
	}
	
	public void applyTravelDuration() throws InterruptedException {
		act = new Actions(driver);
		act.dragAndDropBy(slider , -150 ,0).build().perform();
		Thread.sleep(2500);
	}
	
	public void enterCityName() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(optCity));
		optCity.click();
		txtCity.sendKeys("Chennai");
		Thread.sleep(2000);
		sugbox_City.click();
	}
	
	public void trekingPlaces() throws InterruptedException, IOException {
		//wait.until(ExpectedConditions.presenceOfElementLocated((By)txtChennai));
		Thread.sleep(2500);
		BaseClass.printWhere2Go(trekking_Place, trekking_Price);
		WriteData.writeTestNG(trekking_Place, trekking_Price, "Where2Go");
	}
	
	public void navigateHomePage() {
		driver.close();
		windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(0));
	}
}
