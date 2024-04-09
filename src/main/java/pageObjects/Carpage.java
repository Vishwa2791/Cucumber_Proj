package pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import baseFactory.BaseClass;
import utilities.WriteData;

public class Carpage extends BasePage {
	
	public Carpage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@class='checkmarkOuter ']/label")
	List<WebElement> optCabType;
	
	@FindBy(xpath="//span[contains(@class,'font20')]")
	WebElement txtCabName;
	
	@FindBy(xpath="//*[contains(@class,'font28')]")
	WebElement txtCabPrice ;
	

	
	public void selectCabType(String cab) { 
		for(WebElement e : optCabType) {
			if(e.getText().contains(cab)) {
				e.click();
				break;
			}
		}
	}

	public void captureCarWithLowestCharge() throws IOException {
		BaseClass.printCab(txtCabName, txtCabPrice);
		WriteData.writeCucumberCab(txtCabName, txtCabPrice);
	}
	
    public void navigateHomePage() {
    	driver.navigate().back();
    	driver.navigate().back();
    }	
}

		

