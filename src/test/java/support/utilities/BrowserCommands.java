package support.utilities;

import org.openqa.selenium.WebDriver;

/**
 * Commands related to the browser
 * @author Chris
 */
public class BrowserCommands {
	

	/**
	 * Close the current tab and switch focus to the remaining tab.
	 * @param driver - web driver
	 */
	public static void closeTab(WebDriver driver){
		driver.close();
		driver.switchTo().window(config.Properties.parentHandle);
	}
	
	/**
	 * Close browser window and switch focus to parent window.
	 * @param driver - web driver.
	 */
	public static void closeWindow(WebDriver driver){
		driver.close();
		driver.switchTo().window(config.Properties.parentHandle);
	}
	
	/**
	 * Maximize browser window.
	 * @param driver - web driver
	 */
	public static void maximizWindow(WebDriver driver){
		driver.manage().window().maximize();
	}

}
