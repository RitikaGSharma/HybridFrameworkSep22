package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePagePlanit {
	
	WebDriver driver;
	public HomePagePlanit(WebDriver driver)
	{
		this.driver=driver;
	}
	By contact=By.xpath("//a[normalize-space()='Contact']");
	
	public ContactPagePlanit clickonContact()
	{
	driver.findElement(contact).click();
	ContactPagePlanit contactPage=new ContactPagePlanit(driver);
	return contactPage;
	}
	

}
