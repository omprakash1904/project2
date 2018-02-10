package com.prakash.automation.businessScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.prakash.automation.Base.ActionEngine;
import com.prakash.automation.Utilities.PojoUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class FlipkartElectronicsModule extends ActionEngine{

	@Test(dependsOnMethods="login()")
	public static void moduleElectronics() throws IOException, InterruptedException
	{
		/*getWebDriver().get(PojoUtilities.getConfigPropertiesReusablesObject().getProperty("Url"));
		Thread.sleep(3000);*/
		moveToElement(getWebDriver().findElement(By.xpath(PojoUtilities.getObjRepoPropertiesReusableObject().getProperty("Electronics_xpath"))));
		et.log(LogStatus.INFO, "moved to-- "+getWebDriver().findElement(By.xpath(PojoUtilities.getObjRepoPropertiesReusableObject().getProperty("Electronics_xpath"))).getText());
		System.out.println("moved to-- "+getWebDriver().findElement(By.xpath(PojoUtilities.getObjRepoPropertiesReusableObject().getProperty("Electronics_xpath"))).getText());
		PojoUtilities.getAppData().setProperty("electronics", getWebDriver().findElement(By.xpath(PojoUtilities.getObjRepoPropertiesReusableObject().getProperty("Electronics_xpath"))).getText());
	}

}
