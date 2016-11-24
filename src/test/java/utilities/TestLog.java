package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;
import config.Properties;

public class TestLog {
	// Initialize Log4j logs
	private static final Logger TestLog = LogManager.getLogger(TestLog.class.getName());
	
	public static void startTest(){
		// Print log for the beginning of the test
		TestLog.info("***********************************************************");
		TestLog.info("**** Start Test: " + Properties.test_name + " ****");
		TestLog.info("***********************************************************\n");
		Reporter.log("Start Test: " + Properties.test_name);
	}

	public static void endTest(){
		TestLog.info("***********************************************************");
		TestLog.info("**** End Test: " + Properties.test_name + " ****");
		TestLog.info("***********************************************************");	
		Reporter.log("End Test: " + Properties.test_name);
		
		// Prints off the test summary.
		testSummary();
	}
	
	public static void startTestStep(String test_step_name){
		Properties.test_step += 1;
		TestLog.info("Start test step: " + test_step_name);
	}
	public static void startTestStep(){
		Properties.test_step += 1;
		TestLog.info("Start test step: " + Thread.currentThread().getStackTrace()[2].getMethodName());
	}
	
	public static void endTestStep(String test_step_name){
		TestLog.info("End test step: " + test_step_name + "\n");
	}
	public static void endTestStep(){
		TestLog.info("End test step: " + Thread.currentThread().getStackTrace()[2].getMethodName() + "\n");
	}
	
	public static void info(String message){
		TestLog.info("  " + message);
		Reporter.log(message + "<br>");
	}
	
	public static void warn(String message) {
		TestLog.warn("  " + message);
		Reporter.log(message + "<br>");
	}
	 
	public static void error(String message) {
		TestLog.error("  " + message);
		Reporter.log(message + "<br>");
	}
	 
	public static void fatal(String message) { 
		TestLog.fatal("  " + message);
		Reporter.log(message + "<br>");
	}
	 
	public static void debug(String message) {
		TestLog.debug("  " + message);
		Reporter.log(message + "<br>");
	}	
	
	public static void testSummary(){
		TestLog.info("");
		TestLog.info("***********************************************************");
		TestLog.info("TEST SUMMARY:");
		TestLog.info("  Test Name: " + Properties.test_name);
		TestLog.info("  Test Steps: " + Properties.test_step);
		TestLog.info("  Verification: ");
		TestLog.info("    Passed: " + Properties.number_passes);
		TestLog.info("    Failed: " + Properties.number_fails);
		TestLog.info("    Total:  " + Properties.number_verifications);
		//TestLog.info("  Number that were asserts: " + Properties.number_asserts);
		TestLog.info("***********************************************************");
	}
	
}
