package base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import browserFactory.BrowserFactory;
import dataProvider.ConfigReader;

public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void setupBrowser()
	{
		System.out.println("LOG:INFO -- Setting up the browser");
		driver=	BrowserFactory.startbrowser(ConfigReader.getproperty("browser"), ConfigReader.getproperty("url"));
		System.out.println("LOG:INFO -- Application is up and running");

	}

	
	
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("LOG:INFO -- Closing the application and the browser");

	}
}
