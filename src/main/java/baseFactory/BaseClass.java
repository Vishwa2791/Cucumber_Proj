package baseFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import baseFactory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObjects.BasePage;
import pageObjects.CabHomePage;
import pageObjects.Carpage;
import pageObjects.GiftCardsPage;
import pageObjects.HolidayHomePage;
import pageObjects.HolidaypackagePage;
import pageObjects.HomePage;
import pageObjects.StaycationPage;
import pageObjects.TrekkingPage;
import pageObjects.Where2GoPage;
//import utilities.ExcelUtility;

//import utilities.WriteData;

public class BaseClass {

		public static WebDriver driver;
	    static Properties p;
	    static Logger logger;
	    public static String browser;
	    
	    public static Where2GoPage wh;
	    public static TrekkingPage trek;
	    public static Carpage car ;
	    public static CabHomePage cab;
	    public static GiftCardsPage gcp ;
	    public static HomePage hp ;
	    public static StaycationPage sc ;
	    public static HolidaypackagePage hpp ;
	    public static HolidayHomePage hhp;
	    public static BasePage bp;
	    @BeforeTest
	 	public static WebDriver driverSetup() throws IOException {
//	 		ChromeOptions co = new ChromeOptions();
//	 		co.addArguments("--guest");
////	 		driver = new ChromeDriver();
//	 		switch(br.toLowerCase()) {
//	 			case "chrome": {
//	 				driver = new ChromeDriver(); 
////	 				ExcelUtility.setCellCount();
//	 				browser = br;
//	 				break;
//	 			}
//	 			case "edge": {
//	 				driver = new EdgeDriver(); 
////	 				ExcelUtility.setCellCount();
//	 				browser = br;
//	 				break;
//	 			}
//	 		}
	 		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
			{
				DesiredCapabilities capabilities = new DesiredCapabilities();
				
				//os
				if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				    capabilities.setPlatform(Platform.WIN11);
				} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				    capabilities.setPlatform(Platform.MAC);
				} else {
				    System.out.println("No matching OS..");
				      }
				//browser
				String br = getProperties().getProperty("browser").toLowerCase();
				switch (br) {
				    case "chrome":
				        capabilities.setBrowserName("chrome");
				        browser = br;
				        break;
				    case "edge":
				        capabilities.setBrowserName("MicrosoftEdge");
				        browser = br;
				        break;
				    default:
				        System.out.println("No matching browser");
				     }
		       
		        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
				
			}
			else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
				{
					String br = getProperties().getProperty("browser").toLowerCase();
					switch(br) 
					{
					case "chrome":
				        driver=new ChromeDriver();
				        browser = br;
				        break;
				    case "edge":
				    	driver=new EdgeDriver();
				    	browser = br;
				        break;
				    default:
				        System.out.println("No matching browser");
				        driver=null;
					}
				}
	 	driver.get(getProperties().getProperty("appUrl"));
	 	driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		
		wh = new Where2GoPage(driver); 
		trek = new TrekkingPage(driver);
		car = new Carpage(driver);
		cab = new CabHomePage(driver);
		gcp = new GiftCardsPage(driver);
		hp = new HomePage(driver);
		hhp = new HolidayHomePage(driver);
		sc = new StaycationPage(driver);
		hpp = new HolidaypackagePage(driver);
		bp = new BasePage(driver);
		BaseClass.getLogger().info("Opening "+browser+" browser...");
		return driver;

	}
	
	public static WebDriver getDriver() {
			return driver;
	}
	@AfterTest
