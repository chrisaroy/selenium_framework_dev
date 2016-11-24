package testCases;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestLog;
import utilities.Confirm;
import utilities.Support;

public class tst_01_quick_test {
	
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
	public void test_case_basic_step() throws IOException, InterruptedException {
		TestLog.startTestStep();
		
		TestLog.info("Log on to website");
		String website = "http://www.store.demoqa.com";
		driver.get(website);
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "ONLINE STORE | Toolsqa Dummy Test site";
		Confirm.assertCheck(driver, "Check Title", actualTitle, expectedTitle);
		Support.sleep(4, "Wait after test");
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
		driver.quit();
		TestLog.endTest();
	}
}
