package testCases;

import org.testng.annotations.Test;
import config.Properties;
import utilities.Confirm;
import utilities.Support;
import utilities.TestLog;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import appToolsQA.tools_qa_site;


public class tst_04_elements {
	/********************************************
	 * Copyright (C) 2016 - All Rights Reserved
	 * 
	 * Test Name: Elements
	 * 
	 * Description: Test elements such as combo box, check box and radio button.
	 * @return 
	 */
	static{
		Properties.manual_test_version = "1.0";
		
		Properties.test_summary = "Test elements such as combo box, check box and radio button.";
		
		Properties.requirements = "123, 456";
		
		Properties.manual_test_time = 45;
	}
	//*******************************************
	
	private static WebDriver driver = null;
	String website = "http://toolsqa.com/automation-practice-form/";

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
	public void test_case_radio_checkbox() throws IOException, InterruptedException {
		/*
		 * Step 1: Check radio buttons and check boxes
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		// Test code here
		TestLog.info("Log on to web site");
		driver.get(website);
		
		// Radio Button
		tools_qa_site tools_site = new tools_qa_site();
		tools_site.practice_form_page.first_name_textbox.enter_text(driver, "FRED");
		
		tools_site.practice_form_page.male_radio_button.click(driver);
		Boolean radio_button_selected_actual = tools_site.practice_form_page.male_radio_button.is_selected(driver);
		Confirm.verify(driver, "Male Radio button selected", radio_button_selected_actual, true);
		
		tools_site.practice_form_page.female_radio_button.click(driver);
		
		// Check box
		Boolean cb_checked = tools_site.practice_form_page.manual_tester_checkbox.is_checked(driver);
		Confirm.verify(driver, "checkbox not checked", cb_checked, false);
		
		tools_site.practice_form_page.manual_tester_checkbox.check(driver);
		cb_checked = tools_site.practice_form_page.manual_tester_checkbox.is_checked(driver);
		Confirm.verify(driver, "checkbox not checked", cb_checked, true);
		
		TestLog.endTestStep();
	}

	@Test(priority=2)
	public void test_case_combo_box() throws IOException, InterruptedException {
		/*
		 * Step <n>: <Desc>
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		// Test code here
		/*
		TestLog.info("At Home page.");
		String expected_title_page = "ONLINE STORE | Toolsqa Dummy Test site";
		String actual_title_page = driver.getTitle();
		Confirm.assertCheck(driver, "Check the Title Page", actual_title_page, expected_title_page);
		*/
		
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
