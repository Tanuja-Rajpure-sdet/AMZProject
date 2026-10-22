package amazontest.AmzProject;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByLabelOptions;

public class LoginPage {
	private Page page;
	private Locator username;
	private Locator continuebutton;
	private Locator password;
	private Locator signin;
	public LoginPage(Page page)
	{
		this.page=page;
		username=	page.getByLabel("Enter mobile number or email", new GetByLabelOptions().setExact(true));
		continuebutton=	page.locator("//input[@class='a-button-input']");
		password=	page.locator("//input[@name='password']");
		signin=	page.locator("#signInSubmit");
	}
	
	public void enterUsername(String UN)
	{
		//here we need to perfrom action
		username.fill(UN);
	}public void clickOnContinue()
	{
		//here we need to perfrom action
		continuebutton.click();
	}public void enterpassword(String pwd)
	{
		//here we need to perfrom action
		password.fill(pwd);	}
	public void clickOnSigin()
	{
		//here we need to perfrom action
		signin.click();
	}
}
