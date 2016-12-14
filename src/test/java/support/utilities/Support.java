package support.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import config.Properties;

/**
 * Support class (methods)
 * @author Chris
 */
public class Support {
	
	/**
	 * Sets the gecko driver path.  Gecko driver interacts with the firefox browser.
	 * Note: geckodriver.exe should be in the resources folder.
	 * @return - True if launched
	 * 		   - False if not launched
	 */
	public static Boolean setGeckoDriverProperty(){
		String gecko_driver_path = "src\\test\\resources\\geckodriver.exe";
		try{
			TestLog.debug("Set gecko driver path.");
			TestLog.debug("gecko driver expected to be at: " + gecko_driver_path);
			System.setProperty("webdriver.gecko.driver", gecko_driver_path);
			return true;
		}
		catch(Exception e){
			TestLog.debug("Unable to set gecko driver property");
			TestLog.debug("Check that gecko driver is located at: " + gecko_driver_path);
			return false;
		}
	}
	
	/**
	 * Sets up the configuration file for logging and test name.
	 * @param test_name - name of the test.
	 */
	public static void setupLogging(String test_name){
		System.setProperty("log4j.configurationFile", "src\\test\\java\\support\\config\\log4j2.xml");
		
		//Set Base Path
		System.setProperty("test_results_base_directory", Properties.test_results_base_directory);
		
		//Set Date Time
		String current_date_time = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime());
		Properties.current_date_time = current_date_time;
		System.setProperty("current_date_time", current_date_time);
		
		// Set test name
		Properties.test_name = test_name;
		System.setProperty("test_name", test_name);
		
		// Set Test Results Folder
		String test_results_folder = current_date_time + " " + test_name;
		Properties.test_results_folder = test_results_folder;
		
		// Update the log4j2.xml
		((org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false)).reconfigure();
	}
		
	/**
	 * Takes a screenshot of the current web page.
	 * @param driver - web driver
	 * @param screenshot_name
	 * @return screenshot_path
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String takeImage(WebDriver driver, String screenshot_name) throws IOException, InterruptedException{
		Wait.sleep(1);
		TestLog.info("Take Image at: " + driver.getTitle());
		File scrnFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // Take screenshot
		Properties.number_images +=1;
		
		String screenshot_full_name = "screenshot_" + Properties.number_images + screenshot_name + ".png"; 
		String screenshot_path = Properties.test_results_base_directory + Properties.test_results_folder + "/" + screenshot_full_name;
		FileUtils.copyFile(scrnFile, new File(screenshot_path));
		return screenshot_path;
	}
	
	/**
	 * Takes a screenshot of the current web page.
	 * @param driver - web driver
	 * @return screenshot path
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static String takeImage(WebDriver driver) throws IOException, InterruptedException{
		String screenshot_name = "";
		String screenshot_path = takeImage(driver, screenshot_name);
		return screenshot_path;
	}
	
}
