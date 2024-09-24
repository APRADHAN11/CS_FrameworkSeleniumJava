package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class registeredUserAccount {


	WebDriver ldriver;

	public registeredUserAccount(WebDriver rdriver)
	{
		ldriver=rdriver;

		PageFactory.initElements(rdriver, this);
	}

	//identify web Element
	@FindBy(xpath="//a[@title='Log me out']") WebElement signout;

	public void clickOnSignOut()
	{
		signout.click();
	}


	@FindBy(xpath="//a[@title='View my customer account']") WebElement regUserAcc;

	//identify action on WebPage

	public String getUserName()
	{
		String getText=regUserAcc.getText();
		return getText;
	}


	//POM for Search Box
	@FindBy(name="search_query") WebElement SearchBox; 

	@FindBy(name="submit_search") WebElement SubmitSearch;

	public void SearchBoxAction(String searchKey)
	{
		SearchBox.sendKeys(searchKey);

	}

	public void SubmitSearch()
	{
		SubmitSearch.click();

	}


}
