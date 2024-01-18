package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import browserFactory.BrowserFactory;
import dataProvider.Customdata;
import io.reactivex.rxjava3.internal.operators.maybe.MaybeContains;
import pages.HomePage;
import pages.Loginpage;

public class LoginTest extends BaseClass {
	
	@Test(dataProvider="logindetails",dataProviderClass=Customdata.class)
	public void logintoApplication(String uname,String password)
	{
	
	
		Loginpage login =new Loginpage(driver);
		login.logintoapp(uname,password);
HomePage home=new HomePage(driver);
Assert.assertTrue(home.getMsg().contains("Practise") );
home.clickonSignOut();
Assert.assertTrue(login.isSignInPresent());
			
	}
	//Comment

}
