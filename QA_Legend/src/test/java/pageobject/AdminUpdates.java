package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utility;

public class AdminUpdates
{
	WebDriver driver;
	public AdminUpdates(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}

	@FindBy(xpath="//input[@class='form-control' and @id='last_name']")
	WebElement changeadminlastname ;
	
	@FindBy(xpath="//button[@class='btn btn-primary pull-right']")
	WebElement updatebutton ;
	
	@FindBy(xpath="//div[text()='Profile updated successfully']")
	WebElement msg ;
	
	public HomePage enter_update_Lastname(String changelastname)
	{
		changeadminlastname.sendKeys(changelastname);
		return new HomePage(driver);
	}
	public void verify_Update_Button()
	{
		updatebutton.click();
	}
	public String verify_Get_Message() 
	{
		Wait_Utility.waitFor_Element(driver, msg);
		String result=msg.getText();
		return result;
	}
}
