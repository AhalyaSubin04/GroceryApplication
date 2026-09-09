package scriptsOfMainProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import mainProject.TestNGBase;
import pagesofMainProject.HomePage;
import pagesofMainProject.LoginPage;
import pagesofMainProject.ManageDeliveryBoyPage;
import utilitiesOfMainProject.ExcelUtilitiesMain;
import utilitiesOfMainProject.RandomDataUtility;

public class ManageDeliveryBoyTest extends TestNGBase {
	HomePage hp;
	ManageDeliveryBoyPage md;
	
	@Test(description="verify Whether User Is Able To Add Details On New")
	public void verifyWhetherUserIsAbleToAddDetailsOnNew() throws IOException
	{
		String uname=ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
		String pswd=ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");  
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd);
		
		hp=lp.clickSignin();
		
		
		md=hp.clickMoreInfoOfDeliveryBoy();
		
		RandomDataUtility ru=new RandomDataUtility();
		String name1=ExcelUtilitiesMain.getStringData(0, 0, "ManageDeliveryBoySheet");
		String mail=ru.generateRandomEmailId();
		String num=ru.generateRandomPhoneNumber();
		String add=ExcelUtilitiesMain.getStringData(1, 0, "ManageDeliveryBoySheet");
		String usname=ru.generateRandomUsername();
		String pass=ru.generateRandomPassword();
		
		md.clickNew().enterName(name1).enterEmailId(mail).enterPhoneNumber(num).enterAddress(add).enterUserName(usname).enterPassword(pass).clickSaveButton();
		
	    boolean actual=md.verifyWhetherSuccessAlertIsDisplayed();
		Assert.assertTrue(actual,Constant.ADDNEWDETAILSTODELIVERYBOYERROR);
		}
	
	@Test(description="verify Whether User Is Able To Search The Newly Added Details")
	public void verifyWhetherUserIsAbleToSearchTheNewlyAddedDetails() throws IOException
	{
		String uname=ExcelUtilitiesMain.getStringData(0, 0, "GrocerySheet");
		String pswd=ExcelUtilitiesMain.getStringData(0, 1, "GrocerySheet");  
		LoginPage lp=new LoginPage(driver);
		lp.enterUsername(uname).enterPassword(pswd);
		hp=lp.clickSignin();
		
		
		md=hp.clickMoreInfoOfDeliveryBoy();
		
		String name1=ExcelUtilitiesMain.getStringData(0, 0, "ManageDeliveryBoySheet");
		String newmail=ExcelUtilitiesMain.getStringData(2, 0, "ManageDeliveryBoySheet");
		String newnum=ExcelUtilitiesMain.getStringData(3, 0, "ManageDeliveryBoySheet");
		
		
		
		md.clickSearch().enterNameOnSearch(name1).enterMailIdOnSearch(newmail).enterPhoneNumberOnSearch(newnum).clickSubmitButton();
		
		
		String actual=md.verifyWhetherPhoneNumberDataIsDisplayedOnTable();
		String expected="(610) 819-2681";
		Assert.assertEquals(actual, expected,Constant.SEARCHNEWLYADDEDDETAILSERROR);

	}

}
