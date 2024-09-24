package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;

public class TC_MyAccountPageTest extends BaseClass{

	
	@Test(enabled=false)
	public void VerifyRegistrationAndLogin()
	{
				
		indexPage pg=new indexPage(driver);
		pg.signin();
		log.info("Click on Signin");
		myAccount myAcpg=new myAccount(driver);
		
		myAcpg.enterCreateEmailId("avinash103@gmail.com");
		log.info("Entered email address in create account section");
		myAcpg.clickSubmitCreate();	
		log.info("click on create account section");
		
		
		accountCreationDetails accCreationPg=new accountCreationDetails(driver);
		accCreationPg.selectTitle();
		accCreationPg.enterCustomerFirstName("Avinash");
		accCreationPg.enterCustomerLastName("Pradhan");
		accCreationPg.enterEmail("avinash103@gmail.com");
		accCreationPg.enterPassword("password123");
		accCreationPg.enterDays("29");
		accCreationPg.enterMonths("October ");
		accCreationPg.enterYear("1981");
		
		log.info("Account information entered.");
		
		accCreationPg.clickOnRegister();
		
		log.info("Successfully clicked on register button.");
		
		
		registeredUserAccount regUsr=new registeredUserAccount(driver);
		String ActualUserName=regUsr.getUserName();
		
		Assert.assertEquals("Avinash Pradhan", ActualUserName);
		
		log.info("Registered user verified.");
		
	}	
	
	
	@Test(enabled=true)
	public void verifyLogin()
	{
		log.info("Verify Login test execution started....");
		indexPage pg=new indexPage(driver);
		pg.signin();
		
		log.info("Click on Signin");
		
		myAccount myAcpg=new myAccount(driver);
		myAcpg.enterEmailAddress("avinash103@gmail.com");
		myAcpg.enterEmailPassword("password123");
		
		log.info("Entered Email and password");
		
		myAcpg.signin();
		log.info("Clicked on Signin link.");
		
		registeredUserAccount regUsr=new registeredUserAccount(driver);
		String ActualUserName=regUsr.getUserName();
		
		
		
		if(ActualUserName.equals("Avinash Pradhan1"))
		{
			log.info("Verify Login - Passed.");			
			Assert.assertTrue(true);		
		}
		else
		{
			log.info("Verify Login - Failed.");
			try {
				CaptureScreenShots(driver,"VerifyLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);			
		}
		
		
	}
	
	
	
	
}
