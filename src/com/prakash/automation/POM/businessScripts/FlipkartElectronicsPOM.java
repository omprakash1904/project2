package com.prakash.automation.POM.businessScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.prakash.automation.Base.ActionEnginePom;
import com.prakash.automation.Utilities.PojoUtilities;
import com.prakash.automation.pageObjects.HomePage;
import com.relevantcodes.extentreports.LogStatus;

public class FlipkartElectronicsPOM extends ActionEnginePom {
	@Test
	public static void moduleElectronics() throws IOException, InterruptedException
	{
		HomePage electronics=PageFactory.initElements(getWebDriver(), HomePage.class);
		MoveToElementPom(electronics.electronics);
		et.log(LogStatus.INFO, "Moved to --"+electronics.electronics.getText());
		PojoUtilities.getAppData().setProperty("electronics", getWebDriver().findElement(By.xpath(PojoUtilities.getObjRepoPropertiesReusableObject().getProperty("Electronics_xpath"))).getText());
		click("xpath", electronics.mobiles);
		et.log(LogStatus.INFO, "Moved to --"+electronics.mobiles.getText());
	}

}
