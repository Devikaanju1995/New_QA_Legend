package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Date_Utility;

public class HomePage 
{
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement  endtour_button;
	
	@FindBy(xpath="//section[@class='content-header']")
	WebElement  welcome_user_mess;
	
	@FindBy(xpath="//span[text()='Admin ']")
	WebElement  click_admin_user;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement admin ;
	
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profilefield ;
	
	
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement logout_button ;
	
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement login_date;
	
	@FindBy(xpath="//button[@id='view_todays_profit']")
	WebElement todayprofit;
	
	public void verify_Clickon_Endtour_Button()
	{
		endtour_button.click();
	}
	public String get_MessageDisplay()
	{
		String messagetext= welcome_user_mess.getText();
		return messagetext;
	}
	public void click_On_Admin()
	{
		click_admin_user.click();
	}
public void click_Logout()
{
	logout_button.click();
}
public void click_On_Adminabc()
{
	admin.click();
}
public void click_On_Profile_Field()
{
	profilefield.click();
}


public String get_LoginDate()
{
	String logindate=login_date.getText();
	return logindate;
}
public String get_CurrentDate()
{
	return Date_Utility.get_UserLogin_Date("dd-MM-YYYY");
}
public void display_Today_Profit()
{
	todayprofit.click();
}
}
