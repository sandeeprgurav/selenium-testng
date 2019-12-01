package com.gmail.generics;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage 
{
	public WebDriver driver = null;
	public Logger log = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyTitle(String exp_title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		String act_title=null;
		try
		{
			wait.until(ExpectedConditions.titleIs(exp_title));
			act_title=driver.getTitle();
			Assert.assertEquals(act_title, exp_title);
			log.info(act_title+" and "+exp_title+" matched.");
		}
		catch(Exception e)
		{
			log.error(act_title+" and "+exp_title+" are not matched.");
		}
	}
	
	public void verifyElementPresent(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(ele));
			log.info(ele +" found");
		}
		catch (Exception e) 
		{
			log.error(ele+" not found");
		}
	}
	
	public void mouseHover(WebDriver driver, WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, 3);
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			log.info("Mouse hovered on "+ele);
		}
		catch(Exception e)
		{
			log.error("Unable to mouse hover on "+ele);
		}
		
	}
}