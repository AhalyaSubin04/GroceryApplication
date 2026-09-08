package scriptsOfMainProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.TestNGBase;
import pagesofMainProject.HomePage;
import pagesofMainProject.LoginPage;
import utilitiesOfMainProject.ExcelUtilitiesMain;

public class LoginTest extends TestNGBase {
	HomePage hp;

	@Test(priority = 1, description = "User is trying to Login with valid credentials", groups = { "smoke" })
	public void verifyLoginWithValidCredentials() throws IOException {
		String uname = ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
		String pswd = ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd);
		hp=lp.clickSignin();
		
		boolean dash = lp.verifyWhetherDashboardIsDisplayed();
		Assert.assertTrue(dash,Constant.VALIDCREDENTIALERROR);
	}

	@Test(priority = 2, description = "User is trying to Login with Invalid credentials", retryAnalyzer = retry.Retry.class)

	public void verifyLoginWithInValidCredentials() throws IOException {
		String uname = ExcelUtilitiesMain.getStringData(1, 0, "GrocerySheet");
		String pswd = ExcelUtilitiesMain.getStringData(1, 1, "GrocerySheet");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd).clickSignin();

		String actual = lp.verifylogintextisDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.INVALIDCREDENTIALERROR);
	}

	@Test(priority = 3, description = "User is trying to Login with valid Username and Invalid password",dataProvider="LoginData")
	public void verifyLoginWithValidUsernameAndInvalidPassword(String uname,String pswd) throws IOException {
		//String uname = ExcelUtilitiesMain.getStringData(2, 0, "GrocerySheet");
		//String pswd = ExcelUtilitiesMain.getStringData(2, 1, "GrocerySheet");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd).clickSignin();

		String actual = lp.verifylogintextisDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected,Constant.VALIDUSERNAMEANDINVALIDPASSWORDERROR);
	}

	@Test(priority = 4, description = "User is trying to Login with Invalid Username and valid password", groups = {
			"smoke" })
	public void verifyLoginWithInValidUsernameAndvalidPassword() throws IOException {
		String uname = ExcelUtilitiesMain.getStringData(3, 0, "GrocerySheet");
		String pswd = ExcelUtilitiesMain.getStringData(3, 1, "GrocerySheet");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd).clickSignin();
		String actual = lp.verifylogintextisDisplayed();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEANDVALIDPASSWORDERROR);

	}

  @DataProvider(name = "LoginData")
  public Object[][] getDataFromDataProvider() {
		return new Object[][] { new Object[] { "admin", "Ahalya123" }, new Object[] { "admin", "admin456" } };

	}
}
