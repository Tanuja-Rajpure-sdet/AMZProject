package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{
	int initialCount = 0;
	int retryCount = 1; // max 1 or 2 time is enough
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(initialCount < retryCount)
		{
			initialCount++;
			return true; // means let's retry
		}
		
		return false; // If retry method return false- means don't retry at all
		// If retry method returns true- means keep retrying infinite times
	}

}
