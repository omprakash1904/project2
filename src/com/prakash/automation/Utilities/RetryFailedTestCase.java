package com.prakash.automation.Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCase implements IRetryAnalyzer
{
int count=0;
int countMax=4;
	@Override
	public boolean retry(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE&&count<=countMax)
		{
			try {
				Thread.sleep(3000);
				System.out.println("count :"+count+".executing test case :"+result.getName());
				count++;
				return true;
			} catch (InterruptedException e) {
				e.toString();
			}
		}
		return false;
	}

}
