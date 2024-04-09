package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseFactory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GiftCardsPage;
import pageObjects.HomePage;
import pageObjects.StaycationPage;
import utilities.WriteData;

public class GiftCardPageStepDef {
	WebDriver driver;
	HomePage hp = new HomePage(BaseClass.getDriver());
	GiftCardsPage gp = new GiftCardsPage(BaseClass.getDriver());
	StaycationPage sp = new StaycationPage(BaseClass.getDriver());

	@Given("user navigated to MakeMyTrip page")
	public void user_navigated_to_make_my_trip_page() {
	    // Write code here that turns the phrase above into concrete actions
		boolean ad = hp.Adverse();
		BaseClass.getLogger().info(ad?"Ad bypassed...":"Ad not displayed...Moving forward...");
		Assert.assertTrue(hp.verifyHomePage());
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on GiftCards button")
	public void user_clicks_on_button() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Navigating to GiftCards Page...");
		hp.navigateGiftCards();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user selects Occasions category")
	public void user_selects_category() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Selecting Occasions category...");
		gp.clickOccasions();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on StayCation Gift Card gift card")
	public void user_clicks_on_gift_card() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Navigating to Staycation Giftcard Page...");
		gp.clickStaycation();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("validate page title")
	public void validate_page_title() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Validating GiftCards page...");
		Assert.assertTrue(sp.verifyGiftPage());
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user fills in {int}")
	public void user_fills_in(Integer amount) {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Entering amount - "+amount+" ...");
		sp.enterAmount(amount.toString());
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks Email")
	public void user_clicks_email() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Selecting Email button...");
		sp.clickEmail();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("increases {int}")
	public void increases(Integer quantity) {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Increasing quantity "+quantity+" times...");
		sp.selectQuantity(quantity);
//	    throw new io.cucumber.java.PendingException();
	}

	@When("selects Send to different recipients slider button")
	public void selects_send_to_different_recipients_slider_button() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Selecting Send to different recipients slider button...");
		sp.slideDiffRecipients();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("fills in {string} and {string} details")
	public void fills_in_and_details(String rec1, String rec2) {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Filling in recipient details - "+rec1+" : "+rec2+" ...");
		sp.enterInvalidEmail(rec1, rec2);
//	    throw new io.cucumber.java.PendingException();
	}

	@When("fills in {string} , {string} and {string}")
	public void fills_in_and(String senname, String senno, String senemail) {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Filling in sender details - "+senname+" : " +senno+" : " +senemail+ " ...");
		sp.enterUserName(senname);
		sp.enterMobile(senno);
		sp.enterSenderEmail(senemail);
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("check whether the displayed details are same as input")
	public void check_whether_the_displayed_details_are_same_as_input() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Validating the displayed details...");
		Assert.assertTrue(sp.validatePrice() && sp.validateRecipientEmail());
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user fills in {string}")
	public void user_fills_in(String coupon) {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Filling in coupon - " +coupon+ " ...");
		sp.enterCoupon(coupon);
		sp.applyCoupon();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks the Buy Now button")
	public void user_clicks_the_buy_now_button() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Clicking BuyNow button...");
		sp.clickBuynow();
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("validate the error messages")
	public void capture_the_error_messages() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Validating the error messages...");
		boolean result = sp.validateCouponErrormsg() && sp.validateEmailErrorMsgs();
		Assert.assertTrue(result);
		WriteData.writeCucumberGift(result, false);
//	    throw new io.cucumber.java.PendingException();
	}

//	@Given("user navigated to StayCation GiftCard page")
//	public void user_navigated_to_stay_cation_gift_card_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Then("check if the Payment page is reached")
	public void check_if_the_payment_page_is_reached() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Validating Payment Page...");
		boolean result = sp.validatePaymentLabel();
		Assert.assertTrue(result);
		WriteData.writeCucumberGift(result, true);
//	    throw new io.cucumber.java.PendingException();
	}
	
//	@Then("refresh the page")
//	public void refresh_the_page() {
//		sp.refreshPage();
//	}
}
