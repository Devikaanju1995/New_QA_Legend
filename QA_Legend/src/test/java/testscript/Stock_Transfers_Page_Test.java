package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base_Class;
import constants.Constants;
import constants.Messages;
import pageobject.AllStockTransferPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.StockTransferpage;
import utilities.Excel_Utility;

public class Stock_Transfers_Page_Test extends Base_Class
{
	@Test
	public void verify_search_stock_location()
	{
	String username=Excel_Utility.get_StringData(0, 0, Constants.HOMEPAGE);
	String password=Excel_Utility.get_IntegerData(0, 1, Constants.HOMEPAGE);
	String stocks=Excel_Utility.get_StringData(0, 0, Constants.STOCKTRANSFER);
	LoginPage login=new LoginPage(driver);
	login.enter_Username(username);
    login.enter_Password(password);
	HomePage home=login.click_onLogin_Button();
	home.verify_Clickon_Endtour_Button();
	StockTransferpage stocktransferpage=home.click_On_Stock_Transfer();
	AllStockTransferPage allstock=stocktransferpage.click_On_List_Stock_Transfer();
	allstock.Enter_Searh_Item(stocks);
	String actualdata=allstock.get_Table_Data();
	Assert.assertEquals(actualdata, stocks,Messages.IVALIDSTOCKSEARCH);
	}
}
