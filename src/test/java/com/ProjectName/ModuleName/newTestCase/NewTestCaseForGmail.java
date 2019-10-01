package com.ProjectName.ModuleName.newTestCase;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.ProjectName.ModuleName.newTestBase.NewBaseClass;

public class NewTestCaseForGmail extends NewBaseClass {
	
	/*@Test
	public void gmailTest(){
		
		driver.findElement(By.xpath(or.getProperty("Xmail"))).sendKeys(pr.getProperty("uid"));
		
		driver.findElement(By.xpath(or.getProperty("Xbtn"))).click();
		
		driver.findElement(By.xpath(or.getProperty("Xpwd"))).sendKeys(pr.getProperty("pwd"));
	}*/
	
	@Test(dataProvider="Data_collection")
	public void gmailTest(Hashtable<String, String>testData_2){
		
		driver.findElement(By.xpath(or.getProperty("Xmail"))).sendKeys(testData_2.get("EmailID"));
		
		driver.findElement(By.xpath(or.getProperty("Xbtn"))).click();
		
		driver.findElement(By.xpath(or.getProperty("Xpwd"))).sendKeys(testData_2.get("Password"));
	}

}
