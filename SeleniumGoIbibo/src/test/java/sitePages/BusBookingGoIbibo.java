package sitePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BusBookingGoIbibo {


	public WebDriver driver;
	
	
	@FindBy(xpath="//input[@id='gi_source']") WebElement fromPlace;
	@FindBy(xpath="//input[@id='gi_destination']") WebElement toPlace;
	@FindBy(xpath="//input[@id='gi_onward_text']") WebElement calendar;
	@FindAll(value = { @FindBy (xpath="//table//td[@class='jrdp_calendar_box']//tr//td[contains(@class,'_day1_multi')]//span")}) List<WebElement> tableDays;
	@FindBy(xpath="//button[@id='gi_search_btn']") WebElement searchButton;
	@FindAll(value= {@FindBy(xpath="//li[@class=\"clearfix rowWrap\"]/div[2]/div[3]/div/span") }) List<WebElement> results;
	@FindBy(xpath="//i[@id='showhide']") WebElement expand;
	@FindBy(xpath="//ul[@class='navSection_tabs']/li[2]//i[2]") WebElement filterTime;
	//@FindBy(xpath="//ul[@id='time_filter_blk']//small[@xpath='1']") WebElement filterTimeValue;
	@FindBy(css="div.col-md-12.col-sm-12.col-xs-12.pad0:nth-child(15) div.dn:nth-child(16) div.container.containerWrap:nth-child(11) div.row.styleguide div.col-md-12 div.navSection.row.topTabLayer:nth-child(2) ul.navSection_tabs ul.navSection_secondary.navTimeSlot div:nth-child(1) div.onw div.navTimeSlotWrap span.navTimeSlotBlk:nth-child(1) > i.db.icon-sunrise.ico24.greyDr:nth-child(1)") WebElement filterTimeValue;
	@FindBy(xpath="//ul[@class='navSection_tabs']/li[3]//i[2]") WebElement bordingPoint;
	@FindBy(xpath="//label[@title='Koyambedu']") WebElement boardOption;
	@FindAll(value= {@FindBy(xpath="//ul[@id='bp_op_onw']//li/label")}) List<WebElement> boardopt;
	@FindAll(value= {@FindBy(xpath="//span[contains(@id,'payfare-redbusnew@')]") }) List<WebElement> prices;
	@FindAll (value= {@FindBy(xpath="//li[@class='clearfix rowWrap']/div[2]/div[3]/div/i")}) List<WebElement> toolTip;
	@FindAll (value= {@FindBy(xpath="//button[@class='button orng fr db row padLR5']")}) List<WebElement> selectTag;
	@FindAll (value= {@FindBy(xpath="//div[contains(@id,'lower-seats-area')]//div/a[@class='availableSeat']")}) List<WebElement> availSeats;
	@FindBy(xpath="//select[contains(@id,'bp-onw-redbusnew@')]") WebElement boardPoint;
	@FindBy(xpath="//select[contains(@id,'dp-onw-redbusnew@')]") WebElement dropPoint;
	@FindBy(xpath="//a[@id='confirm']") WebElement confirmButton;
	
	public void searchBuses(WebDriver driver)
	{
		Actions act=new Actions(driver);
		fromPlace.sendKeys("chennai");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		toPlace.sendKeys("salem");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		act.sendKeys(Keys.ARROW_DOWN).perform();
		act.sendKeys(Keys.ENTER).perform();
		calendar.click();
		int totalDays=tableDays.size();
		System.out.println("Total days are "+totalDays);
		for(WebElement day:tableDays)
		{
			String day_value=day.getText();
			if(day_value.equals("20"))
			{
				boolean b=day_value.contains("20");
				System.out.println(b);
				System.out.println("The selected date is "+day_value);
				day.click();
				break;
			}
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebElement verifyDate=driver.findElement(By.xpath("//input[@id='gi_onward_text']/span[2]"));
		String date1=verifyDate.getText();
		System.out.println(date1);
		//Assert.assertTrue(date1.contains("20"));
		searchButton.click();
	}
	
	public void selectResults(WebDriver driver)
	{
		driver.findElement(By.xpath("//span[@class='fl font14 padR10 padT5']")).click();
		expand.click();
		int total_resultset=results.size();
		System.out.println(total_resultset);
		if(total_resultset==0)
		{
			System.out.println("There is no results to display");
		}
		else
		{
		for(int i=0;i<total_resultset;i++)
		{
			System.out.println(results.get(i).getText());
		}
		Actions act=new Actions(driver);
		act.moveToElement(filterTime).build().perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		List<WebElement> timeOpt=driver.findElements(By.xpath("//div[@id='onw_dep_times']//span/small"));
		for(WebElement time1:timeOpt)
		{
			String timeValue=time1.getText();
			System.out.println(timeValue);
			if(timeValue.equals("5:00 - 11:00"))
			{
				time1.click();
			}
		}
		//System.out.println("The filter is "+filterTimeValue.isEnabled());
	    //act.moveToElement(filterTimeValue).click().build().perform();
	    act.moveToElement(bordingPoint).build().perform();
	    //WebDriverWait wait=new WebDriverWait(driver,15);
	    //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@title='Koyambedu']")));
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    for(WebElement opt:boardopt)
	    {
	    	String optValue=opt.getText();
	    	if(optValue.equals("Adyar"))
	    	{
	    		opt.click();
	    		break;
	    	}
	    	
	    }
	    //act.moveToElement(boardOption).click().build().perform();
	    int chaged_total=results.size();
	    System.out.println("The Mousehover happened");
	    System.out.println("The changed total is "+chaged_total);
	    for(WebElement tip:toolTip)
	    {
	    	System.out.println("The Tooltip Statment is "+tip.getAttribute("tooltip-label"));
	    }
		int no_of_select_tags=selectTag.size();
		System.out.println("The total no of select tags are "+no_of_select_tags);
	    }
		int total_no_of_prices=prices.size();
		System.out.println("The no of total prices are "+total_no_of_prices);
	    for(WebElement price:prices)
	    {
	    		String singlePrice=price.getText();
	    		if((Integer.parseInt(singlePrice))<400)
	    		{
	    			System.out.println(singlePrice);
	    		}
	    	
	    }
	    for(int i=0;i<total_resultset;i++)
		{
	    	String result=results.get(i).getText();
			if(result.equals("S R T"))
			{
				System.out.println(result);
				selectTag.get(i).click();
				System.out.println("Button selected");
				availSeats.get(i).click();
				break;
			}
		}
	    /*for(WebElement seat:availSeats) 
	    {
	    	seat.click();
	    	break;
	    }*/
	    Select select=new Select(boardPoint);
	    select.selectByValue("17966545-Ashok Pillar");
	    Select select1=new Select(dropPoint);
	    select1.selectByValue("432134-New Bus Stand");
	    String priceValue=driver.findElement(By.xpath("//span[contains(@id,'farediv-onw-redbusnew@')]")).getText();
	    Assert.assertTrue(Integer.parseInt(priceValue)!=0);
	    confirmButton.click();
	    Assert.assertTrue(driver.findElement(By.xpath("//span[@class='bkStepHdr']")).isDisplayed());
		System.out.println("Booking Confirmed");
	}

	
}
