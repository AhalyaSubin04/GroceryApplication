package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	public WebDriver driver;
	
	public ManageNewsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=' New']")WebElement newButton;
	@FindBy(id="news")WebElement newsTextArea;
	@FindBy(xpath="//button[text()='Save']")WebElement saveButton;
	@FindBy(xpath="//h5[text()=' Alert!']")WebElement alert;
	
	@FindBy(xpath="//a[text()=' Search']")WebElement searchOption;
	@FindBy(xpath="//input[@name='un']")WebElement newsTextFieldonSearch;
	@FindBy(xpath="//button[@name='Search']")WebElement searchButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement tableData;
	
	
	public ManageNewsPage clickNewButton() 
	{
		newButton.click();
		return this;
	}
	
	public ManageNewsPage entertextonNews(String newsText)
	{
		newsTextArea.sendKeys(newsText);
		return this;
	}
	
	public ManageNewsPage clickSaveButton()
	{
		saveButton.click();
		return this;
	}
	public boolean verifyWhetherSuccessAlertIsDisplayed()
	{
		return alert.isDisplayed();
		
	}
	
	public ManageNewsPage clickSearchOption()
	{
		searchOption.click();
		return this;
	}
	public ManageNewsPage enterNewsOnSearch(String newsText)
	{
		newsTextFieldonSearch.sendKeys(newsText);
		return this;
	}
	public ManageNewsPage clickSearchButton()
	{
		searchButton.click();
		return this;
	}
	public String verifyWhetherDataIsDisplayedOnTable()
	{
		return tableData.getText();
	}
	
	

}
