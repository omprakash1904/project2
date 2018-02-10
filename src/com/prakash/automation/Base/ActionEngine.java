package com.prakash.automation.Base;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.prakash.automation.Utilities.ExceptionHandle;
import com.prakash.automation.Utilities.PojoUtilities;
import com.relevantcodes.extentreports.model.ExceptionInfo;

public class ActionEngine extends DriverEngine{
	private static Alert alert;

	public static void EnterUrl(String url)
	{
		getWebDriver().get(url);
	}
	public static void sendKeys(String locType,String locMech,String testData)
	{
		switch (locType) {
		case "id":
			if(locType.equalsIgnoreCase("id"))
				getWebDriver().findElement(By.id(locMech)).sendKeys(testData);
			break;
		case "className":
			if(locType.equalsIgnoreCase("className"))
				getWebDriver().findElement(By.className(locMech)).sendKeys(testData);
			break;
		case "name":
			if(locType.equalsIgnoreCase("name"))
				getWebDriver().findElement(By.name(locMech)).sendKeys(testData);
			break;
		case "linkText":
			if(locType.equalsIgnoreCase("linkText"))
				getWebDriver().findElement(By.linkText(locMech)).sendKeys(testData);
			break;
		case "partialLinkText":
			if(locType.equalsIgnoreCase("partialLinkText"))
				getWebDriver().findElement(By.partialLinkText(locMech)).sendKeys(testData);
			break;
		case "tagName":
			if(locType.equalsIgnoreCase("tagName"))
					getWebDriver().findElement(By.tagName(locMech)).sendKeys(testData);
			break;
		case "xpath":
			if(locType.equalsIgnoreCase("xpath"))
				getWebDriver().findElement(By.xpath(locMech)).sendKeys(testData);
			break;

		case "cssSelector":
			if(locType.equalsIgnoreCase("cssSelector"))
				getWebDriver().findElement(By.cssSelector(locMech)).sendKeys(testData);
			break;
		}
	}
	
	public static void click(String locType,String locMech)
	{
		switch (locType) {
		case "id":
			if(locType.equalsIgnoreCase("id"))
				getWebDriver().findElement(By.id(locMech)).click();
			break;
		case "className":
			if(locType.equalsIgnoreCase("className"))
				getWebDriver().findElement(By.className(locMech)).click();
			break;
		case "name":
			if(locType.equalsIgnoreCase("name"))
				getWebDriver().findElement(By.name(locMech)).click();
			break;
		case "linkText":
			if(locType.equalsIgnoreCase("linkText"))
				getWebDriver().findElement(By.linkText(locMech)).click();
			break;
		case "partialLinkText":
			if(locType.equalsIgnoreCase("partialLinkText"))
				getWebDriver().findElement(By.partialLinkText(locMech)).click();
			break;
		case "tagName":
			if(locType.equalsIgnoreCase("tagName"))
					getWebDriver().findElement(By.tagName(locMech)).click();
			break;
		case "xpath":
			if(locType.equalsIgnoreCase("xpath"))
		 		getWebDriver().findElement(By.xpath(locMech)).click();
			break;

		default:
			if(locType.equalsIgnoreCase("cssSelector"))
				getWebDriver().findElement(By.cssSelector(locMech)).click();
			break;
		}	
	}
	
	public static void dropDowns(WebElement element,String locType,String testData,int index)
	{
		Select select=new Select(element);
		if(element.isDisplayed()&&element.isEnabled())
		{
			switch (locType) {
			case "value":
				if(locType.equalsIgnoreCase("value"))
					select.selectByValue(testData);
				break;
			case "visibleText":
				if(locType.equalsIgnoreCase("visibleText"))
					select.selectByVisibleText(testData);
				break;
			case "index":
				if(locType.equalsIgnoreCase("index"))
					select.selectByIndex(index);
				break;

			default:
				System.out.println("Given data is inCorrect");
				break;
			}
		}
		else
			System.out.println("No suchElement Exception");
	}
	public static void moveToElement(WebElement element)
	{
		Actions action=new Actions(getWebDriver());
		
		if(element.isDisplayed()&&element.isEnabled())
			action.moveToElement(element).build().perform();
		else
			System.out.println("No such Element Exception");
	}
	public static Alert getAlert()
	{
		return alert=getWebDriver().switchTo().alert();
	}
	public static void alertsSendKeys(String testData)
	{
		getAlert().sendKeys(testData);
	}
	public static void alertsAccept()
	{
		getAlert().accept();
	}
	public static void alertDismiss()
	{
		getAlert().dismiss();
	}
	
	public static void displayedOrNot(String expected,String actualDisplayed) throws IOException, ExceptionHandle
	{
		if(expected.equalsIgnoreCase(actualDisplayed))
		{
			PojoUtilities.getAppData().setProperty(expected, actualDisplayed);
		}
		else
		{
			throw new ExceptionHandle("element not selected");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
	
}
