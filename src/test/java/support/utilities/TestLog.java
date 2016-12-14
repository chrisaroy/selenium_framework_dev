package support.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import config.Properties;

/**
 * Class for Test Log
 * @author Chris
 */
public class TestLog {
	// Initialize Log4j logs
	private static final Logger TestLog = LogManager.getLogger(TestLog.class.getName());
	
	/**
	 * Logs information at the beginning of a test.
	 */
	public static void startTest(){
		TestLog.info("***********************************************************");
		TestLog.info("**** Start Test: " + Properties.test_name + " ****");
		TestLog.info("***********************************************************\n");
		Reporter.log("Start Test: " + Properties.test_name);
	}

	/**
	 * Logs information at the end of the test, then calls testSummary()
	 */
	public static void endTest(){
		TestLog.info("***********************************************************");
		TestLog.info("**** End Test: " + Properties.test_name + " ****");
		TestLog.info("***********************************************************");	
		Reporter.log("End Test: " + Properties.test_name);
		
		// Prints off the test summary.
		testSummary();
	}
	
	/**
	 * Logs info at start of test step.
	 * @param test_step_name - name of the test step.
	 */
	public static void startTestStep(String test_step_name){
		Properties.test_step += 1;
		TestLog.info("Start test step: " + test_step_name);
	}
	
	/**
	 * Logs information at start of test.  Dynamically determines the step name.
	 */
	public static void startTestStep(){
		Properties.test_step += 1;
		TestLog.info("Start test step: " + Thread.currentThread().getStackTrace()[2].getMethodName());
	}
	
	/**
	 * Logs info at end of test.
	 * @param test_step_name - Name of the test step.
	 */
	public static void endTestStep(String test_step_name){
		TestLog.info("End test step: " + test_step_name + "\n");
	}
	
	/**
	 * Logs information at end of test.  Dynamically determines the step name.
	 */
	public static void endTestStep(){
		TestLog.info("End test step: " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n");
	}
	
	/**
	 * Logs informational message.
	 * @param message - message to add to log
	 */
	public static void info(String message){
		TestLog.info("  " + message);
		Reporter.log(message + "<br>");
	}
	
	/**
	 * Logs warning message.
	 * @param message - message to add to log
	 */
	public static void warn(String message) {
		TestLog.warn("  " + message);
		Reporter.log(message + "<br>");
	}
	 
	/**
	 * Logs error message
	 * @param message - message to add to log
	 */
	public static void error(String message) {
		TestLog.error("  " + message);
		Reporter.log(message + "<br>");
	}
	 
	/**
	 * Logs fatal message
	 * @param message - message to add to log
	 */
	public static void fatal(String message) { 
		TestLog.fatal("  " + message);
		Reporter.log(message + "<br>");
	}
	 
	/**
	 * Logs debug message
	 * @param message - message to add to log
	 */
	public static void debug(String message) {
		TestLog.debug("  " + message);
		Reporter.log(message + "<br>");
	}	
	
	/**
	 * Logs test summary using information from Properties.
	 */
	public static void testSummary(){
		TestLog.info("");
		TestLog.info("***********************************************************");
		TestLog.info("TEST SUMMARY:");
		TestLog.info("  Test Name: " + Properties.test_name);
		TestLog.info("  Test Summary: " + Properties.test_summary);
		TestLog.info("  Test Steps: " + Properties.test_step);
		TestLog.info("  Verification: ");
		TestLog.info("    Passed: " + Properties.number_passes);
		TestLog.info("    Failed: " + Properties.number_fails);
		TestLog.info("    Total:  " + Properties.number_verifications);
		TestLog.info("  Requirements: " + Properties.requirements);
		//TestLog.info("  Number that were asserts: " + Properties.number_asserts);
		TestLog.info("***********************************************************");
		TestLog.info("");
		TestLog.info("");
	}
}
