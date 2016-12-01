package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Properties;
import utilities.TestLog;
import utilities.Wait;
import webElements.GetElementByType;

/**
 * Button class
 * @author Chris
 */
public class Button extends BaseElement{
	
	/**
	 * Constructor for button
	 * @param element_id - includes name, by type, and id.
	 */
	public Button(String[] element_id) {
		super(element_id);
	}

	/**
	 * Clicks on a button.
	 * @param driver
	 * @throws InterruptedException 
	 */
	public void click_button(WebDriver driver) throws InterruptedException{
		TestLog.info("Click button \'" + this.s_element_name + "\'");
		Wait.wait_during_action(Properties.WAIT_BEFORE_ACTION, Properties.WAIT_BEFORE_ACTION_TIME);
		
		WebElement button = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		button.click();
		
		Wait.wait_during_action(Properties.WAIT_AFTER_ACTION, Properties.WAIT_AFTER_ACTION_TIME);
	}
	
}
