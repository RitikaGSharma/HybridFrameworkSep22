package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
		WebDriver driver;
		public Loginpage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		By user=By.id("email1");
		By pass=By.id("password1");
		By login=By.xpath("//button[normalize-space()='Sign in']");
		
		public void logintoapp(String username,String password)
		{
			driver.findElement(user).sendKeys(username);
			driver.findElement(pass).sendKeys(password);
			driver.findElement(login).click();
		}
		
		public boolean isSignInPresent()
		{
		return	driver.findElement(login).isDisplayed();
		}
}
