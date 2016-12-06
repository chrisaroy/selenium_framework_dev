package support.utilities;

import java.io.IOException;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import config.Properties;
import support.utilities.TestLog;

/**
 * Class for verify and assert
 * @author Chris
 */
public class Confirm {
	
	/**
	 * Logs the results of the verify or assert.
	 */
	private static void logResults(String desc, String result, Object act, Object exp, String reqs, Boolean img, String img_name, String check_type){
		TestLog.info(check_type + ": " + desc);
		TestLog.info("  Result: " + result.toString());
		TestLog.info("  actual: " + act.toString());
		TestLog.info("  expected: " + exp.toString());
		if(reqs != ""){
			TestLog.info("  requirements: " + reqs);
		}
		if(img){
			TestLog.info("  Screen Capture is: " + img_name);
		}	
	}
	
	/**
	 * Verify or Assert actual vs. Expected.  When verify is used, the test will continue and failure will be in
	 * log.  Failure will not be logged in testng.
	 * @param driver - web driver
	 * @param description - Description of verify or assert
	 * @param actual - Actual result
	 * @param expected - Expected result
	 * @param requirements - Requirements covered
	 * @param take_image - Takes screenshot
	 * @param check_type - 
	 * @return - array with actual and expected
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private static String[] assertVerify(WebDriver driver, String description, Object actual, Object expected, String requirements, Boolean take_image, String check_type) throws IOException, InterruptedException{
		String s_result = "";		
		Properties.number_verifications += 1;
		String verify_image_name = "screen_capture_" + Properties.number_verifications + "_verify";
		
		// Check if array and convert to string
		if((actual instanceof int[]) || (actual instanceof String[]) || (actual instanceof Boolean[])){
			// Convert actual and expected from object to array to string
			String r_actual = ReflectionToStringBuilder.toString(actual);
			actual = r_actual.substring(r_actual.indexOf("{"), r_actual.indexOf("}")) + "}".toString();
			String r_expected = ReflectionToStringBuilder.toString(expected);
			expected = r_expected.substring(r_expected.indexOf("{"), r_expected.indexOf("}")) + "}".toString();
		}
		// Compare values
		if (actual.equals(expected)){
			s_result = "PASS";
			Properties.number_passes += 1;
		}
		else{
			s_result = "FAIL";
			Properties.number_fails += 1;
		}
		if (take_image){
			Support.takeImage(driver, "_assert_verify");
		}
		logResults(description, s_result, actual, expected, requirements, take_image, verify_image_name, check_type);
		String[] results = {actual.toString(), expected.toString()};
		return results;
	}
	
	// Verify Methods
	public static void verify(WebDriver driver, String description, Object actual, Object expected, String requirements, Boolean take_image) throws IOException, InterruptedException{
		assertVerify(driver, description, actual, expected, requirements, take_image, "VERIFY");
	}
	
	public static void verify(WebDriver driver, String description, Object actual, Object expected, String requirements) throws IOException, InterruptedException{
		verify(driver, description, actual, expected, requirements, true);
	}
	
	public static void verify(WebDriver driver, String description, Object actual, Object expected) throws IOException, InterruptedException{
		verify(driver, description, actual, expected, "", true);
	}
	
	// Assert Methods
	public static void assertCheck(WebDriver driver, String description, Object actual, Object expected, String requirements, Boolean take_image) throws IOException, InterruptedException{
		String[] results = assertVerify(driver, description, actual, expected, requirements, take_image, "ASSERT");
		Properties.number_asserts += 1;
		if(! results[0].equals(results[1])){
			TestLog.info("** Assertion failed - Test will stop **");
		}
		Assert.assertEquals(results[0], results[1]);;
	}
	
	public static void assertCheck(WebDriver driver, String description, Object actual, Object expected, String requirements) throws IOException, InterruptedException{
		assertCheck(driver, description, actual, expected, requirements, true);
	}
	
	public static void assertCheck(WebDriver driver, String description, Object actual, Object expected) throws IOException, InterruptedException{
		assertCheck(driver, description, actual, expected, "", true);
	}
}
		