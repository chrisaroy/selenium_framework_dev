package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestLog;
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
	 */
	public void click_button(WebDriver driver){
		TestLog.info("Click button: " + this.s_element_name);
		WebElement button = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		button.click();
	}
	
}
