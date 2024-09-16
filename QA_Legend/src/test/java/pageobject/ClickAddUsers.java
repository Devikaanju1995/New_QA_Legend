package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utility;

public class ClickAddUsers 
{
	WebDriver driver;
	public ClickAddUsers(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users/create']")
	WebElement add_user_field;
	
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement search_bar_in_userpage;
	
	@FindBy(xpath="//table[@id='users_table']/tbody/tr[1]/td[1]")
	WebElement get_username_in_table;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/home']")
	WebElement return_home;
	
	
	public AddUsersPage verify_Users_Field()
	{
		add_user_field.click(); 
		return new AddUsersPage(driver);
		
	}
	
	public void verify_search_user(String searchdata)
	{
		search_bar_in_userpage.sendKeys(searchdata);
		
	}
	
	
public String display_Search_Data() 
{
	Wait_Utility.waitFor_Element(driver, get_username_in_table);
	String result=get_username_in_table.getText();
	return result;
}
public HomePage back_To_home()
{
	return_home.click();
	return new HomePage(driver);
}
	
	}

