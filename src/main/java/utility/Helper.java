package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Helper {
	public static WebDriver startbrowser(String browsername,String applicationurl)
	{
		WebDriver driver =null;
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
			Reporter.log("Browser "+browsername+" not found",true);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));
		driver.get(applicationurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	

	public static Alert waitforalert(WebDriver driver,int time)
	{
		Alert alt=null;
		for(int i=0;i<=time;i++)
		{
			
		try
		{
		 alt=driver.switchTo().alert();
		break;
		}
		catch(NoAlertPresentException e)
		{
			System.out.println("No alert present");
			waitforseconds1(1);
		}
	
		}return alt;
	}
public static void waitforseconds1(int seconds)
{
	try
	{
	Thread.sleep(seconds*1000);
	}
	catch(InterruptedException e)
	{
}
}
public static void waitForElement(WebElement ele,int sec)
{
	try {
		if(ele.isEnabled())
		{
			System.out.println("Element enabled");
		}
	} catch (Exception e) {
		 waitforseconds1(1);
	}
}
public static void capturescreenshot(WebDriver driver)
{
	try
	{
		FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(".Screenshot/Screenshots_"+getcurrentTime()+".jpeg"));

	} 
	catch (IOException e)
	{
		System.out.println("Something went wrong "+e.getMessage());
	}
}
public static String getcurrentTime()
{
	String date=new SimpleDateFormat("HH_mm_ss dd_MM_yyyy").format(new Date());
	return date;
}
public static void captureScreenshotOfWebElement(WebElement ele) 
{
	try {
		FileHandler.copy(((TakesScreenshot)ele).getScreenshotAs(OutputType.FILE), new File("./Screenshot/Myscreenshot"+ getcurrentTime()+ ".png"));
	} 
	catch (IOException e)
			{

		System.out.println("Something went wrong "+e.getMessage());
	
	}
}

public static String capturescreenshotinbase64(WebDriver driver)
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	String base64=ts.getScreenshotAs(OutputType.BASE64);
	return base64;
}


public static WebElement highlightwebelemet(WebElement element , WebDriver driver)
{
JavascriptExecutor js=(JavascriptExecutor)driver;

js.executeScript("arguments[0].setAttribute('style','background: yellow; border:2px solid red;')", element);

waitforseconds1(1);

js.executeScript("arguments[0].setAttribute('style','border:2px solid white;')", element);

return element;

}
}