//	@After
	public void tearDown() 
	{
		driver.quit();
	}
	
	public static void login1() throws InterruptedException, IOException {
		 WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(30))
		            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0118")));
		   p=BaseClass.getProperties();
		  String pwd= p.getProperty("password");
		    passwordInput.sendKeys(pwd);

		    Thread.sleep(5000);
		    WebElement bt2=driver.findElement(By.id("idSIButton9"));
	    	JavascriptExecutor js1=(JavascriptExecutor)driver;
	    	js1.executeScript("arguments[0].click();", bt2);
		    

		    Thread.sleep(5000);

		    // Check if the "Back" button is present before clicking
		    WebElement backButton = null;
		    try {
		        backButton = new WebDriverWait(driver, Duration.ofSeconds(10))
		                .until(ExpectedConditions.presenceOfElementLocated(By.id("idBtn_Back")));
		    } catch (Exception e) {
		        System.out.println("Back button not found. Skipping the click.");
		    }

		    if (backButton != null) {
		        backButton.click();
		    }
		    Thread.sleep(10000);
	}
	public static void login() throws InterruptedException, IOException {
	    WebElement usernameInput = new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0116")));
	    p=BaseClass.getProperties();
		  String mail= p.getProperty("email");
		usernameInput.sendKeys(mail);
	    WebElement bt1=driver.findElement(By.id("idSIButton9"));
	    	JavascriptExecutor js=(JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", bt1);
	    

	    WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(20))
	            .until(ExpectedConditions.presenceOfElementLocated(By.id("i0118")));
	   p=BaseClass.getProperties();
	  String pwd= p.getProperty("password");
	    passwordInput.sendKeys(pwd);

	    Thread.sleep(5000);
	    WebElement bt2=driver.findElement(By.id("idSIButton9"));
    	JavascriptExecutor js1=(JavascriptExecutor)driver;
    	js1.executeScript("arguments[0].click();", bt2);
	    

	    Thread.sleep(5000);

	    // Check if the "Back" button is present before clicking
	    WebElement backButton = null;
	    try {
	        backButton = new WebDriverWait(driver, Duration.ofSeconds(10))
	                .until(ExpectedConditions.presenceOfElementLocated(By.id("idBtn_Back")));
	    } catch (Exception e) {
	        System.out.println("Back button not found. Skipping the click.");
	    }

	    if (backButton != null) {
	        backButton.click();
	    }
	}

	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
       		
        p=new Properties();
		p.load(file);
		return p;
	}
	
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}
	
	public String captureScreen(String tname, boolean pass){

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=(pass==true)?System.getProperty("user.dir")+"\\passed_screenshots\\" + tname + "_" + timeStamp + ".jpg":System.getProperty("user.dir")+"\\failed_screenshots\\" + tname + "_" + timeStamp + ".jpg";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	
	public Boolean checkIcon(WebElement ele) {
	    try {
	        return ele.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException | NullPointerException e) {
	        // Handle the exception, log it, or perform any necessary actions
	        return false;
	    }
	}
	
	public static void scrollDown(WebElement ele) {
		 JavascriptExecutor js = (JavascriptExecutor)driver ;
		 js.executeScript("arguments[0].scrollIntoView();", ele);
	 }
	
	public  void printList(List<WebElement> list) throws IOException {
		List<String> ls=new ArrayList<>();
		for(WebElement ele:list) {
			System.out.println(ele.getText());
			ls.add(ele.getText());
		}
//		WriteData data =new WriteData();
//		data.writeData(ls);
		//uncomment to store in excel sheet>>>>>>>>>>>>>>>>>>>>>
	}
	
	public static void printCab(WebElement cabName, WebElement cabPrice) {
		System.out.println(cabName.getText().trim() + "\t--->\t" + cabPrice.getText().trim());
	}
	
	public static void printWhere2Go(List<WebElement> place, List<WebElement> price) {
		System.out.println("\nList of trekking places 6 hours from Chennai:");
		for(int i = 0; i < place.size(); i++) {
			System.out.println(String.format("%-10s", place.get(i).getText().split("\n")[1]) +"\t--->\t" + price.get(i).getText());
		}
	}
	
	public static void printHolidayPackages(List<WebElement> pack, List<WebElement> price) {
		System.out.println("List of packages ---> " + pack.size());
		System.out.println(String.format("%-57s", "\tPackage Name ") + "--->\t" + "Cost /Person");
	    for(int i = 0; i < pack.size(); i++) {
	    	System.out.println(String.format("%-57s", pack.get(i).getText().split("\n")[0]) +"\t--->\t" + price.get(i).getText());
	    }
	}
}
