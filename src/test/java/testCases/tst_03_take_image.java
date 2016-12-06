package testCases;

import org.testng.annotations.Test;

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


public class tst_03_take_image {
	
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

	@Test
	public void test_case_take_image() throws InterruptedException, IOException {
		TestLog.info("Log on to website");
		String website = "http://www.store.demoqa.com";
		driver.get(website);
		Wait.sleep(2, "Wait before taking image");
		
		Support.takeImage(driver);
		TestLog.info("After take image");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
		TestLog.endTest();		
	}
	
}
