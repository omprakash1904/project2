package com.prakash.automation.Base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.prakash.automation.Utilities.ExceptionHandle;
import com.relevantcodes.extentreports.model.ExceptionInfo;

public class ActionEnginePom extends ActionEngine{
	
	public static Actions action;
	public static void sendkeys(String locType,WebElement element,String testdata)
	{
		if(element.isDisplayed()&&element.isEnabled())
		{
		switch (locType) {
		case "id":
			if(locType.equalsIgnoreCase("id"))
				element.sendKeys(testdata);
			break;
		case "className":
			if(locType.equalsIgnoreCase("className"))
				element.sendKeys(testdata);
			break;
		case "name":
			if(locType.equalsIgnoreCase("name"))
				element.sendKeys(testdata);
			break;
		case "linkText":
			if(locType.equalsIgnoreCase("linkText"))
				element.sendKeys(testdata);
			break;
		case "partialLinkText":
			if(locType.equalsIgnoreCase("partialLinkText"))
				element.sendKeys(testdata);
			break;
		case "xpath":
			if(locType.equalsIgnoreCase("xpath"))
				element.sendKeys(testdata);
			break;
		case "cssSelector":
			if(locType.equalsIgnoreCase("cssSelector"))
				element.sendKeys(testdata);
			break;
		default:
			if(locType.equalsIgnoreCase("tagName"))
				element.sendKeys(testdata);
			break;
			}
		}
		else
		System.out.println("no such element Exception");
	}
	
	
	public static void click(String locType,WebElement element)
	{
		if(element.isDisplayed()&&element.isEnabled())
		{
		switch (locType) {
		case "id":
			if(locType.equalsIgnoreCase("id"))
				element.click();
			break;
		case "className":
			if(locType.equalsIgnoreCase("className"))
				element.click();
			break;
		case "name":
			if(locType.equalsIgnoreCase("name"))
				element.click();
			break;
		case "linkText":
			if(locType.equalsIgnoreCase("linkText"))
				element.click();
			break;
		case "partialLinkText":
			if(locType.equalsIgnoreCase("partialLinkText"))
				element.click();
			break;
		case "xpath":
			if(locType.equalsIgnoreCase("xpath"))
				element.click();
			break;
		case "cssSelector":
			if(locType.equalsIgnoreCase("cssSelector"))
				element.click();
			break;
		default:
			if(locType.equalsIgnoreCase("tagName"))
				element.click();
			break;
			}
		}
		else
		System.out.println("no such element Exception");
		
	}
	
	public static void MoveToElementPom(WebElement element)
	{
		action=new Actions(getWebDriver());
		if(element.isDisplayed()&&element.isEnabled())
		{
			action.moveToElement(element);
		}
		else
			System.out.println("element is not displayed && is not enabled");	
	}
	public static void EnterUrl(String url)
	{
		getWebDriver().get(url);
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
	}
}
