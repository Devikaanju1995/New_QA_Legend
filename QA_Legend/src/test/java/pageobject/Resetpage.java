package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testscript.Reset_Page_Test;

public class Resetpage 
{
	WebDriver driver;
	public Resetpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     
	}
	
	
	
	@FindBy(id="email")
	WebElement email_field;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement click_password_reset_link;
	
	@FindBy(xpath="//span[@class='help-block']")
	WebElement message;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successfulMessage;
	
	
	public void verify_enter_email_field(String invalid_email)
	{
		email_field.sendKeys(invalid_email);
	}
	public void verify_click_password_reset_link()
	{
		click_password_reset_link.click();
	
	}
	public String get_display_message()
	{
		String message_text= message.getText();
		return message_text;
	}
	public String get_Successfull_Message()
	{
		String message_texts= successfulMessage.getText();
		return message_texts;
	}
}
