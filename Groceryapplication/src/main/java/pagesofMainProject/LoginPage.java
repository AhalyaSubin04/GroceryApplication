package pagesofMainProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilitiesOfMainProject.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	WaitUtility wu=new WaitUtility();
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")WebElement username;
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement signin;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement DashBoard;
	
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement rmart;
	
	public LoginPage enterUsername(String uname)
	{
		username.sendKeys(uname);
		return this;
	}
	
	public LoginPage enterPassword(String pswd)
	{
		password.sendKeys(pswd);
		return this;
	}
	
	public HomePage clickSignin()
	{
		wu.waitUntilElementToBeClickable(driver, signin);
		signin.click();
		return new HomePage(driver);
	}
	
	public boolean verifyWhetherDashboardIsDisplayed()
	{
		return DashBoard.isDisplayed();
	}
	
	public String verifylogintextisDisplayed()
	{
		return rmart.getText();
	}

}
