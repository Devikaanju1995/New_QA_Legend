package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import automationcore.Base_Class;
import constants.Constants;
import constants.Messages;
import dataprovider.Data_Providers;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.Excel_Utility;

public class Login_Page_Test extends Base_Class
{
@Test(groups={"regression","sanity"})	
public void verify_Loginwith_Valid_Credentials()
{
	
	
	String username=Excel_Utility.get_StringData(0, 0, Constants.LOGINPAGE);
    String password=Excel_Utility.get_IntegerData(0, 1, Constants.LOGINPAGE);
    String expected_result=Constants.MESSAGE+Excel_Utility.get_StringData(0, 0, Constants.LOGINPAGE)+Constants.LOGINPAGEEXTENSION;
    LoginPage login=new LoginPage(driver);
    login.enter_Username(username);
    login.enter_Password(password);
    HomePage home=login.click_onLogin_Button();
    String actualresult=home.get_MessageDisplay();
    
    Assert.assertEquals(actualresult, expected_result, Messages.VALIDCREDENTIAL);
    
	
	
}
@Test(dataProvider="InvalidCredentials",dataProviderClass=Data_Providers.class)
public void verify_Errormessage_While_Loginwith_Invalid_Credentials(String username,String password)
{
	String expectedresult=Excel_Utility.get_StringData(0, 2, Constants.LOGINPAGE);
	
	WebElement username_field=driver.findElement(By.id("username"));
	username_field.sendKeys(username);
	
	WebElement password_field=driver.findElement(By.id("password"));
	password_field.sendKeys(password);
	
	WebElement login_button =driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
	login_button.click();
	
	WebElement invalid_message=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']"));
	String actualresult=invalid_message.getText();
	
	Assert.assertEquals(actualresult,  expectedresult,Messages.INVALIDCREDENTIAL);
	
}
}
