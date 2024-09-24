package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	
	//Create Object
	
	WebDriver ldriver;  //local driver
	
	public indexPage(WebDriver rdriver) //remote driver constructor
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	//identify webElements	
	@FindBy(linkText="Sign in") 
	WebElement signIn;
	
	//identify action on webElement	
	public void signin()
	{
		signIn.click();
	}
	
}
