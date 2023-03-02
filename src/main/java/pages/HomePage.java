package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By msg=By.xpath("//a[normalize-space()='Practise']");
	By signout=By.xpath("//button[normalize-space()='Sign out']");
	
	public void clickonSignOut()
	{
		driver.findElement(signout).click();
	}
	
	public String getMsg()
	{
	return	driver.findElement(msg).getText();
	}
}
