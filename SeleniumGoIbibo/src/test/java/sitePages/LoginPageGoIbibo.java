package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import siteUtilities.FrameHandler;

public class LoginPageGoIbibo {

	WebDriver driver;

	@FindBy(xpath="//a[contains(text(),'Sign In')]") WebElement signIn;
	@FindBy(xpath="//a[@class='fr marginT5 ico16 fmed']") WebElement logInButton;
	@FindBy(xpath="//input[@id='authUsername']") WebElement userName;
	@FindBy(xpath="//input[@id='authPassword']") WebElement passWord;
	@FindBy(xpath="//button[@id='authExistingUserSignInBtn']") WebElement signInButton;
	
	
	
	public void LoginGoIbibo(WebDriver driver,String appUsername,String appPassword)
	{
		signIn.click();
		FrameHandler.FrameSwitching(driver, "authiframe", "//a[@class='fr marginT5 ico16 fmed']");
		userName.sendKeys(appUsername);
		passWord.sendKeys(appPassword);
		signInButton.click();
	}
	
	
}
