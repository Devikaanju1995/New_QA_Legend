package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	@FindBy(id="username")
	WebElement username_field;
	
	@FindBy(id="password")
	WebElement password_field;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement login_button;
	
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement click_forgot_button;
	
	@FindBy(xpath="//span[@class='help-block']")
	WebElement welcome_user_mess;
	
    public void enter_Username(String username)
	{
		username_field.sendKeys(username);
		
	}
	public void enter_Password(String password)
	{
		password_field.sendKeys(password);
	}
	public HomePage click_onLogin_Button()  //should return
	{
		login_button.click();
		           //constructor
		return new HomePage(driver);
	}
	public Resetpage verify_forget_button()
	{
		click_forgot_button.click();
		return new Resetpage(driver);
	}
	public String get_DisplayMessage()
	{
		String textmessage=welcome_user_mess.getText();
		return textmessage;

}
}
