package mainProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constant.Constant;
import utilitiesOfMainProject.ScreenShotUtility;

public class TestNGBase {
	
public WebDriver driver;

Properties pp;
FileInputStream fs;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
	public void initializeBrowser(String browsers) throws IOException
	{
		pp=new Properties();
		fs=new FileInputStream(Constant.CONFIGFILE);
		pp.load(fs);
		if(browsers.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsers.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		
		
		driver.get(pp.getProperty("URL"));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser(ITestResult itestresult) throws IOException{
		if(itestresult.getStatus()==ITestResult.FAILURE) {
			ScreenShotUtility screenshotutility=new ScreenShotUtility();
			screenshotutility.getScreenshot(driver, itestresult.getName());
		}
		 // driver.close();
		//driver.quit();
	}
	
	

}
