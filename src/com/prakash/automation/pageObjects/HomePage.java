package com.prakash.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prakash.automation.Base.ActionEnginePom;

public class HomePage extends ActionEnginePom {
	@FindBy(xpath="//span[text()='Electronics']")
	public WebElement electronics;
	
	@FindBy(xpath="//span[text()='Mobiles']")
	public WebElement mobiles;
	
	
}
