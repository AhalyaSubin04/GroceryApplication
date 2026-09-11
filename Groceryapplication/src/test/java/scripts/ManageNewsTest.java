package scripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtilitiesMain;

public class ManageNewsTest extends TestNGBase {
	
	HomePage hp;
	ManageNewsPage mn;
	
	@Test(description="verify Whether The User Is Able To Add News")
	public void verifyWhetherTheUserIsAbleToAddNews() throws IOException
	{
		String uname=ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
		String pswd=ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");  
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd);
		hp=lp.clickSignin();
		
		
		mn=hp.clickMoreInfoOfManageNews();
		
		String newstoenter=ExcelUtilitiesMain.getStringData(0, 0, "ManageNewsSheet");
		
		mn.clickNewButton().entertextonNews(newstoenter).clickSaveButton();
		
		boolean actual=mn.verifyWhetherSuccessAlertIsDisplayed();
		Assert.assertTrue(actual,Constant.ADDNEWSTOMANAGENEWSERROR);
	}
	
	@Test(description= "verify The User Is Able To Search The Newly Added News")
	public void verifyTheUserIsAbleToSearchTheNewlyAddedNews() throws IOException
	{
		String uname=ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
		String pswd=ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");  
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd);
		
		hp=lp.clickSignin();
		
		mn=hp.clickMoreInfoOfManageNews();
		
		String newstoenter=ExcelUtilitiesMain.getStringData(0, 0, "ManageNewsSheet");
	
		
		mn.clickSearchOption().enterNewsOnSearch(newstoenter).clickSearchButton();
		
		String actual=mn.verifyWhetherDataIsDisplayedOnTable();
		String expected="Good Evening";
		Assert.assertEquals(actual, expected,Constant.SEARCHNEWLYADDEDNEWSERROR);
		
		
	}
	

}
