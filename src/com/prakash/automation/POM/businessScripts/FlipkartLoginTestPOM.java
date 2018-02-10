package com.prakash.automation.POM.businessScripts;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.prakash.automation.Base.ActionEngine;
import com.prakash.automation.Base.ActionEnginePom;
import com.prakash.automation.Utilities.PojoUtilities;
import com.prakash.automation.pageObjects.LoginPage;
import com.prakash.automation.pageObjects.LoginPage;
import com.relevantcodes.extentreports.LogStatus;

public class FlipkartLoginTestPOM extends ActionEnginePom {
	@Test
	public static void login() throws IOException, InterruptedException
	{
		getWebDriver().get(PojoUtilities.getConfigPropertiesReusablesObject().getProperty("Url"));
		et.log(LogStatus.INFO, PojoUtilities.getConfigPropertiesReusablesObject().getProperty("Url")+"--Url is entered");
		LoginPage pf=PageFactory.initElements(getWebDriver(), LoginPage.class);
		
		//pf.username.sendKeys("omprakash");
		//pf.username.sendKeys(PojoUtilities.getConfigPropertiesReusablesObject().getProperty("userName"));
		sendkeys("cssSelector", pf.username, PojoUtilities.getConfigPropertiesReusablesObject().getProperty("userName"));
		et.log(LogStatus.INFO, PojoUtilities.getConfigPropertiesReusablesObject().getProperty("userName")+"--Username is entered");
		//pf.pass.sendKeys("9912479132");
		//pf.pass.sendKeys(PojoUtilities.getConfigPropertiesReusablesObject().getProperty("pass"));
		sendkeys("cssSelector", pf.pass, PojoUtilities.getConfigPropertiesReusablesObject().getProperty("pass"));
		et.log(LogStatus.INFO, PojoUtilities.getConfigPropertiesReusablesObject().getProperty("pass")+"--Password is entered");
		moveToElement(pf.login);
		Thread.sleep(3000);
		et.log(LogStatus.INFO, "Moved to element--"+pf.login.getText());
		click("cssSelector", pf.close);
	}

}
