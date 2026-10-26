package utility;

import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Browser.NewContextOptions;

public class BaseTest extends ListenrsLogic
{
	
	@Parameters("engine")
	@BeforeMethod
	public void launch(String nameofSearchEngine)
	{
		if(nameofSearchEngine.equals("chrome"))
		{
		playwright =     Playwright.create();
		browser =        playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		browsercontext= browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Video"+dateFormat)));
		page=            browsercontext.newPage();
		}
		if(nameofSearchEngine.equals("webkit"))
		{
		playwright =     Playwright.create();
		browser =        playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
		browsercontext= browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Video"+dateFormat)));
		page=            browser.newPage();
		}
		if(nameofSearchEngine.equals("firefox"))
		{
		playwright =     Playwright.create();
		browser =        playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
		browsercontext= browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Video"+dateFormat)));
		page=            browser.newPage();
		}
		page.navigate("https://www.amazon.in");
		
	}
	
	
	@AfterMethod
	
	public void quit()
	{
		
		browsercontext.close();
		browser.close();
	}	
}
