package support.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Properties;
import support.utilities.TestLog;
import support.utilities.Wait;
import support.webElements.GetElementByType;

/**
 * Class for link
 * @author Chris
 */
public class Link extends BaseElement {

	/**
	 * Constructor for Link
	 * @param element_id - includes name, by type, and id.
	 */
	public Link(String[] element_id) {
		super(element_id);
	}

	/**
	 * Clicks on a link
	 * @param driver - web driver
	 * @throws InterruptedException 
	 */
	public void click_link(WebDriver driver) throws InterruptedException{
		TestLog.info("Click link \'" + this.s_element_name + "\'");
		Wait.wait_during_action(Properties.WAIT_BEFORE_ACTION, Properties.WAIT_BEFORE_ACTION_TIME);
		
		WebElement link = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		link.click();	
		
		Wait.wait_during_action(Properties.WAIT_AFTER_ACTION, Properties.WAIT_AFTER_ACTION_TIME);
	}
}
