package com.mystore.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

import junit.framework.Assert;

public class TC_ProductPageTest extends BaseClass{
	
	
	@Test(enabled=true)
	public void verifyProductSearch(String userEmail, String userPwd) throws IOException
	{
		
		String SearchKey="T-Shirt";
	//	log.info("...TC Search Product Started....");
		
		
		//Signing
		
		indexPage pg=new indexPage(driver);
		pg.signin();
		
		//Enter Account details-Emailid and Password
		myAccount myAcpg=new myAccount(driver);
		myAcpg.enterEmailAddress(userEmail);
		myAcpg.enterEmailPassword(userPwd);
		myAcpg.signin();
		
		
		//Enter SearchKey in search box		
		registeredUserAccount productPg=new registeredUserAccount(driver);
		productPg.SearchBoxAction(SearchKey);
		productPg.SubmitSearch();
		
		
		//Get name of Search product
		SearchResultPage resultPg=new SearchResultPage(driver);
		String SearchResultProductName=resultPg.getSearchResultProductName();
		
		
// To verify the T-Shirt keyword present or not 
		if(SearchResultProductName.contains(SearchKey))
		{	
			log.info("Search Product Test Case passed.");
			Assert.assertTrue(true);
			productPg.clickOnSignOut(); 
		}
		else
		{  	
			log.info("Search Product Test Case failed.");
			CaptureScreenShots(driver,"verifyProductSearch");	
			Assert.assertTrue(false);	
			productPg.clickOnSignOut();
			
			
		}
		
		log.info("**********************Test case search product ends******************");	
		
	}	
	

}
