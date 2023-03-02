package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utility.Helper;

public class ExtentManager
{
	
public static	ExtentReports extent;
	
public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			extent=createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
	}
	
		public static ExtentReports createInstance()
	{
		ExtentSparkReporter sparkreporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Automation"+Helper.getcurrentTime()+".html");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setReportName("Automation Report");
		sparkreporter.config().setDocumentTitle("Sprint 1 Report");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(sparkreporter);
		return extent;
	}
}
