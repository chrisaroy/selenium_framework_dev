package appWorkflows;

import org.openqa.selenium.WebDriver;

import appStoreDemo.store_demo_site;
import utilities.TestLog;

public class SignIn {
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
