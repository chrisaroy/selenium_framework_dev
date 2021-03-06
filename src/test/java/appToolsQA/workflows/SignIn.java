package appToolsQA.workflows;

import org.openqa.selenium.WebDriver;

import appToolsQA.storeDemo.store_demo_site;
import support.utilities.TestLog;

/**
 * Sign In class - method(s) for signing in.
 * @author Chris
 */
public class SignIn {
	
	/**
	 * Login method.  Selects link, enters user name and password, and clicks the Login button.
	 * @param driver - web driver
	 * @param user_name - Username to be entered into user name text box.
	 * @param password - Password to be entered into password text box.
	 * @throws InterruptedException
	 */
	public static void LogIn(WebDriver driver, String user_name, String password) throws InterruptedException{
		TestLog.info("Start SignIn");
		store_demo_site store_site = new store_demo_site();
		
		TestLog.info("Select link");
		store_site.home_page.my_account_link.click_link(driver);
		
		TestLog.info("Enter UN and Pwd");
		store_site.login_page.user_name_textbox.enter_text(driver, user_name);
		store_site.login_page.password_textbox.enter_text(driver, password);

		Boolean login_enabled;
		login_enabled = store_site.login_page.login_button.is_enabled(driver);
		TestLog.info("Login enabled is: " + String.valueOf(login_enabled));
		
		TestLog.info("Log on");
		store_site.login_page.login_button.click_button(driver);	
		Thread.sleep(4000);
		TestLog.info("End SignIn");
	}
}
