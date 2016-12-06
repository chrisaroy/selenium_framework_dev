package testCases;

import org.testng.annotations.Test;

import appToolsQA.tools_qa_site;
import config.Properties;
import support.utilities.Confirm;
import support.utilities.Support;
import support.utilities.TestLog;

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class tst_05_new_windows_and_alerts {
	/********************************************
	 * Copyright (C) 2016 - All Rights Reserved
	 * 
	 * Test Name: Test Template
	 * 
	 * Description: <test description>
	 * @return 
	 */
	static{
		Properties.manual_test_version = "1.0";
		
		Properties.test_summary = "<Test Summary>";
		
		Properties.requirements = "123, 456";
		
		Properties.manual_test_time = 45;
	}
	//*******************************************
	
	private static WebDriver driver = null;
	String website = "http://toolsqa.com/automation-practice-switch-windows/";

	@BeforeClass
	public void beforeClass() {
		/**
		 * Set up logging and driver before running tests.
		 * 
		 * @param: None
		 * @return: None
		 */
		String full_class_name = MethodHandles.lookup().lookupClass().getName();
		Support.setupLogging(full_class_name.substring(full_class_name.lastIndexOf('.')+1));
	
		TestLog.startTest();
		Support.setGeckoDriverProperty();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
  
	@Test(priority=1)
	public void test_case_Alerts() throws InterruptedException, IOException {
		/*
		 * Step <n>: <Desc>
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		// Test code here
		TestLog.info("Log on to web site");
		driver.get(website);
		tools_qa_site tools_qa = new tools_qa_site();
		
		// Manual
		tools_qa.practice_switch_windows.alert_box_button.click_button(driver);
		
		Alert alert_box = tools_qa.practice_switch_windows.alert_box_button_select(driver);
		String actual_alert_text = alert_box.getText();
		String expected_alert_text = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
		Confirm.verify(driver, "Check alert text", actual_alert_text, expected_alert_text);
		
		alert_box.accept();
		
		Alert timing_alert = tools_qa.practice_switch_windows.timing_alert_button_select(driver);
		timing_alert.accept();
		
		TestLog.endTestStep();
	}

	@Test(priority=2)
	public void test_case_browser_windows() throws IOException, InterruptedException {
		/*
		 * Step <n>: <Desc>
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		tools_qa_site tools_qa = new tools_qa_site();
		
		// Click message box button and close.
		tools_qa.practice_switch_windows.new_message_window_button.click_button(driver); // TODO: MOVE
		// Switch context
		
		// Close window
		
		// Switch context back
		
		
		// Click new window
		tools_qa.practice_switch_windows.new_browser_window_button.click_button(driver); // TODO: MOVE
		// Switch context
		
		// perform 1 action
		
		// Close and switch back
		
		
		// Click for new tab
		tools_qa.practice_switch_windows.new_browser_tab_button.click_button(driver);  // TODO: MOVE
		
		// Switch context
		
		// perform 1 action
		
		// Close and switch back context to initial tab
		
		
		TestLog.endTestStep();
	}

	@AfterClass
	public void afterClass() {
		/*
		 * Close site and cleanup after tests.
		 * 
		 * @param: None
		 * @return: None
		 */
		driver.close();
		driver.quit();
		TestLog.endTest();
	}

}
