package siteUtilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandler {

	
	public static void FrameSwitching(WebDriver driver,String Frameid,String Expath)
	{
		driver.switchTo().frame(Frameid);
		List<WebElement> frames=driver.findElements(By.tagName("iframe"));
		for(WebElement frame:frames)
		{
			String FrameIdInside=frame.getAttribute("id");
			System.out.println(FrameIdInside);
		}
		driver.findElement(By.xpath(Expath)).click();
		
	}
}
