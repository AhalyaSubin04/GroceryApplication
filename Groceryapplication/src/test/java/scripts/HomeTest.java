package scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtilitiesMain;

public class HomeTest extends TestNGBase {
	HomePage hp;
	
	@Test(description="verify Whether The User Is Able To LogOut Successfully")
	public void verifyWhetherTheUserIsAbleToLogOutSuccessfully() throws IOException
	{
		String uname=ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
		String pswd=ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");  
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd);
		hp=lp.clickSignin();
		
		
		hp.clickAdmin();
		lp=hp.clickLogOut();
		
		String actual=hp.verifylogintextisDisplayed();
		String expected="7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.LOGOUTFROMHOMEPAGEERROR);

	}
	

}
	


