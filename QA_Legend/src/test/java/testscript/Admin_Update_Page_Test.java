package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobject.AdminUpdates;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.Excel_Utility;

public class Admin_Update_Page_Test extends Base_Class
{
	@Test
public void click_On_Admin_Updates()
{
	String username=Excel_Utility.get_StringData(0, 0, Constants.LOGINPAGE);
    String password=Excel_Utility.get_IntegerData(0, 1, Constants.LOGINPAGE);
    String admin_update=Excel_Utility.get_StringData(0, 0, Constants.ADMINUPDATE);
    LoginPage login=new LoginPage(driver);
    login.enter_Username(username);
    login.enter_Password(password);
    HomePage home=login.click_onLogin_Button();
    home.verify_Clickon_Endtour_Button();
    home.click_On_Adminabc();
    home.click_On_Profile_Field();
    AdminUpdates adminupdates=new AdminUpdates(driver);
    adminupdates.enter_update_Lastname(admin_update);
    adminupdates.verify_Update_Button();
    String expected_result=adminupdates.verify_Get_Message();
    String actual_result="Profile updated successfully";
    
	Assert.assertEquals(actual_result,expected_result,Messages.UPDATE); 
}
}
