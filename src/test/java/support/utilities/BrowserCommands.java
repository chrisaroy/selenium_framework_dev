package support.utilities;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

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
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL + "w");
				
		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}
	}

}
