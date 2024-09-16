package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.Excel_Utility;

public class Home_Page_Test extends Base_Class
{
@Test
public void verify_User_Login_Date()
{

	String username=Excel_Utility.get_StringData(0, 0, Constants.LOGINPAGE);
    String password=Excel_Utility.get_IntegerData(0, 1, Constants.LOGINPAGE);
    String expected_result=Constants.MESSAGE+Excel_Utility.get_StringData(0, 0, Constants.LOGINPAGE)+Constants.LOGINPAGEEXTENSION;
    LoginPage login=new LoginPage(driver);
    login.enter_Username(username);
    login.enter_Password(password);
    HomePage home=login.click_onLogin_Button();
    home.verify_Clickon_Endtour_Button();
    
    String homepage_Date=home.get_LoginDate();
	 String current_date=home.get_CurrentDate();
	 Assert.assertEquals(homepage_Date, current_date,"Date Missmatch" );
	 
}
}
	

