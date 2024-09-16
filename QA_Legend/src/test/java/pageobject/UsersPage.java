package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage 
{
	WebDriver driver;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/users']")
	WebElement users_field;
	
	public void verify_Users_Field()
	{
		users_field.click();
		
	}
}
