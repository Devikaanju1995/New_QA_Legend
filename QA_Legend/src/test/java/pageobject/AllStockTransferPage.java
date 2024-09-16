package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Wait_Utility;

public class AllStockTransferPage 
{
	WebDriver driver;
	public AllStockTransferPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement stocksearchbar;
	@FindBy(xpath="//table[@id='stock_transfer_table']/tbody/tr[2]/td[3]")
	WebElement tabledata;
	@FindBy(xpath="//table[@id='stock_transfer_table' ]/tbody/tr[2]/td[8]")
	WebElement viewstock;
	
	
	
	public void Enter_Searh_Item(String stocksearch) 
	{
		stocksearchbar.sendKeys(stocksearch);
	}
	public String get_Table_Data() 
	{
			Wait_Utility.waitFor_Element(driver, tabledata);
			String result=tabledata.getText();
			return result;
	
	}
	public void verify_View_Required_Stock() 
	{
		viewstock.click();
	}
}
