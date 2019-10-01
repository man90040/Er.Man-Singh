package com.ProjectName.ModuleName.newTestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.AutomationWorldByRahul.SeleniumTraining.DataCollection;
import com.AutomationWorldByRahul.SeleniumTraining.ExcelReader;

public class NewBaseClass {
	
	public static WebDriver driver;
	public static Properties pr;
	public static Properties or;
	
	public static ExcelReader er=new ExcelReader("C:\\Users\\acs\\workspace\\gmailTest\\src\\test\\resources\\testData_2\\mysheet.xlsx");
	
	@BeforeMethod
	public void loadingFilesAndBrowsers() throws IOException{
		
		pr=new Properties();
		FileInputStream f1=new FileInputStream("C:\\Users\\acs\\workspace\\GmailTest\\src\\test\\resources\\myProperties\\config.properties");
		pr.load(f1);
		
		or=new Properties();
		FileInputStream f2=new FileInputStream("C:\\Users\\acs\\workspace\\GmailTest\\src\\test\\resources\\myProperties\\or.properties");
		or.load(f2);
		
		if(pr.getProperty("Browser").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\acs\\workspace\\GmailTest\\src\\test\\resources\\myDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(pr.getProperty("Browser").equalsIgnoreCase("firefox"))
		{
			System.getProperty("webdriver.gecko.driver","C:\\Users\\acs\\workspace\\GmailTest\\src\\test\\resources\\myDrivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		
		driver.get(pr.getProperty("AppURL"));
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown() throws Exception{
		
		Thread.sleep(2000);
		//driver.quit();
	}
	
	@DataProvider
	public static Object[][] Data_collection(){
		
		DataCollection dc=new DataCollection(er, "Test_Data", "TC_FT_001");
		return dc.dataArray();
	}

}
