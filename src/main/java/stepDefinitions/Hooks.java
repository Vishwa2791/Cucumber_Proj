package stepDefinitions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import baseFactory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {

	 WebDriver driver;
	 Properties p;
      
	@Before
    public void setup() throws IOException, InterruptedException
    {
    	driver=BaseClass.driverSetup();
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	//BaseClass.login1();//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>uncomment  when login required
//    	driver.manage().window().maximize();
    	
       
    			
	}
		
    
    @After
    public void tearDown(Scenario scenario) {
        		
       driver.quit();
       
    }
    

    @AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {
		  File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
		  scenario.attach(fileContent, "image/png",scenario.getName());
		
	}
   
}
