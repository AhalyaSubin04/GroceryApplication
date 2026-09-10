package pagesofMainProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilitiesOfMainProject.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pu=new PageUtility();
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()=' New']")WebElement newButton;
	@FindBy(id="username")WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(id="user_type")WebElement userType;
	@FindBy(xpath="//button[@name='Create']")WebElement saveOption;
	
	@FindBy(xpath="//a[text()=' Search']")WebElement searchOption;
	@FindBy(id="un")WebElement usernameOnSearch;
	@FindBy(id="ut")WebElement userTypeOnSearch;
	@FindBy(xpath="//button[@value='sr']")WebElement searchButton;
	
	@FindBy(xpath="//h5[contains(text(),'Alert!')]")WebElement successAlert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement tableData;
	
	
	
	
	public AdminUsersPage clickNewButton()
	{
		newButton.click();
		return this;
	}
	
	public AdminUsersPage enterUsername(String usname)
	{
		username.sendKeys(usname);
		return this;
	}
	public AdminUsersPage enterPassword(String passwd)
	{
		password.sendKeys(passwd);
		return this;
	}
	public AdminUsersPage selectingFromDropdown()
	{
		pu.selectDropDownWithValue(userType, "admin");
		return this;
		//Select utype=new Select(userType);
		//utype.selectByValue("admin");
		
	}
	
	public AdminUsersPage clickingSaveOption()
	{
		saveOption.click();
		return this;
	}
	
	public AdminUsersPage clickSearch()
	{
		searchOption.click();
		return this;
	}
	public AdminUsersPage enteruserNameOnSearch(String usname)
	{
		usernameOnSearch.sendKeys(usname);
		return this;
	}
	public AdminUsersPage selectingFromDropdownInSearch()
	{
		pu.selectDropDownUsingVisibleText(userTypeOnSearch, "Admin");
		return this;
		//Select searchDrop=new Select(userTypeOnSearch);
		//searchDrop.selectByVisibleText("Admin");
	}
	public AdminUsersPage clickSearchButton()
	{
		searchButton.click();
		return this;
	}
	
	public boolean verifyWhetherSuccessAlertIsDisplayed()
	{
		return successAlert.isDisplayed();
	}
	public String verifyWhetherDataIsDisplayedOnTable()
	{
		return tableData.getText();
	}

}
