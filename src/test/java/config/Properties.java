package config;

/**
 * Properties used within the tests. These are global properties that can be
 * set and updated within tests unless the property is set to final.
 * @author Chris
 */
public class Properties {
	public static final String test_results_base_directory = "src\\test\\java\\TestResults\\";
	public static String test_results_folder = "";
	public static String current_date_time = "";   // Also set in System.setProperty
	
	// Test setup related variables
	public static String test_name = "";
	public static String test_summary = "";
	public static String manual_test_version = "";
	public static String requirements = "";
	public static int manual_test_time = 30;
	public static int test_step = 0;
	
	public static int number_images = 0;
	
	public static final Boolean take_screenshot_on_fail = true;
	public static int number_verifications = 0;
	public static int number_asserts = 0;
	public static int number_passes = 0;
	public static int number_fails = 0;
}
