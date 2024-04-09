package testCases;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseFactory.BaseClass;
import utilities.ExtentReportManager;

@Listeners(ExtentReportManager.class)
public class TC_002__HolidayPackage extends BaseClass {
	
	@Test(priority = 1)
	public void navigate_to_HolidayPage() {
		boolean ad = hp.Adverse();
		BaseClass.getLogger().info(ad?"Ad bypassed...":"Ad not displayed...Moving forward...");
		BaseClass.getLogger().info("Clicking on Holiday Package...");
		hp.clickholidaypackage();
	}
	
	@Test(priority = 2)
	public void click_opt_Explore_Europe() {
		BaseClass.getLogger().info("Clicking Explore Europe Category...");
		hhp.clickexplore();
	}
	
	@Test(priority = 3)
	public void click_opt_Italy() {
		BaseClass.getLogger().info("Selecting Italy location...");
		hhp.clickItaly();
	}
	
	@Test(priority = 4)
	public void verifyPage() throws InterruptedException {
		BaseClass.getLogger().info("Verifying Holiday Package Page...");
		hpp.verify_Page_Title();
	}
	
	@Test(priority = 5)
	public void close_Popup_If_Display() throws InterruptedException {
		BaseClass.getLogger().info("Closing the popup that appears...");
		hpp.popup();
	}
	
	@Test(priority = 6)
	public void click_opt_AllPackages() {
		BaseClass.getLogger().info("Choosing All Packages section...");
		hpp.exploreItalypackages();
	}
	
	@Test(priority = 7)
	public void select_all_Packages() throws InterruptedException, IOException {
		BaseClass.getLogger().info("Scrolling down till all packages are loaded..."
				+ "And capturing them...");
		hpp.scrollPackages();
		hpp.selectallpackages();
	}
	
	@Test(priority = 8)
	public void navigate_to_home_Page() {
		BaseClass.getLogger().info("Navigating to HomePage...");
		hpp.navigateHomePage();
	}
}
