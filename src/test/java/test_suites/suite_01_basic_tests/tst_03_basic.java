package test_suites.suite_01_basic_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import appToolsQA.tools_qa_site;
import appToolsQA.storeDemo.store_demo_site;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import support.utilities.Confirm;
import support.utilities.Support;
import support.utilities.TestLog;
import support.utilities.Wait;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

public class tst_03_basic {
	
	private static WebDriver driver = null;
	
	@BeforeClass
	public void beforeClass() {
		String full_class_name = MethodHandles.lookup().lookupClass().getName();
		Support.setupLogging(full_class_name.substring(full_class_name.lastIndexOf('.')+1));
		
		TestLog.startTest();
		Support.setGeckoDriverProperty();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}	
	
	@Test(priority=1)
	public void test_case_home_page() throws InterruptedException, IOException {
		TestLog.startTestStep();
		
		TestLog.info("Log on to website");
		String website = "http://www.toolsqa.com";
		driver.get(website);
		
		tools_qa_site tools_qa = new tools_qa_site();
		store_demo_site store_site = tools_qa.home_page.top_link_bar.e_commerce_link_select(driver);
		
		TestLog.info("At Home page.");
		String expected_title_page = "ONLINE STORE | Toolsqa Dummy Test site";
		String actual_title_page = driver.getTitle();
		Confirm.assertCheck(driver, "Check the Title Page", actual_title_page, expected_title_page);
		
		Wait.sleep(2, "Wait after checking title page");
		Boolean expected_s_cart_enabled = false;
		Boolean actual_s_cart_enabled = store_site.home_page.shopping_cart_button.is_enabled(driver);
		Confirm.verify(driver, "Check that shopping cart is disabled - Test Fail", actual_s_cart_enabled, expected_s_cart_enabled, "req_123");	

		TestLog.endTestStep();
	}
	
	@Test(priority=2)
	public void test_case_login() throws InterruptedException, IOException {
		TestLog.startTestStep();
		store_demo_site store_site = new store_demo_site();
		
		TestLog.info("Select link to go to Account link.");
		store_site.home_page.my_account_link.click_link(driver);	
		Wait.sleep(3, "Wait after selecting link.");
				
		TestLog.info("Enter UN and Pwd");
		store_site.login_page.user_name_textbox.enter_text(driver, "Porsche");
		store_site.login_page.password_textbox.enter_text(driver, "123456");

		Boolean expected_login_enabled = true;
		Boolean actual_login_enabled = store_site.login_page.login_button.is_enabled(driver);
		Confirm.verify(driver, "Check that the login button is enabled", actual_login_enabled, expected_login_enabled, "req_123, req_456", false);
		
		TestLog.info("Log on");
		store_site.login_page.login_button.click_button(driver);	
		Wait.sleep(3);
		TestLog.endTestStep();
	}	

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
		TestLog.endTest();
	}
}
