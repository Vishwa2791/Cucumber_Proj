package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StaycationPage extends BasePage{
	
	public StaycationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@FindBy(id="amount")
	WebElement txtAmount;
	
	@FindBy(xpath="//span[text()='E-Mail']")
	WebElement btnEmail;
	
	@FindBy(xpath="//div[@class='calc_wrap']/span[3]")
	WebElement btnQty;
	
	@FindBy(className="switch")
	WebElement sliderSwitch;
	
	@FindBy(xpath = "//input[@name='Recipient 1']")
	WebElement ipRecipient1;
	
	@FindBy(xpath = "//input[@name='Recipient 2']")
	WebElement ipRecipient2;
	
	@FindBy(xpath="//span[@class='push-right']")
	WebElement totalPrice;
	
	@FindBy(className="del-mode-text")
	List<WebElement> lbl_recipient;
	
	@FindBy(xpath="//input[@name='senderName']")
	WebElement txtSenderName;
	
	@FindBy(xpath="//input[@name='senderMobileNo']")
	WebElement txtMobile;
	
	@FindBy(xpath="//input[@name='senderEmailId']")
	WebElement txtEmail;
	
	@FindBy(xpath="//div[@class='form__field__wrap coupon__input']/div/input")
	WebElement txtCoupon;
	
	@FindBy(xpath="//span[text()='Apply']")
	WebElement btnApply;
	
	@FindBy(xpath="//div[@class='codes__wrap']/p")
	WebElement txtPromoError;
	
	@FindBy(xpath="//button[contains(@class,'prime__btn')]")
	WebElement btnBuyNow;
	
	@FindBy(xpath="//p[@class='red-text font11 append-top5']")
	List <WebElement> txtErrorMsgs;
	
	@FindBy(xpath="//span[text()='Payment options']")
	WebElement paymentoptions;
	
	public boolean verifyGiftPage() {
		return driver.getTitle().contains("Gift Cards");
	}
	
	public void enterAmount(String amount) {
		txtAmount.clear();
		BasePage.amount = amount;
		txtAmount.sendKeys(amount);
	}
	
	public void clickEmail() {
		btnEmail.click();
	}
	
	public void selectQuantity(int quants) {
		BasePage.quants = quants;
		for (int i = 1; i < quants; i++) 
			btnQty.click();
	}
	
	public void slideDiffRecipients() {
		sliderSwitch.click();		
	}
	
	public void enterInvalidEmail(String recipient1, String recipient2) {
		recipients = Arrays.asList(recipient1,recipient2);
//		recipients.add(recipient1);
//		recipients.add(recipient2);
		ipRecipient1.sendKeys(recipient1);
		ipRecipient2.sendKeys(recipient2);
	}
	
	public boolean validatePrice() {
		return totalPrice.getText().replaceAll("[,₹]", "").equals(String.valueOf(Integer.parseInt(amount) * quants));
	}
	

	public boolean validateRecipientEmail() {
		recipiStrings = new ArrayList<>();
		lbl_recipient.stream().map(WebElement::getText).forEach(recipiStrings::add);
		return recipients.equals(recipiStrings);
	}
	
	//-------------------------------------------------------------------------------------
	
	public void enterUserName(String name) {
		txtSenderName.sendKeys(name);
	}
	
	public void enterMobile(String mobile) {
		txtMobile.sendKeys(mobile);
	}
	
	public void enterSenderEmail(String email) {
		txtEmail.sendKeys(email);	
	}
	
	public void enterCoupon(String coupon) {
		txtCoupon.sendKeys(coupon);
	}
	
	public void applyCoupon() {
		js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].click();",btnApply );
		
	}
	
	public boolean validateCouponErrormsg() {
		if (txtPromoError.getText().equals("Sorry! Promocode used is not applicable at the moment.")) {
			System.out.println(txtPromoError.getText());
			return true;
		}
		return false;
	}
	
	public void clickBuynow()
	{
		btnBuyNow.click();
	}
	
	public boolean validateEmailErrorMsgs(){
		for (WebElement e : txtErrorMsgs) 
		{
			if (e.getText().equals("Please enter valid email id") || e.getText().equals("Please enter a valid Email id.") || e.getText().equals("Please enter a valid mobile number")) 
			{ 
				rec = true;
				System.out.println(e.getText());
			}
			else {
				rec = false;
				break;
			}
		}
		return rec;
	}
	
	public void clearCoupon() {
		txtCoupon.clear();
	}
	
	public void clickBuyNow() {
		btnBuyNow.click();
	}
	
	public boolean validatePaymentLabel() {
		wait.until(ExpectedConditions.presenceOfElementLocated (By.xpath("//span[text()='Payment options']")));
		return paymentoptions.isDisplayed();
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	public void navigateHomePage() {
		driver.close();
		windows = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(0));
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
