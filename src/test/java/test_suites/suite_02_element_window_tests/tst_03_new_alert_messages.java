package test_suites.suite_02_element_window_tests;

import org.testng.annotations.Test;
import appToolsQA.tools_qa_site;
import appToolsQA.Practice_Switch_Windows_Page;
import config.Properties;
import support.utilities.Confirm;
import support.utilities.Support;
import support.utilities.TestLog;
import support.utilities.Wait;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class tst_03_new_alert_messages {
	/********************************************
	 * Copyright (C) 2016 - All Rights Reserved
	 * 
	 * Test Name: New windows and alerts
	 * 
	 * Description: Testing of new windows and alerts.  Main focus
	 * 			    is on switching the driver.
	 * @return 
	 */
	static{
		Properties.manual_test_version = "1.0";
		
		Properties.test_summary = "Testing of new windows and alerts.";
		
		Properties.requirements = "123, 456";
		
		Properties.manual_test_time = 45;
	}
	//*******************************************
	
	private static WebDriver driver = null;
	String website = "http://www.toolsqa.com";

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
		 * Step 1: Testing of alerts.
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		TestLog.info("Log on to web site");
		driver.get(website);
		tools_qa_site tools_qa = new tools_qa_site();
		Practice_Switch_Windows_Page practice_switch = tools_qa.home_page.top_link_bar.practice_form_switch_link_select(driver);
				
		Wait.sleep(2);
		
		Alert alert_box = practice_switch.alert_box_button_select(driver);
		String actual_alert_text = alert_box.getText();
		String expected_alert_text = "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.";
		Confirm.verify(driver, "Check alert text", actual_alert_text, expected_alert_text);
		alert_box.accept();
		
		Alert timing_alert = practice_switch.timing_alert_button_select(driver);
		Wait.sleep(2);
		timing_alert.accept();
		
		TestLog.endTestStep();
	}

	@Test(priority=2)
	public void test_case_new_message() throws IOException, InterruptedException {
		/*
		 * Step 2: Testing of new messages.
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		Practice_Switch_Windows_Page practice_switch = new Practice_Switch_Windows_Page();
		
		// Click message box button and close.
		practice_switch.new_message_window_select(driver);
		support.utilities.Wait.sleep(2, "Wait before closing window");
		practice_switch.new_message_window_close(driver);	
		
		// Check that focus is back.
		Alert alert_box = practice_switch.alert_box_button_select(driver);
		alert_box.accept();
		
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
