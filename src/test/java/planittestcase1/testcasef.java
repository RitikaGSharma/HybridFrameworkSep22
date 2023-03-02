package planittestcase1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.ContactPagePlanit;
import pages.HomePagePlanit;

public class testcasef extends BaseClass
{
	
	@Test
	public void testCase1() 
	{
		
		HomePagePlanit home=new HomePagePlanit(driver);
		
	ContactPagePlanit contactpage=home.clickonContact();
		
		Assert.assertTrue(contactpage.mandatoryMsgForename().contains("Forename"));	
		
		//Assert.assertTrue(driver.findElement(By.xpath("//label[@for='email']")).getText().contains("Email"));	
		
		//Assert.assertTrue(driver.findElement(By.xpath("//label[@for='message']")).getText().contains("Email"));	

		
		
	}

}
