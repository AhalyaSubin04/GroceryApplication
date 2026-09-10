package utilitiesOfMainProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	
	public void selectDropDownWithValue(WebElement element, String value)
	{

		Select object=new Select(element);

		object.selectByValue(value);

	}
	public void selectDropDownUsingVisibleText(WebElement element,String visibleText)
	{
		Select st=new Select(element);
		
		st.selectByVisibleText(visibleText);
		
	}
	
	public void selectDropDownUsingIndex(WebElement element,int index)
	{
		Select st=new Select(element);
		
		st.selectByIndex(index);
	}
	
	public void clickingByJSExecutor(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].click()", element);
	}
	
	public void scrollingByJSExecutor(int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0, y)", "");
	}
	
	public void rightClickAction(WebElement element)
	{
		Actions act=new Actions(driver);
		
		act.contextClick(element).build().perform();
	}

	public void mouseHoverAction(WebElement element)
	{
		Actions act=new Actions(driver);
		
		act.moveToElement(element).build().perform();
	}
	public void doubleClickAction(WebElement element)
	{
		Actions act=new Actions(driver);
		
		act.doubleClick(element).build().perform();
	}
	public void dragAndDropAction(WebElement element1,WebElement element2)
	{
		Actions act=new Actions(driver);
		
		act.dragAndDrop(element1, element2).build().perform();
	}
	

}


