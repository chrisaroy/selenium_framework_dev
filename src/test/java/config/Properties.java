package config;

public class Properties {
	public static String test_results_base_directory = "src\\test\\java\\TestResults\\";
	public static String test_results_folder = "";
	public static String current_date_time = "";   // Also set in System.setProperty
	
	// Test setup related variables
	public static String test_name = "";
	public static int test_step = 0;
	
	public static int number_images = 0;
	
	public static Boolean take_screenshot_on_fail = true;
	public static int number_verifications = 0;
	public static int number_asserts = 0;
	public static int number_passes = 0;
	public static int number_fails = 0;

}