package utility;

import java.nio.file.Paths;
import java.util.Date;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

public class ListenrsLogic implements ITestListener{
	//public static Playwright playwright;
	//public static Browser browser;
	//public static BrowserContext browsercontext;
	//public static Page page;
	Date d1 = new Date();
	//System.out.println(d1.getTime());
	Date d2 = new Date(d1.getTime());
	String format = d2.toString();
	String dateFormat = format.replace(":", "");
	
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ITestListener.super.onTestSuccess(result);
		// Logic should start from here
				
		BaseTest.page.screenshot(new ScreenshotOptions().setPath(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Screenshot\\Pass\\"+result.getName() + dateFormat + ".png")));
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		ITestListener.super.onTestFailure(result);
		// Logic should start from here
		//commenting to found out if targetclosed error is due to this or not?
		BaseTest.page.screenshot(new ScreenshotOptions().setPath(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Screenshot\\Fail\\"+result.getName() + dateFormat + ".png")));
	//	browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Video"+result.getName())));
	
	}

}
