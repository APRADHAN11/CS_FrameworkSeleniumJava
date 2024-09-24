package com.mystore.testcases;



import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadExcelFile;

import junit.framework.Assert;

public class TC_MyAccountPageTest_DataDrivenTesting extends BaseClass{

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
	

//----------------First Reading Excel file via Data Provider method always return Two Dimensional Object 
	
		@DataProvider(name="LoginDataProvider")
		public String[][] LoginDataProvider()   // Data provider always return two dimensional object type
		{
			
			
			String fileName=System.getProperty("user.dir")+"\\TestData\\MyStoreTestData.xlsx";
			
			int ttlRow= ReadExcelFile.getRowCount(fileName, "LoginTestData");
			int ttlCol= ReadExcelFile.getColCount(fileName, "LoginTestData");
			
			String data[][]= new String[ttlRow-1][ttlCol];
			
			for(int i=1;i<ttlRow;i++)  //rows=1,2
			{
				for(int j=0;j<ttlCol;j++)  //col=0,1,2
				{				
					data[i-1][j]=ReadExcelFile.getCellValue(fileName, "LoginTestData", i, j);			
					
				}
				
			}
			
			return data;	
			
			
			
		}
	
	
	
	
// -------------------------------Verify Login	------------------------------
	
	@Test(dataProvider="LoginDataProvider",enabled=true)
	public void verifyLogin(String userEmail, String userPwd, String expectedUsername)
	{
		log.info("Verify Login test execution started....");
		indexPage pg=new indexPage(driver);
		pg.signin();
		
		log.info("Click on Signin");
		
		myAccount myAcpg=new myAccount(driver);
		myAcpg.enterEmailAddress(userEmail);
		myAcpg.enterEmailPassword(userPwd);
		
		log.info("Entered Email and password");
		
		myAcpg.signin();
		log.info("Clicked on Signin link.");
		
		registeredUserAccount regUsr=new registeredUserAccount(driver);
		String ActualUserName=regUsr.getUserName();		
		
		
		if(ActualUserName.equals(expectedUsername))
		{					
			Assert.assertTrue(true);
			log.info("Verify Login - Passed");	
			 regUsr.clickOnSignOut(); 
		}
		else
		{  			
			Assert.assertTrue(false);	
			
				log.info("Verify Login - Failed.");
			 regUsr.clickOnSignOut(); 
		}
		
		
	}
	
	
	
	
	
	
	
}
