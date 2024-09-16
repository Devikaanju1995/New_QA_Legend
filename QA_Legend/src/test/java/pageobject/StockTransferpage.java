package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StockTransferpage 
{
	WebDriver driver;
	public StockTransferpage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);     ///to initialize webdriver, page factorty in selenium package
	}
	@FindBy(xpath="//i[@class='fa fa-truck']")
	WebElement clickstocktransfer;
	
	@FindBy(xpath="//a[@href='https://qalegend.com/billing/public/stock-transfers']")
	WebElement liststocktransfer;
	
	public void click_On_Stock_Transfer() 
	{
		clickstocktransfer.click();
	}
	
	public void click_On_List_Stock_Transfer() 
	{
		liststocktransfer.click();
	}
	
	
}
