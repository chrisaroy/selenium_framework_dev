package support.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Properties;
import support.utilities.TestLog;
import support.utilities.Wait;
import support.webElements.GetElementByType;

/**
 * Class for text box.
 * @author Chris
 */
public class TextBox extends BaseElement {
	
	/**
	 * Constructor for text box
	 * @param element_id - includes name, by type, and id.
	 */
	public TextBox(String[] element_id) {
		super(element_id);
	}

	/**
	 * Enter text into text box.
	 * @param driver - web driver,
	 * @param text - text to be entered into text box.
	 * @throws InterruptedException 
	 */
	public void enter_text(WebDriver driver, String text) throws InterruptedException{
		TestLog.info("Enter text: \'" + text + "\' in \'"+ this.s_element_name + "\'");
		Wait.wait_during_action(Properties.WAIT_BEFORE_ACTION, Properties.WAIT_BEFORE_ACTION_TIME);
		
		WebElement link = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		link.sendKeys(text);
		
		Wait.wait_during_action(Properties.WAIT_AFTER_ACTION, Properties.WAIT_AFTER_ACTION_TIME);
	}
}
