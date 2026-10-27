package amazontest.AmzProject;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.microsoft.playwright.Locator;

import utility.BaseTest;
import utility.ListenrsLogic;
import utility.RetryLogic;
@Listeners(ListenrsLogic.class)
public class TestCase2_LoginToAmazonandLogout  extends BaseTest
{

	@Test(retryAnalyzer=RetryLogic.class)
	public void withValidCredentailsandLogout()
	{
	HomePage homepage=new HomePage(page);
		
		homepage.hoverOverOnAccountAndList();
		homepage.clickOnSigin();
//		page.wait(3000);
		
		LoginPage loginpage=new LoginPage(page);
		
		loginpage.enterUsername("tdkamthe@gmail.com");
		loginpage.clickOnContinue();
																																																			loginpage.enterpassword("Abh1dny@2706");
		loginpage.clickOnSigin();
		assertThat(page).hasTitle("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Locator searchText= page.getByLabel("Search Amazon.in");
		assertThat(searchText).isVisible();
	
		homepage.hoverOverOnAccountAndList();
		homepage.clickOnSignout();
		Locator signOutPage =page.locator("//div[@id='claim-collection-container']/h1");
		assertThat(signOutPage).hasText("Sign in or create account");
		
	}
}
