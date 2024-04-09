package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import baseFactory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CabHomePage;
import pageObjects.Carpage;
import pageObjects.HomePage;

public class OutstationCabStepDef {
	
	WebDriver driver;
	HomePage hp = new HomePage(BaseClass.getDriver());
	Carpage cp = new Carpage(BaseClass.getDriver());
	CabHomePage cb = new CabHomePage(BaseClass.getDriver());
	
	@Given("user on the homepage")
	public void user_on_the_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		boolean ad = hp.Adverse();
		BaseClass.getLogger().info(ad?"Ad bypassed...":"Ad not displayed...Moving forward...");
		Assert.assertTrue(hp.verifyHomePage());
//	    throw new io.cucumber.java.PendingException();
	}

	@Given("user on the Cabs tab")
	public void user_on_the_cabs_tab() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Navigating to Cabs Page...");
		hp.navigateCabs();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user fill in {string} and {string} location")
	public void user_fill_in_from_and_to_location(String from, String to) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Filling in from and to locations- "+from+" : " +to+" ...");
		cb.selectfromcity(from);
		cb.selecttocity(to);
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user fill in {int} and {int}:{int}:{string} details")
	public void user_fill_in_and_details(Integer departure, Integer hour, Integer min, String mer) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Selecting departure - "+departure+" and time - "+hour+":"+min+":"+mer+" details...");
		cb.selectdate(departure.toString());
		cb.selectTime(hour.toString(), min.toString(), mer);
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks Search button")
	public void user_clicks_search_button() {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Clicking Search...");
		cb.clickSearch();
//	    throw new io.cucumber.java.PendingException();
	}

	@When("user selects {string} option")
	public void user_selects_filter_option(String filter) {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Selecting filter - "+filter+"...");
		cp.selectCabType(filter);
//	    throw new io.cucumber.java.PendingException();
	}

	@Then("capture the top result")
	public void capture_the_top_result() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		BaseClass.getLogger().info("Capturing cab details with lowest charges...");
		cp.captureCarWithLowestCharge();
//		cp.navigateHomePage();
//	    throw new io.cucumber.java.PendingException();
	}
}
