package siteTest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import siteUtilities.BrwoserFactory;
import siteUtilities.CaptureScreenshot;
import siteUtilities.ConfigDataReader;
import siteUtilities.ExcelDataReader;

public class BaseClass {
	WebDriver driver;
	ConfigDataReader config;
	CaptureScreenshot screen;
	ExcelDataReader excel;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeSuite
	public void setSettings()
	{
		Reporter.log("Setting up the system variables", true);
		config=new ConfigDataReader();
		screen=new CaptureScreenshot();
		excel=new ExcelDataReader();
		report=new ExtentReports(System.getProperty("user.dir")+"/Reports/Goibibo_"+screen.DatePattern()+".html");
		report.addSystemInfo("Host Name","PriyaDurairaj Windows");
		report.addSystemInfo("User Name","Priya Durairaj");
		report.addSystemInfo("Environment","QA");
	}
	
	@BeforeClass
	public void setUp()
	{
		Reporter.log("Starting the application", true);
		driver=BrwoserFactory.startApplication(driver,config.getBrowser() ,config.getURL());
		screen.CaptureScreen(driver,"LoginTest");
		
	}
	@AfterMethod
	public void quitBrowser(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String SPath=screen.CaptureScreen(driver, result.getName());
			logger.log(LogStatus.FAIL, "The Failed Testcase is"+result.getName());
			logger.log(LogStatus.FAIL, "This Testcase is failed due to"+result.getThrowable());
			logger.log(LogStatus.FAIL,logger.addScreenCapture(SPath));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			String SPath=screen.CaptureScreen(driver, result.getName());
			logger.log(LogStatus.PASS, "The Passed Testcase name is "+result.getName());
			logger.log(LogStatus.PASS, logger.addScreenCapture(SPath));
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			String SPath=screen.CaptureScreen(driver, result.getName());
			logger.log(LogStatus.SKIP, "The Skipped Testcase is "+result.getName());
			logger.log(LogStatus.SKIP, logger.addScreenCapture(SPath));
		}
		
		report.endTest(logger);
	}

	@AfterTest
	public void tearReport()
	{
		report.flush();
		report.close();
	}
	@AfterClass
	public void tearDown()
	{
		BrwoserFactory.closeApplication(driver);
	}
}
