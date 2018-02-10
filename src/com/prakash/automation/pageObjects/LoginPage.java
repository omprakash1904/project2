package com.prakash.automation.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.prakash.automation.Base.ActionEnginePom;
import com.prakash.automation.Base.DriverEngine;

public class LoginPage extends ActionEnginePom {

	@FindBy(css="input[class='_2zrpKA']")
	public WebElement username;
	
	@FindBy(css="input[class='_2zrpKA _3v41xv']")
	public WebElement pass;
	
	@FindBy(css="button[class='_2AkmmA _1LctnI _7UHT_c']")
	public WebElement login;
	
	@FindBy(css="button[class='_2AkmmA _29YdH8']")
	public WebElement close;
	
}
