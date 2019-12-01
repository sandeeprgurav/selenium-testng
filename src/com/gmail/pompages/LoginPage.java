package com.gmail.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.generics.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(xpath="//input[@id='identifierId']")
	private WebElement email;
	
	@FindBy(xpath="//span[text()='Next']")
	private WebElement nextButton;
	
	@FindBy(name="password")
	private WebElement password;
	
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterEmail(String username)
	{
		try
		{
			verifyElementPresent(email);
			email.sendKeys(username);
			log.info("username is "+username);
		}
		catch(Exception e)
		{
			log.error("Unable to enter "+email+e);
		}
	}
	
	public void enterPassword(String passwd)
	{
		try
		{
			verifyElementPresent(password);
			password.sendKeys(passwd);
			log.info("password is "+passwd);
		}
		catch(Exception e)
		{
			log.error("Unable to enter "+password+e);
		}
	}
	
	public void clickNext()
	{
		try
		{
			verifyElementPresent(nextButton);
			nextButton.click();
			log.info(" Button is clicked "+nextButton);
		}
		catch(Exception e)
		{
			log.error("Unable to click "+nextButton+e);
		}
	}

} 