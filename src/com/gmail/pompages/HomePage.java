package com.gmail.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gmail.generics.BasePage;

public class HomePage extends BasePage
{
	@FindBy(xpath="//div[text()='Compose']")
	private WebElement composeButton;
	
	@FindBy(name="to")
	private WebElement toField;
	
	@FindBy(name="subjectbox")
	private WebElement subjectField;
	
	@FindBy(xpath="//div[@aria-label='Message Body']")
	private WebElement bodyField;
	
	@FindBy(xpath="//div[text()='Send']")
	private WebElement sendButton;
	
	@FindBy(xpath="//span[@class='gb_cb gbii']")
	private WebElement profileButton;
	

	@FindBy(id="gb_71")
	private WebElement signoutButton;
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);	
	}
	
	public void clickComposeButton()
	{
		try
		{
			verifyElementPresent(composeButton);
			composeButton.click();
			log.info(" Button is clicked "+composeButton);
		}
		catch(Exception e)
		{
			log.error("Unable to click "+composeButton+e);
		}
	}

	
	public void enterTo(String to)
	{
		try
		{
			verifyElementPresent(toField);
			toField.sendKeys(to);
			log.info("username is "+toField);
		}
		catch(Exception e)
		{
			log.error("Unable to enter "+toField+e);
		}
	}
	
	public void enterSubject(String subject)
	{
		try
		{
			verifyElementPresent(subjectField);
			subjectField.sendKeys(subject);
			log.info("password is "+subjectField);
		}
		catch(Exception e)
		{
			log.error("Unable to enter "+subject+e);
		}
	}
	
	public void enterBody(String body)
	{
		try
		{
			verifyElementPresent(bodyField);
			bodyField.sendKeys(body);
			log.info("password is "+bodyField);
		}
		catch(Exception e)
		{
			log.error("Unable to enter "+body+e);
		}
	}
	
	public void clickSendButton()
	{
		try
		{
			verifyElementPresent(sendButton);
			sendButton.click();
			log.info(" Button is clicked "+sendButton);
		}
		catch(Exception e)
		{
			log.error("Unable to click "+sendButton+e);
		}
	}
	
	public void clickProfileButton()
	{
		try
		{
			verifyElementPresent(profileButton);
			profileButton.click();
			log.info(" Button is clicked "+profileButton);
		}
		catch(Exception e)
		{
			log.error("Unable to click "+profileButton+e);
		}
	}
	
	public void clickSignoutButton()
	{
		try
		{
			verifyElementPresent(signoutButton);
			signoutButton.click();
			log.info(" Button is clicked "+signoutButton);
		}
		catch(Exception e)
		{
			log.error("Unable to click "+signoutButton+e);
		}
	}

}