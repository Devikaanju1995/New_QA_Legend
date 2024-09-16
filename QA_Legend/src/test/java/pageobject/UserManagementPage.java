package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage
{
	WebDriver driver;
	public UserManagementPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	
	
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management_field;
	
	public void verify_User_Management_Field()
	{
		user_management_field.click();
	}
}
