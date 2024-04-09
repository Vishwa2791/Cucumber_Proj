package pageObjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseFactory.BaseClass;
import utilities.WriteData;

public class HolidaypackagePage extends BasePage {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(id = "modalpopup")
	WebElement divPopup;
	
	@FindBy(xpath = "//h1[normalize-space()='Italy Packages']")
	WebElement lbl_Pack_Name ;
	
	@FindBy(xpath="//span[@class = 'close closeIcon']")
	WebElement closeIcon;
	
	@FindBy(xpath="//span[text()='All Packages']")
	WebElement btnAllpackages;
	
	@FindBy(xpath="//div[@class = 'titleWrapper']/p")
	List<WebElement> txt_title;
	
	@FindBy(xpath="//span[@class = 'priceStyle']")
	List<WebElement> txt_price;
	
	public HolidaypackagePage(WebDriver driver) {
		super(driver);
	}	
	
	public Boolean verify_Page_Title() throws InterruptedException {
		Thread.sleep(2500);
		if(lbl_Pack_Name.isDisplayed()) {
			return true ;
		}
		return false;
	}
	public void popup() throws InterruptedException {
		Thread.sleep(10000);
//		wait.until(ExpectedConditions.presenceOfElementLocated ((By)divPopup));
		if (closeIcon.isDisplayed()) {
//			System.out.println("click closeIcon button");
			js = (JavascriptExecutor) driver ;
			js.executeScript("arguments[0].click();", closeIcon);
		}
	}
	
	public void exploreItalypackages() {
//		btnAllpackages.click();
		js = (JavascriptExecutor) driver ;
	    js.executeScript("arguments[0].click();", btnAllpackages);
	}
	
	public void scrollPackages() throws InterruptedException {
		Long lastHeight = (Long) js.executeScript("return document.body.scrollHeight");
		js = (JavascriptExecutor) driver ;
		while (true) {
		    // Scroll to bottom of page
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
 
		    // Wait for new content to load
		    Thread.sleep(10000);  // Adjust time as needed
 
		    // Get the new height of the page
		    Long newHeight = (Long) js.executeScript("return document.body.scrollHeight");
		    // If the new height equals the last height, break the loop
		    if (newHeight.equals(lastHeight)) {
		        break;
		    }
		    
		    // Update lastHeight with newHeight for the next iteration
		    lastHeight = newHeight;
		}
	}
	
	public void selectallpackages() throws IOException {
		BaseClass.printHolidayPackages(txt_title, txt_price);
		WriteData.writeTestNG(txt_title, txt_price, "Holiday Packages");
	}
	
	public void navigateHomePage() {
		driver.close();
		windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(0));
	}
}


