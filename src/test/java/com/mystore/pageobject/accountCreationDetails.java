package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {
	
	
	WebDriver ldriver;
	
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver=rdriver;
		
		PageFactory.initElements(rdriver, this);
	}
	
	//identify webElement
	
	@FindBy(id="id_gender1") WebElement MrTitle;
//	@FindBy(id="id_gender2") WebElement MrsTitle;
	
	@FindBy(id="customer_firstname") WebElement customer_firstname;
	@FindBy(id="customer_lastname") WebElement customer_lastname;
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement password;
	
	@FindBy(id="days") WebElement days;
	@FindBy(id="months") WebElement months;
	@FindBy(id="years") WebElement years;
	
	@FindBy(id="submitAccount") WebElement submitAccount;
	
	
	//identify action methods on WebPage
	
	public void selectTitle()
	{
		MrTitle.click();
	}
	
	public void enterCustomerFirstName(String fname)
	{
		customer_firstname.sendKeys(fname);
	}
	
	public void enterCustomerLastName(String lname)
	{
		customer_lastname.sendKeys(lname);
	}
	
	public void enterEmail(String emailAddress)
	{
		email.clear();
		email.sendKeys(emailAddress);
	}
	
	public void enterPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void enterDays(String DayText)  // For DropDown using Select Class
	{
		days.click();
		Select day=new Select(days);		
		day.selectByValue(DayText);
		
	}
	
	public void enterMonths(String MonthText)   // For DropDown using Select Class
	{
		months.click();
		Select month=new Select(months);
		month.selectByVisibleText(MonthText);
	}
	
	public void enterYear(String YearText)  // For DropDown using Select Class
	{
		years.click();
		Select year=new Select(years);
		year.selectByValue(YearText);
	}
	
	public void clickOnRegister()
	{
		submitAccount.click();
	}	

}
