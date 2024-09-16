package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testscript.Add_User_Page_Test;

public class AddUsersPage 
{
	WebDriver driver;
	public AddUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement prefix_field;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement  firstname_field;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lastname_field;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email_field;
	
	@FindBy(xpath="//input[@id='username']")
	WebElement usersname_field;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement user_password_field;
	
	@FindBy(xpath="//input[@id='confirm_password']")
	WebElement user_confirmpassword_field;
	
	@FindBy(xpath="//button[@id='submit_user_button']")
	WebElement save_button;
	
	
	public void add_User_Datas(String firstname,String lastname,String emailid,String  name,String   passsword)
	{
		prefix_field.sendKeys("Mrs");
		firstname_field.sendKeys(firstname);
		lastname_field.sendKeys(lastname);
		email_field.sendKeys(emailid);
		lastname_field.sendKeys( name);
		user_password_field.sendKeys(  passsword);
		user_confirmpassword_field.sendKeys(  passsword);
	}
	
	/*public void get_Surname()
	{
		prefix_field.sendKeys("Mrs");
	}
	
	public void get_Firstname(String firstname)
	{
		firstname_field.sendKeys(firstname);
		
	}
	
	public void get_Lastname(String lastname)
	{
		lastname_field.sendKeys(lastname);
		
	}
	
	public void get_emails(String emailid)
	{
		email_field.sendKeys(emailid);
		
	}
	
	public void get_Username(String  usernam)
	{
		lastname_field.sendKeys( usernam);
		
	}
	
	
	public void get_UserPassword(String   passsword)
	{
		 user_password_field.sendKeys(  passsword);
		
	}
	
	public void get_Confirmpassword(String   passsword)
	{
		 user_confirmpassword_field.sendKeys(  passsword);
		
	}*/
	
	public UsersPage verify_click_save_Button()
	{
		save_button.click();
		return new UsersPage(driver);
	}
	
	
	
}
