package testCases;

import org.testng.annotations.Test;
import config.Properties;
import support.utilities.Confirm;
import support.utilities.Support;
import support.utilities.TestLog;

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import appToolsQA.Practice_Form_Page;
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
	//String website = "http://toolsqa.com/automation-practice-form/";
	String website = "http://toolsqa.com";

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
		
		tools_qa_site tools_qa = new tools_qa_site();
		Practice_Form_Page practice_form = tools_qa.home_page.top_link_bar.practice_form_link_select(driver);
		
		practice_form.first_name_textbox.enter_text(driver, "Jonesey");
		
		// Radio Button
		practice_form.female_radio_button.click(driver);
		Boolean rdo_btn_selected = practice_form.female_radio_button.is_selected(driver);
		Confirm.verify(driver, "Female radio button selected", rdo_btn_selected, true);
		
		practice_form.male_radio_button.click(driver);
		
		// Check box
		Boolean cb_checked = practice_form.manual_tester_checkbox.is_checked(driver);
		Confirm.verify(driver, "checkbox not checked", cb_checked, false);
		
		practice_form.manual_tester_checkbox.check(driver);
		cb_checked = practice_form.manual_tester_checkbox.is_checked(driver);
		Confirm.verify(driver, "check box not checked", cb_checked, true);
		
		TestLog.endTestStep();
	}

	@Test(priority=2)
	public void test_case_combo_box() throws IOException, InterruptedException {
		/*
		 * Step 2: Tests related to combo box element.
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		tools_qa_site tools_site = new tools_qa_site();

		// by index
		tools_site.practice_form_page.continents_combo_box.select_item_by_index(driver, 2);
		
		// get selected item
		String selected_item = tools_site.practice_form_page.continents_combo_box.get_selected_item(driver);
		Confirm.verify(driver, "Check selected item.", selected_item, "Europe");
		
		// by value
		//tools_site.practice_form_page.continents_combo_box.select_item_by_value(driver, "Australia"); // This needs to use option value and not text.
		
		// by text
		tools_site.practice_form_page.continents_combo_box.select_item_by_text(driver, tools_site.practice_form_page.CONTINENTS_AFRICA);
		tools_site.practice_form_page.continents_combo_box.select_item_by_text(driver, tools_site.practice_form_page.CONTINENTS_NORTH_AMERICA);
		
		// get all items
		List<String> combo_box_list = tools_site.practice_form_page.continents_combo_box.get_all_items(driver);
		int sizeOfList = combo_box_list.size();
		Confirm.verify(driver, "Check size of combobox list", sizeOfList, 7);
		
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
