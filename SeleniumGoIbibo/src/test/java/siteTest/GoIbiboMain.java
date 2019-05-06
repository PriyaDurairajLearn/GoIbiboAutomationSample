package siteTest;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sitePages.BusBookingGoIbibo;
import sitePages.HotelBookingGoIbibo;
import sitePages.LoginPageGoIbibo;

public class GoIbiboMain extends BaseClass {
	
	@Test(priority=1)
	public void LoginApp()
	{
		logger=report.startTest("Login Test");
		System.out.println("Testing");
		LoginPageGoIbibo login=PageFactory.initElements(driver, LoginPageGoIbibo.class);
		login.LoginGoIbibo(driver, excel.getSheetValue("Login", 0, 0),excel.getSheetValue("Login", 0, 1));
	}

	@Test(priority=2)
    public void HotelBooking()
    {
    	logger=report.startTest("Hotel Booking");
    	WebElement frames=driver.findElement(By.tagName("iframe"));
    	String frame_id=frames.getAttribute("id");
    	System.out.println(frame_id);
    	//WebDriverWait wait1=new WebDriverWait(driver, 10);
    	//wait1.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("webklipper-publisher-widget-container-notification-frame\", \"//a/i[@class='wewidgeticon we_close']"));
    	siteUtilities.FrameHandler.FrameSwitching(driver, "webklipper-publisher-widget-container-notification-frame", "//a/i[@class='wewidgeticon we_close']");
    	List<WebElement> Options=driver.findElements(By.xpath("//ul[@class='mainLinks']/li"));
    	int Opt_Count=Options.size();
    	for(int i=0;i<Opt_Count;i++)
    	{
    		WebElement Links=Options.get(i).findElement(By.tagName("a"));
    		String Link_Name=Links.getAttribute("href");
    		System.out.println(Link_Name);
    		if(Link_Name.contains("gostays"))
    		{
    			Links.click();
    			System.out.println("Clicked");
    			break;
    		}
    		
    	}
    	HotelBookingGoIbibo hotels=PageFactory.initElements(driver, HotelBookingGoIbibo.class);
    	hotels.bookHotel(driver);
    }
	

	@Test(priority=3)
	public void busBooking()
	{
		driver.findElement(By.xpath("//span[contains(@class,'iconText')][contains(text(),'Bus')]")).click();
		logger=report.startTest("Searching Buses");
		BusBookingGoIbibo bus=PageFactory.initElements(driver,BusBookingGoIbibo.class);
		bus.searchBuses(driver);
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='navSection_tabs']")).isDisplayed());
		logger.log(LogStatus.PASS, "Testcases Passed");
		System.out.println("Testcase Passed");
		bus.selectResults(driver);
		
		
		
	}
}
