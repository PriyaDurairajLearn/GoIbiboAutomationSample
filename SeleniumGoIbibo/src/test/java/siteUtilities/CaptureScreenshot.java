package siteUtilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

	public String CaptureScreen(WebDriver driver,String SSName)
	{
		
		TakesScreenshot screen=(TakesScreenshot)driver;
	
		File src=screen.getScreenshotAs(OutputType.FILE);
	
		String ScreenshotPath= System.getProperty("user.dir")+"/Screenshots/GoIbibo/"+SSName+"_"+DatePattern()+".png";
			try {
					FileHandler.copy(src, new File(ScreenshotPath));
				} catch (Exception e) {
					e.printStackTrace();
				}
		return ScreenshotPath;
	
	}
	

	
	public String DatePattern()
	{
		Date date=new Date();
		DateFormat customFormat=new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss");
		return customFormat.format(date);
	}
}
