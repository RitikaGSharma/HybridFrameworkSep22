package browserFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

public class BrowserFactory {
static WebDriver driver;
	
	public static WebDriver getInstance()
	{
		return driver;
	}
	
	public static WebDriver startbrowser(String browsername,String applicationurl)
	{
		 
		if(browsername.contains("Chrome"))
		{
			driver = new ChromeDriver();
			
		}
		else if(browsername.contains("Firefox"))
		{
			driver = new FirefoxDriver();
			
		}
		else if(browsername.contains("Edge"))
		{
			driver = new EdgeDriver();
			
		}
		else
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(applicationurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	

}

