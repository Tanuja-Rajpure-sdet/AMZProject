package amazontest.AmzProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage 
{
	private Page page;
	private Locator accountAndList;
	private Locator signin;
	private Locator signout;
	public HomePage(Page page)
	{
		this.page=page;
		accountAndList=	page.locator("//span[@class='nav-line-2 ']");
		signin=	page.locator("#nav-flyout-ya-signin");
		signout= page.locator("#nav-item-signout");
	}
	public void hoverOverOnAccountAndList()
	{
		page.waitForTimeout(2000);
		accountAndList.hover();
	}
	public void clickOnSigin()
	{
		//here we need to perfrom action
		signin.click();
	}
	public void clickOnSignout()
	{
		//here we need to perfrom action
		signout.click();
	}

}
