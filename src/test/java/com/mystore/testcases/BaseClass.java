package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import org.apache.logging.log4j.*;  //Log4J Package imported

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig=new ReadConfig();
	
	String url=readConfig.getBaseUrl();
	
	String browser=readConfig.getBrowser();
	
	String email=readConfig.getEmail();
	
	public static WebDriver driver;

	
	//for logging log4j object created 
	public static final Logger log=LogManager.getLogger("MyStoreV1");
	
	@BeforeClass
	public void setup()
	{		
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();			
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();			
			break;
			default:
				driver=null;
				break;				
			
		}
		
		//implicit wait for 10 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		
		

		//Open url
		driver.get(url);		
		log.info("url opened");
		
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
		driver.quit();
		
	}
	
	
	public void CaptureScreenShots(WebDriver driver, String testName) throws IOException 
		
		{	
		
//***********************Capture Full Page Screenshot***********************************
			
//STEP-1: Convert WebDriver object to TakesScreenshot interface
			
			TakesScreenshot screenShot= ((TakesScreenshot) driver);
			
//STEP-2: Call getScreenshotAs method to create a image file 
			
			File scr=screenShot.getScreenshotAs(OutputType.FILE);
			
			File dest=new File( System.getProperty("user.dir")+"//Screenshots//"+testName+".png");
			
//STEP-3: Copy image file to destination
			
			FileUtils.copyFile(scr, dest);
			
			
		}
			
}
	


