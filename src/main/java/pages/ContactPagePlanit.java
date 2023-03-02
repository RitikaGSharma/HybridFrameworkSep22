package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPagePlanit {
	WebDriver driver;
	public ContactPagePlanit(WebDriver driver)
	{
		this.driver=driver;
	}
By submit=By.xpath("//a[normalize-space()='Submit']");

public void clickonSubmit()
{
	driver.findElement(submit).click();
}

public String mandatoryMsgForename()
{
	return driver.findElement(By.xpath("//label[@for='forename']")).getText();
}
public void test1()
{
	
}

}
