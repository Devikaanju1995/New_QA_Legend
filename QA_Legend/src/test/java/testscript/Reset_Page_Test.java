package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v120.input.model.DragData;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobject.LoginPage;
import pageobject.Resetpage;
import utilities.Excel_Utility;

public class Reset_Page_Test extends Base_Class
{
	@Test
	public void verify_Errormessage_With_Invalid_Emailaddress()
	{
		String invalid_email=Excel_Utility.get_StringData(0, 0, Constants.RESETPAGE);
		String expectedresul=Excel_Utility.get_StringData(0, 2, Constants.RESETPAGE);
		
		LoginPage login=new LoginPage(driver);
		Resetpage reset=login.verify_forget_button();
		reset.verify_enter_email_field(invalid_email);
		reset.verify_click_password_reset_link();
		
		String actualresul=reset.get_display_message();
		Assert.assertEquals(actualresul, expectedresul,Messages.ERRORMESSAGEWITHINVALIDEMAIL);
		
		
	}
	@Test
	public void verify_Password_Resetwith_Valid_Emailaddress()
	{
		String valid_email=Excel_Utility.get_StringData(0, 1, Constants.RESETPAGE);
		String expectedresul=Excel_Utility.get_StringData(0, 3, Constants.RESETPAGE);
		
		LoginPage login=new LoginPage(driver);
		Resetpage reset=login.verify_forget_button();
		reset.verify_enter_email_field(valid_email);
		reset.verify_click_password_reset_link();
		
		String actualresul=reset.get_Successfull_Message();
		Assert.assertEquals(actualresul, expectedresul,Messages.RESETWITHVALIDEMAIL);
		
		
		
	}
}

