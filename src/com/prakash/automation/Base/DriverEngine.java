package com.prakash.automation.Base;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.prakash.automation.Utilities.ScreenShotUtility;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DriverEngine {
	private static WebDriver d;
	public static ExtentReports er;
	public static ExtentTest et;
	public static WebDriver getWebDriver()
	{
		return d;
	}
	@Parameters({"browser"})
	@BeforeSuite
	public void openBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.geckodriver.driver", "E:\\WebDrivers\\geckodriver.exe");
			d=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\WebDrivers\\chromedriver.exe");
			d=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "E:\\WebDrivers\\IEDriverServer.exe");
			d=new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.opera.driver", "E:\\WebDrivers\\operadriver.exe");
			d=new OperaDriver();
		}
		initiate();
	}
	private static void initiate()
	{
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		d.manage().deleteAllCookies();
	}
	@BeforeTest
	public static void ExtentReport()
	{
		er=new ExtentReports(System.getProperty("user.dir")+"\\Reports\\FlipkartReports.html");
		
	}
	@BeforeMethod
	public static void beforeMethod(Method method)
	{
		et=er.startTest(method.getName());
		et.log(LogStatus.INFO, method.getName()+"Test is started");
	}
	@AfterMethod
	public static void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			et.log(LogStatus.FAIL, result.getThrowable());
			et.log(LogStatus.FAIL, result.toString());
			et.log(LogStatus.FAIL, "Find the ScreenShot"+et.addScreenCapture(ScreenShotUtility.takeScreenShot(getWebDriver(), result.getName())));
		}
	}
	@AfterClass
	public static void EndTest()
	{
		er.endTest(et);
		er.flush();
		
	}
	@AfterTest
	public static void reTest()
	{
		/*List<String> list=new ArrayList<String>();
		list.add(System.getProperty("user.dir")+"\\test-output\\testng-failed.xml");
		TestNG testng=new TestNG();
		testng.setTestSuites(list);
		testng.run();*/
		
	}
	@AfterSuite
	public static void closeBrowser()
	{
		if(d!=null)
			d.close();
		else
			System.out.println("driver is pointing to null");
	}
	
}
