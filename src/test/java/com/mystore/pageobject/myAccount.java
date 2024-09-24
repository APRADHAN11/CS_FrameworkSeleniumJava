package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class myAccount {

	WebDriver ldriver;
	
	public myAccount(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id="email_create") WebElement createEmailId;
	
	@FindBy(id="SubmitCreate") WebElement SubmitCreate;
	
	@FindBy(id="email") WebElement registeredEmailAddress;
	
	@FindBy(id="passwd") WebElement registeredPassword;
	
	@FindBy(id="SubmitLogin") WebElement signIn;

	
	//identify action on WebPage
	
	public void enterCreateEmailId(String emailAdd)
	{
		createEmailId.sendKeys(emailAdd);
	}
	
	public void clickSubmitCreate()
	{
		SubmitCreate.click();
	}
	
	
	//Action method for Already Registered Users
	
	public void enterEmailAddress(String signinEmailAddress)
	{
		registeredEmailAddress.sendKeys(signinEmailAddress);
	}
	
	public void enterEmailPassword(String signinPassword)
	{
		registeredPassword.sendKeys(signinPassword);
	}
	
	public void signin()
	{
		signIn.click();
	}
	
	
	
	
}
