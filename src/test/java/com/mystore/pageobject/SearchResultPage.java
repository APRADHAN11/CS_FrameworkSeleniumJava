package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

	WebDriver ldriver;

	// create constructor
	public SearchResultPage(WebDriver rdriver)
	{
		ldriver=rdriver;

		//driver that will be used to lookup the web element
		PageFactory.initElements(rdriver, this);
	}


	//identify the elements on search result page	

	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts'][normalize-space()='Faded Short Sleeve T-shirts']")
	WebElement searchResultProduct;

	//Action methods on web elements of search result page 

	public String getSearchResultProductName()
	{
		String searchedProdName=searchResultProduct.getText();
		return(searchedProdName);

	}

	// identify more button and make action
	@FindBy(linkText="More") WebElement more;

	public void clickOnMoreLink()
	{
		more.click();
	}


}
