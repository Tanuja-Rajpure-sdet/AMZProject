package utility;

import java.nio.file.Paths;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Browser.NewContextOptions;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BaseTest extends ListenrsLogic
{
	public static Playwright playwright;
	public static Browser browser;
	public static BrowserContext browsercontext;
	public static Page page;
	@Parameters("engine")
	@BeforeMethod
	public void launch(@Optional("chrome")String nameofSearchEngine)
	{
		if(nameofSearchEngine.equals("chrome"))
		{
		playwright =     Playwright.create();
		browser =        playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
		browsercontext= browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Video"+ dateFormat)));
		page=            browsercontext.newPage();
		}
		if(nameofSearchEngine.equals("webkit"))
		{
		playwright =     Playwright.create();
		browser =        playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
		browsercontext= browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Video"+ dateFormat)));
		page=            browsercontext.newPage();
		}
		if(nameofSearchEngine.equals("firefox"))
		{
		playwright =     Playwright.create();
		browser =        playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
		browsercontext= browser.newContext(new NewContextOptions().setRecordVideoDir(Paths.get("C:\\Users\\Anna Rajpure\\eclipse-workspace\\AmzProject\\test-output\\Video"+ dateFormat)));
		page=            browsercontext.newPage();
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
