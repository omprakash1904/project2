 package com.prakash.automation.Utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.sql.DriverAction;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public interface ScreenShotUtility {
	public static String takeScreenShot(WebDriver d,String imgName) throws IOException {
		TakesScreenshot t=(TakesScreenshot)d;
		File file=t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"\\ScreenShots\\"+imgName+".jpeg"));
		return imgName;
	}

}
