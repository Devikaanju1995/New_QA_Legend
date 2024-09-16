package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.TodayProfitPage;
import utilities.Excel_Utility;

public class Todays_Profit_Page_Test extends Base_Class
{
	@Test
	public void display_Finacial_Year_Profit()
	{
	String username=Excel_Utility.get_StringData(0, 0, Constants.LOGINPAGE);
    String password=Excel_Utility.get_IntegerData(0, 1, Constants.LOGINPAGE);
    
    LoginPage login=new LoginPage(driver);
    login.enter_Username(username);
    login.enter_Password(password);
    HomePage home=login.click_onLogin_Button();
    home.verify_Clickon_Endtour_Button();
    home.display_Today_Profit();
    TodayProfitPage todayprof=new TodayProfitPage(driver);
    String actual=todayprof.view_Closing_Stock();
    String expected="₹ 337,940,543.81";
    Assert.assertEquals(actual, expected,Messages.INVALIDPROFIT);
   
	}
}
