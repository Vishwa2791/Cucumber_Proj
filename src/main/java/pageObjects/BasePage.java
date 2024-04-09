package pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	public static String amount;
	public static int quants;
	public static boolean rec;
	public static JavascriptExecutor js;
	public Actions act ;
	public static List<String> windows, recipients, recipiStrings;
	public static List<WebElement> recipientsDisplayed, recipientMail;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
}

