package siteUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrwoserFactory {
WebDriver driver;

public static WebDriver startApplication(WebDriver driver,String browserName,String appURL)
{
	if(browserName.equalsIgnoreCase("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browserName.equalsIgnoreCase("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	else
	{
		System.out.println("There is no browser exist in the name");
	}
	driver.get(appURL);
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
}
	
	
public static void closeApplication(WebDriver driver)
{
	driver.quit();
}
	
}
