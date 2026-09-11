package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {
	
	public WebDriver driver;
	
	public ManageDeliveryBoyPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=' New']")WebElement newOfDelivery;
	@FindBy(id="name")WebElement name;
	@FindBy(id="email")WebElement emailId;
	@FindBy(id="phone")WebElement phoneNumber;
	@FindBy(id="address")WebElement address;
	@FindBy(id="username")WebElement userName;
	@FindBy(id="password")WebElement password;
	@FindBy(xpath="//button[text()='Save']")WebElement saveButton;
	
	@FindBy(xpath=" //h5[contains(text(),'Alert!')]")WebElement alert;
	
	@FindBy(xpath="//a[text()=' Search']")WebElement search;
	@FindBy(id="un")WebElement nameOnSearch;
	@FindBy(id="ut")WebElement mailIdOnSearch;
	@FindBy(id="ph")WebElement phoneNumberOnSearch;
	@FindBy(xpath="//button[@value='sr']")WebElement searchButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[3]")WebElement phoneNumberOnTable;
	
	
	
	public ManageDeliveryBoyPage clickNew()
	{
		newOfDelivery.click();
		return this;
	}
	public ManageDeliveryBoyPage enterName(String name1)
	{
		name.sendKeys(name1);
		return this;
	}
	public ManageDeliveryBoyPage enterEmailId(String mail)
	{
		emailId.sendKeys(mail);
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNumber(String num)
	{
		phoneNumber.sendKeys(num);
		return this;
	}
	public ManageDeliveryBoyPage enterAddress(String add)
	{
		address.sendKeys(add);
		return this;
	}
	public ManageDeliveryBoyPage enterUserName(String usname)
	{
		userName.sendKeys(usname);
		return this;
	}
	public ManageDeliveryBoyPage enterPassword(String pass)
	{
		password.sendKeys(pass);
		return this;
	}
	public ManageDeliveryBoyPage clickSaveButton() 
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", saveButton);
		return this;
	}
	
	public boolean verifyWhetherSuccessAlertIsDisplayed() 
	{
		return alert.isDisplayed();
	}
	
	
	public ManageDeliveryBoyPage clickSearch()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", search);
		return this;
	}
	public ManageDeliveryBoyPage enterNameOnSearch(String name1)
	{
		nameOnSearch.sendKeys(name1);
		return this;
	}
	public ManageDeliveryBoyPage enterMailIdOnSearch(String newmail)
	{
		mailIdOnSearch.sendKeys(newmail);
		return this;
	}
	public ManageDeliveryBoyPage enterPhoneNumberOnSearch(String newnum)
	{
		phoneNumberOnSearch.sendKeys(newnum);
		return this;
	}
	public ManageDeliveryBoyPage clickSubmitButton() 
	{
		searchButton.click();
		return this;
	}
	
	public String verifyWhetherPhoneNumberDataIsDisplayedOnTable()
	{
		return phoneNumberOnTable.getText();
	}
	

}
