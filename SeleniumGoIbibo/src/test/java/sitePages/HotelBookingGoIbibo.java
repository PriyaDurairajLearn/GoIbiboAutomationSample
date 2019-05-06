package sitePages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class HotelBookingGoIbibo {

WebDriver driver;
	
	@FindBy(xpath="//input[@id='gosuggest_inputL']") WebElement cityAreaHotel;
	@FindBy(xpath="//input[@placeholder='Choose Checkin']") WebElement CheckIn;
	@FindAll(value={@FindBy (xpath="//div[@class='DayPicker-Month']//div/div/div[@aria-disabled='false']")}) List<WebElement> CheckInDates;
	@FindBy(xpath="//input[@placeholder='Choose Checkout']") WebElement CheckOut;
	@FindAll(value={@FindBy(xpath="//div[@class='DayPicker-Month']//div/div/div[@aria-disabled='false']")}) List<WebElement> CheckOutDates;
	@FindBy(xpath="//span[@id='home_textHook']") WebElement Rooms;
	@FindBy(xpath="//select[@name='Room(s)']") WebElement RoomTextBox;
	@FindBy(xpath="//select[@name='Adult']") WebElement AdultTextBox;
	@FindBy(xpath="//select[@name='children']") WebElement ChildrenTextBox;
	@FindAll(value={@FindBy(xpath="//select[@name='Room(s)']//option")}) List<WebElement> RoomCount;
	@FindAll(value={@FindBy(xpath="//select[@name='Adult']/option")}) List<WebElement> AdultCount;
	@FindAll(value={@FindBy(xpath="//select[@name='children']/option")}) List<WebElement> ChildernCount;
	@FindBy(xpath="//button[contains(text(),'Done')]") WebElement DoneButton;
	@FindBy(xpath="//button[contains(text(),'Get Set')]") WebElement GoButton;
	
	public void bookHotel(WebDriver driver)
	{
	cityAreaHotel.sendKeys("Salem");
	Actions act1=new Actions(driver);
	//WebDriverWait wait1=new WebDriverWait(driver, 30);
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	act1.sendKeys(Keys.ARROW_DOWN).perform();
	act1.sendKeys(Keys.ENTER).build();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e1) {
		e1.printStackTrace();
	}
	act1.moveToElement(CheckIn).build().perform();
	for(WebElement checkInDate:CheckInDates)
	{
		String InDate=checkInDate.getText();
		System.out.println(InDate);
		if(InDate.contains("21"))
		{
			checkInDate.click();
			System.out.println("Clicked");
			break;
		}
	}
	try {
		Thread.sleep(3000);
	} catch (Exception e) {
		e.printStackTrace();
	}
	act1.click(CheckOut).build().perform();
	for(WebElement checkOutDate:CheckOutDates)
	{
		String OutDate=checkOutDate.getText();
		System.out.println(OutDate);
		if(OutDate.contains("30"))
		{
			checkOutDate.click();
			System.out.println("Clicked");
			break;
		}
	}
	Rooms.click();
	RoomTextBox.sendKeys("2");
	AdultTextBox.sendKeys("4");
	ChildrenTextBox.sendKeys("0");
	DoneButton.click();
	GoButton.click();
	System.out.println("Completed");
	}
}
