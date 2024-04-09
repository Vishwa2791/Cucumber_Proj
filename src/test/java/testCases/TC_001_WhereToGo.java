package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseFactory.BaseClass;
import utilities.ExtentReportManager;

@Listeners(ExtentReportManager.class)
public class TC_001_WhereToGo extends BaseClass{
	
	@Test(priority = 1)
	public void click_where2Go() throws InterruptedException
	{
		boolean ad = hp.Adverse();
		BaseClass.getLogger().info(ad?"Ad bypassed...":"Ad not displayed...Moving forward...");
		BaseClass.getLogger().info("Navigating to Where2Go page...");
		hp.navigateWhere2Go();
		//Thread.sleep(5000);
	}
	
	@Test(priority = 2)
	public void the_user_navigated_to_where2Go_page() 
	{
		BaseClass.getLogger().info("Verifying Where2Go page...");
		Assert.assertTrue(wh.verifyWhere2GoPage());	
	}
	
	@Test(priority = 3)
	public void click_trekkingHotspots() 
	{
		BaseClass.getLogger().info("Clicking on Trekking Hotspots...");
		wh.clickOptTrekking_Hotspots();
	}
	
	@Test(priority = 4)
	public void the_user_navigated_to_trekDestination() 
	{
		BaseClass.getLogger().info("Verifying Trekking Page...");
		Assert.assertTrue(trek.verifyTrekkingPage());
	}
	
	@Test(priority = 5 , dependsOnMethods = {"the_user_navigated_to_trekDestination"})
	public void selectCity() 
	{
		BaseClass.getLogger().info("Selecting Chennai City...");
		trek.selectCity();
	}
	
	@Test(priority = 6 , dependsOnMethods = {"selectCity"})
	public void set_Travel_Duration() throws InterruptedException 
	{
		BaseClass.getLogger().info("Applying Travel Duration to 6 hours...");
		trek.applyTravelDuration();
	}
	
	@Test(priority = 7 , dependsOnMethods = {"set_Travel_Duration"})
	public void setCity() throws InterruptedException
	{
		BaseClass.getLogger().info("Reentering City Name...");
		trek.enterCityName();
	}
	
	@Test(priority = 8 , dependsOnMethods = {"setCity"})
	public void printPlacePrice() throws InterruptedException, IOException 
	{
		BaseClass.getLogger().info("Capturing Trekking Places...");
		trek.trekingPlaces();	
	}
	
	@Test(priority = 9 , dependsOnMethods = {"the_user_navigated_to_where2Go_page"})
	public void navigateToHomePage()
	{
		BaseClass.getLogger().info("Navigating to HomePage...");
		trek.navigateHomePage();
		
	}
}
