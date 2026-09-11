package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
	
      this.driver=driver;
      PageFactory.initElements(driver, this);
    }
	
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement Admin;
	@FindBy(linkText="Logout")WebElement logout;
	
	@FindBy(xpath="//div[@class='row']//div[2]/div/a")WebElement moreInfo;
	@FindBy(xpath="//div[@class='row']//div[13]/div/a")WebElement moreInfoNews;
	
	@FindBy(xpath="//div[@class='row']//div[8]/div/a")WebElement moreInfoDeliveryBoy;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement rmart;
	
	
	public HomePage clickAdmin()
	{
		Admin.click();
		return this;
	}
	public LoginPage clickLogOut()
	{   
		logout.click();
		return new LoginPage(driver);
	}
	
	public AdminUsersPage clickMoreInfo()
	{
		moreInfo.click();	
		return new AdminUsersPage(driver);
		
	}
	
	public ManageNewsPage clickMoreInfoOfManageNews()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", moreInfoNews);
		return new ManageNewsPage(driver);
	}
	public ManageDeliveryBoyPage clickMoreInfoOfDeliveryBoy()
	{
		moreInfoDeliveryBoy.click();
		return new ManageDeliveryBoyPage(driver);
	}
	public String verifylogintextisDisplayed()
	{
		return rmart.getText();
	}

	
}
