package utilities;

import org.openqa.selenium.WebElement;

public class Web_Element_Utility 
{
	public void key_sendOperation(WebElement element, String text)
	{
		element.sendKeys("text");
	}
	public void clickable_Operation(WebElement element)
	{
		element.click();
	}
	public void radio_Check_dropDown_Operation(WebElement element, boolean isboolean)
	{
		isboolean=element.isSelected();
	}
	public void visibility_Operation(WebElement element, boolean isboolean)
	{
		isboolean=element.isDisplayed();
	}
	public void enable_Operation(WebElement element, boolean isboolean)
	{
		isboolean=element.isEnabled();
	}
}
