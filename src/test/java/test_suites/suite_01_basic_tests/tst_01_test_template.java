package test_suites.suite_01_basic_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

import config.Properties;
import support.utilities.Confirm;
import support.utilities.Support;
import support.utilities.TestLog;


public class tst_01_test_template {
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
	public void test_case_eg1() throws InterruptedException, IOException{
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
		
		TestLog.endTestStep();
	}

	@Test(priority=2)
	public void test_case_eg2() throws IOException, InterruptedException {
		/*
		 * Step <n>: <Desc>
		 * 
		 * @param: None
		 * @return: None
		 */
		TestLog.startTestStep();
		
		// Test code here		
		TestLog.info("At Home page.");
		String expected_title_page = "QA Automation Tools Tutorial";
		String actual_title_page = driver.getTitle();
		Confirm.assertCheck(driver, "Check the Title Page", actual_title_page, expected_title_page);
		
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
