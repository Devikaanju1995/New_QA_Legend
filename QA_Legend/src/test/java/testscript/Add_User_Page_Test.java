package testscript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobject.AddUsersPage;
import pageobject.ClickAddUsers;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UserManagementPage;
import pageobject.UsersPage;
import utilities.Excel_Utility;
import utilities.Random_Data_Utility;

public class Add_User_Page_Test extends Base_Class
{
	private WebElement webElement;


	@Test
	public void verify_Add_User()
	{
		String username=Excel_Utility.get_StringData(0, 0, Constants.HOMEPAGE);
		String password=Excel_Utility.get_IntegerData(0, 1, Constants.HOMEPAGE);
		
		String firstname=Random_Data_Utility.get_Firstname();
		String lastname=Random_Data_Utility.get_Lastname();
		String emailid=firstname+"."+lastname+"@gmail.com";
		String user_name=firstname+lastname;
		String passsword=firstname+"@"+lastname;
	
		LoginPage login=new LoginPage(driver);
		login.enter_Username(username);
	    login.enter_Password(password);
		HomePage home=login.click_onLogin_Button();
		home.verify_Clickon_Endtour_Button();
		UserManagementPage usermngmt=new UserManagementPage(driver);
		usermngmt.verify_User_Management_Field();
		UsersPage userpage=new UsersPage(driver);
		userpage.verify_Users_Field();
		ClickAddUsers clickuser=new ClickAddUsers(driver);
		clickuser.verify_Users_Field();
		AddUsersPage adduser=new AddUsersPage(driver);
		adduser.add_User_Datas(firstname, lastname, emailid, user_name, passsword);
		/*adduser.get_Surname();
		adduser.get_Firstname(firstname);
		adduser.get_Lastname(lastname);
		adduser.get_emails(emailid);
		adduser.get_Username(user_name);
		adduser.get_UserPassword(passsword);
		adduser.get_Confirmpassword(passsword);*/
		adduser.verify_click_save_Button();
		clickuser.verify_search_user(user_name);
		String actual_result=clickuser.display_Search_Data();
		Assert.assertEquals(actual_result,user_name,Messages.VERIFYADDUSER); 
		
		
		/*String actualresult=emailid;
		String expectedresult=clickuser.get_DisplayMessage();
		Assert.assertEquals(actualresult, expectedresult,"no add user found");*/
		
		/*String actualresult=emailid;
		String expectedresult=clickuser.get();
		Assert.assertEquals(actualresult, expectedresult,"no add user found");*/
		
		
		
		
		/*WebElement search_bar_in_userpage=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
		search_bar_in_userpage.sendKeys(emailid);
		String actualresult=emailid;
		
		WebElement table_useremail=driver.findElement(By.xpath("//table[@id='users_table']/tbody/tr/td[4]"));
		String expectedresult=table_useremail.getText();
		
		
		
		Assert.assertEquals(actualresult, expectedresult,"no add user found"); */
		
		
		
	}
	
	
	@Test
	public void verify_User_Loginwith_Newly_Added_User()
	{
		String username=Excel_Utility.get_StringData(0, 0, Constants.LOGINPAGE);
		String password=Excel_Utility.get_IntegerData(0, 1, Constants.LOGINPAGE);
		
		
		
		String firstname=Random_Data_Utility.get_Firstname();
		String lastname=Random_Data_Utility.get_Lastname();
		String emailid=firstname+"."+lastname+"@gmail.com";
		String user_nam=firstname+lastname;
		String passsword=firstname+"@"+lastname;
		
		LoginPage login=new LoginPage(driver);
		login.enter_Username(username);
		login.enter_Password(password);
		HomePage home=login.click_onLogin_Button();
		home.verify_Clickon_Endtour_Button();
		UserManagementPage usermngmt=new UserManagementPage(driver);
		usermngmt.verify_User_Management_Field();
		UsersPage userpage=new UsersPage(driver);
		userpage.verify_Users_Field();
		ClickAddUsers clickuser=new ClickAddUsers(driver);
		clickuser.verify_Users_Field();
		AddUsersPage adduser=new AddUsersPage(driver);
		
		adduser.add_User_Datas(firstname, lastname, emailid, user_nam, passsword);
		/*adduser.get_Surname();
		adduser.get_Firstname(firstname);
		adduser.get_Lastname(lastname);
		adduser.get_emails(emailid);
		adduser.get_Username(user_nam);
		adduser.get_UserPassword(passsword);
		adduser.get_Confirmpassword(passsword);*/
		adduser.verify_click_save_Button();
		clickuser.back_To_home();
		home.click_On_Admin();
		home.click_Logout();
		login.enter_Username(username);
		login.enter_Password(password);
		login.click_onLogin_Button();
		 String actualresult=home.get_MessageDisplay();
		 String expectedres="Welcome"+" "+username+",";
		 Assert.assertEquals(actualresult, expectedres,Messages.NEWLYADDEDUSER);
		 
	}
	

}
