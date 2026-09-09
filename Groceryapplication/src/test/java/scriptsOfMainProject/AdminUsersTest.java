package scriptsOfMainProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.TestNGBase;
import pagesofMainProject.AdminUsersPage;
import pagesofMainProject.HomePage;
import pagesofMainProject.LoginPage;
import utilitiesOfMainProject.ExcelUtilitiesMain;
import utilitiesOfMainProject.RandomDataUtility;

public class AdminUsersTest extends TestNGBase{
	 HomePage hp;
	 AdminUsersPage ap;
	
	@Test(description="verify Whether The User Is Able To Add New AdminUsers")
	public void verifyWhetherTheUserIsAbleToAddNewAdminUsers() throws IOException
	{   
		String uname=ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
        String pswd=ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");  
	    LoginPage lp=new LoginPage(driver);
	    lp.enterUsername(uname).enterPassword(pswd);
	    
	    hp=lp.clickSignin();
	    
	    
	    ap=hp.clickMoreInfo();
	    
	    RandomDataUtility ru=new RandomDataUtility();
	    String usname=ru.generateRandomUsername();
	    String passwd=ru.generateRandomPassword();
	    
	   
	    ap.clickNewButton().enterUsername(usname).enterPassword(passwd).selectingFromDropdown().clickingSaveOption();
	   
	    boolean actual=ap.verifyWhetherSuccessAlertIsDisplayed();
	    Assert.assertTrue(actual,Constant.ADDNEWADMINUSERSERROR);
	    
	}
	
	@Test(description="verify The User Is Able To Search The Newly Added User")
	public void verifyTheUserIsAbleToSearchTheNewlyAddedUser() throws IOException
	{
		String uname=ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
        String pswd=ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");  
	    LoginPage lp=new LoginPage(driver);
	    lp.enterUsername(uname).enterPassword(pswd);
	   
	    hp=lp.clickSignin();
	    
	    
	    ap=hp.clickMoreInfo();
	    
	    String usname=ExcelUtilitiesMain.getStringData(0, 0, "AdminUsersInfo");
	   
	    ap.clickSearch().enteruserNameOnSearch(usname).selectingFromDropdownInSearch().clickSearchButton();
	    
	    String actual=ap.verifyWhetherDataIsDisplayedOnTable();
	    String expected="sheila.mertz";
	    Assert.assertEquals(actual, expected,Constant.SEARCHNEWLYADDEDUSERERROR);
	    
	    
	}
}
