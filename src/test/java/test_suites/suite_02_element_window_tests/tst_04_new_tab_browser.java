package test_suites.suite_02_element_window_tests;

import org.testng.annotations.Test;
import appToolsQA.Practice_Switch_Windows_Page;
import appToolsQA.tools_qa_site;
import config.Properties;
import support.utilities.BrowserCommands;
import support.utilities.Support;
import support.utilities.TestLog;
import support.utilities.Wait;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;


public class tst_04_new_tab_browser {
	/********************************************
	 * Copyright (C) 2016 - All Rights Reserved
	 * 
	 * Test Name: New Tab and Browser
	 * 
	 * Description: Tests a new tab and new browser
	 * @return 
	 */
	static{
		Properties.manual_test_version = "1.0";
		
		Properties.test_summary = "Test a new tab and new browser.";
		
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
	public void test_case_new_tab() throws InterruptedException, IOException{
		/*
		 * Step 1: Test new tab.
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		TestLog.info("Log on to web site");
		driver.get(website);
		tools_qa_site tools_qa = new tools_qa_site();
		Practice_Switch_Windows_Page practice_switch = tools_qa.home_page.top_link_bar.practice_form_switch_link_select(driver);

		tools_qa = practice_switch.new_browser_tab_button_select(driver);
		
		tools_qa.home_page.top_link_bar.demo_sites_link.click_link(driver);
		Wait.sleep(2);
		tools_qa.home_page.top_link_bar.demo_sites_link.click_link(driver);
		
		BrowserCommands.closeTab(driver);

		practice_switch.new_message_window_select(driver);
		practice_switch.new_message_window_close(driver);
		
		TestLog.endTestStep();
	}

	@Test(priority=2)
	public void test_case_new_browser() throws IOException, InterruptedException {
		/*
		 * Step 2: Open new window.
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		// Click new window
		tools_qa_site tools_qa = new tools_qa_site();		
		tools_qa.practice_switch_windows.new_browser_window_button_select(driver);
		
		// Perform action on new window.
		BrowserCommands.maximizWindow(driver);
		tools_qa.home_page.top_link_bar.demo_sites_link.click_link(driver);
		Wait.sleep(2);
		tools_qa.home_page.top_link_bar.demo_sites_link.click_link(driver);
		BrowserCommands.closeWindow(driver);
		
		// Perform action on regular window to ensure focus is back.
		tools_qa.practice_switch_windows.new_message_window_select(driver);
		tools_qa.practice_switch_windows.new_message_window_close(driver);
 
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
