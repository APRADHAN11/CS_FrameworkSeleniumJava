package com.mystore.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


//com.mystore.utilities.ExtentReportListener
public class ExtentReportListener implements ITestListener{

	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	public static ExtentTest test;


	
	public void configureReport()
	{
		ReadConfig browserName=new ReadConfig();
		String brwsNam=browserName.getBrowser();
		
		
		//Now initializing the two variables
		String timestemps=new SimpleDateFormat("dd-M-yyyy hh.mm.ss").format(new Date());
		String ReportName="MyStoreTestReport-" + timestemps+".html";

		htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//"+ReportName);
		reports=new ExtentReports();
		reports.attachReporter(htmlReporter);
		

		
		// Add System Environment information
		reports.setSystemInfo("Machine", "Test PC-11");
		reports.setSystemInfo("OS", "Window Server 11");
		reports.setSystemInfo("Browser", brwsNam);
		reports.setSystemInfo("User Name", "Avinash");
		
		// Look and Feel of Report
		htmlReporter.config().setDocumentTitle("ExtentReport");
		htmlReporter.config().setReportName("ExtentReportWithListener");
		htmlReporter.config().setTheme(Theme.STANDARD);
		
		

	}





	// Copy Paste Listener classes
	// implement all abstract methods of interface
	//-------------------Class Level--------------------

	//Method-1st Once call at starting of class
	public void onStart(ITestContext Result)	
	{
		
		configureReport();  //-----Calling Configure Report Method
		
		
		System.out.println("OnStart invoked.... ");
	}

	//Method-2nd Once call at ending of class
	public void onFinish(ITestContext Result)
	{
		System.out.println("OnFinish invoked....");
		
		reports.flush(); //-----Calling To write info on Report
	}

	//-------------------Method Level--------------------

	//Method-3rd When any Test Case Method get Passed
	

	public void onTestSuccess(ITestResult Result)
	{
		System.out.println(" Name of the Method onTestSucess: "+Result.getName());	
		test=reports.createTest(Result.getName()); // Name of Pass Method 
		test.log(Status.PASS, MarkupHelper.createLabel("Test Case Pass", ExtentColor.GREEN));
		
		
String ScreenshotPath=System.getProperty("user.dir")+ "//Screenshots//"+ Result.getName() +".png";
		
		File screenshotFile=new File(ScreenshotPath);
		if(screenshotFile.exists())
		{
			test.fail("Captured screenshot below:"+ test.addScreenCaptureFromPath(ScreenshotPath));
		}
	}


//Method-4th When any Test Case get Failed
	public void onTestFailure(ITestResult Result)
	{
		
		System.out.println(" Name of the Method OnFailure : "+Result.getName());
		test=reports.createTest(Result.getName());   //create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the Failed Test case is :"+Result.getName(),ExtentColor.RED));
		
		
		String ScreenshotPath=System.getProperty("user.dir")+ "//Screenshots//"+ Result.getName() +".png";
		
		File screenshotFile=new File(ScreenshotPath);
		if(screenshotFile.exists())
		{
			test.fail("Captured screenshot below:"+ test.addScreenCaptureFromPath(ScreenshotPath));
		}
		
		//Add screen capture from past		
	//	test.addScreenCaptureFromPath(ScreenshotPath);
	}

	
//Method-5th When any Test Case get Skipped
	
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println(" Name of the Method onTestSkipped : "+Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the Skipped Test case is :"+Result.getName(),ExtentColor.YELLOW));
	}


//Method-5th When any Test Case Method get Started
	public void onTestStart(ITestResult Result)
	{
		System.out.println(" Name of the Method on TestStart: "+Result.getName());
	}

	//-------------------Class Level--------------------
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{

	}






}
