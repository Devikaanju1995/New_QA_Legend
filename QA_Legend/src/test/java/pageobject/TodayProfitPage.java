package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testscript.Home_Page_Test;
import utilities.Wait_Utility;

public class TodayProfitPage
{
	WebDriver driver;
	public TodayProfitPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);    
	}
	@FindBy(xpath="//table[@class='table table-striped']/tbody/tr[1]/td[1s]")
	WebElement closingstock;
	
	
	
	public String view_Closing_Stock() 
	{
		Wait_Utility.waitFor_Element(driver, closingstock);
		String result=closingstock.getText();
		return result;	
	}
	
}

