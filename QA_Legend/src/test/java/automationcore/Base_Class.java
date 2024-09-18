package automationcore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import constants.Constants;

public class Base_Class 
{
	 public WebDriver driver; 
	 public FileInputStream file;
	 public Properties prop;

public void initializebrowser(String browser)
{

	    prop=new Properties();	 
			 try {
				file=new FileInputStream(Constants.CONFIGFILE);
				try {
					prop.load(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(browser.equals("Chrome"))
			 {
				 driver=new ChromeDriver();
			 }
			 else if(browser.equals("Edge"))
			 {
				 driver=new EdgeDriver();
			 }
			 else if(browser.equals("Firefox"))
			 {
				 driver=new FirefoxDriver();
			 }
			 else
			 {
				 throw new RuntimeException("Invalid browser");
			 }
			 driver.manage().window().maximize();
		   
			 driver.get(prop.getProperty("url"));
		 }
		 @BeforeMethod(alwaysRun=true)
		 
		 public void setup()

		 {
			 initializebrowser("Chrome");
		 }
		 @AfterMethod(alwaysRun=true)
		 
		 public void closeBrowser(ITestResult result) throws IOException 
		 {
			if(result.getStatus()==ITestResult.FAILURE)
			{
				takeScreenshot(result);
			}
//			driver.close();
		 }
		public void takeScreenshot(ITestResult result) throws IOException 
		{
			TakesScreenshot takescreenshot=(TakesScreenshot)driver;
			File screenshot=takescreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./Screenshot/"+result.getName()+".png"));   //create a folder for a file
		}
		}