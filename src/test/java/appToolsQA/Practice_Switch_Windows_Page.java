package appToolsQA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import support.webElements.Button;
import support.webElements.GetElementByType;

import java.util.Set;

/**
 * IDs for the elements on the practice switch window page
 * @author Chris
 */
class practice_switch_window_ids{
	public static final String[] new_browser_window_button_id = {"New Browser Window Button", GetElementByType.BY_ID, "button1"};
	public static final String[] new_message_window_button_id = {"New Message Window Button", GetElementByType.BY_XPATH, "//button[@onclick='newMsgWin()']"};
	public static final String[] new_browser_tab_button_id = {"New Browser Tab Button", GetElementByType.BY_XPATH, "//button[contains(.,'New Browser Tab')]"};
	public static final String[] alert_box_button_id = {"Alert Box Button", GetElementByType.BY_ID, "alert"};
	public static final String[] timing_alert_button_id = {"Timing Alert Button", GetElementByType.BY_ID, "timingAlert"};
}
	
/**
 * Elements and related code for the practice switch window page.
 * @author Chris
 */
public class Practice_Switch_Windows_Page{
	public Button new_browser_window_button = new Button(practice_switch_window_ids.new_browser_window_button_id);
	public Button new_message_window_button = new Button(practice_switch_window_ids.new_message_window_button_id);
	public Button new_browser_tab_button = new Button(practice_switch_window_ids.new_browser_tab_button_id);
	public Button alert_box_button = new Button(practice_switch_window_ids.alert_box_button_id);
	public Button timing_alert_button =	new Button(practice_switch_window_ids.timing_alert_button_id);	
	
	public void new_message_window_select(WebDriver driver) throws InterruptedException{
		new_message_window_button.click_button(driver);
		
		Set handles = driver.getWindowHandles();
		
	}
	
	/**
	 * Selects the alert box button.
	 * @param driver - web driver
	 * @return Alert Box
	 * @throws InterruptedException 
	 */
	public Alert alert_box_button_select(WebDriver driver) throws InterruptedException{
		alert_box_button.click_button(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert alert_box = wait.until(ExpectedConditions.alertIsPresent());
		return alert_box;
	}
	
	/**
	 * Selects the timing alert button.
	 * @param driver - web driver
	 * @return Timing Alert Box
	 * @throws InterruptedException 
	 */
	public Alert timing_alert_button_select(WebDriver driver) throws InterruptedException {
		timing_alert_button.click_button(driver);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Alert timing_alert_box = wait.until(ExpectedConditions.alertIsPresent());
		return timing_alert_box;
	}
}

