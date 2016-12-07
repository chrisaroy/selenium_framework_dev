package support.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Properties;
import support.utilities.TestLog;
import support.utilities.Wait;

/**
 * Class for radio button.
 * @author Chris
 */
public class RadioButton extends BaseElement{
	
	/**
	 * Constructor for radio button
	 * @param element_id - includes name, by type, and id.
	 */
	public RadioButton(String[] element_id){
		super(element_id);
	}
	
	/**
	 * Clicks on a radio button.
	 * @param driver - web driver
	 * @throws InterruptedException 
	 */
	public void click(WebDriver driver) throws InterruptedException{
		TestLog.info("Click Radio button \'" + this.s_element_name + "\'");
		Wait.wait_during_action(Properties.WAIT_BEFORE_ACTION, Properties.WAIT_BEFORE_ACTION_TIME);
		
		WebElement radio_button = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		radio_button.click();
		
		Wait.wait_during_action(Properties.WAIT_AFTER_ACTION, Properties.WAIT_AFTER_ACTION_TIME);
	}
	
	/**
	 * Determines if radio button is selected.
	 * @param driver - web driver
	 * @return - True if selected
	 * 			 False if not selected.
	 * @throws InterruptedException 
	 */
	public Boolean is_selected(WebDriver driver) throws InterruptedException{
		TestLog.info("Get selected state of \'" + this.s_element_name + "\'");
		Wait.wait_during_action(Properties.WAIT_BEFORE_ACTION, Properties.WAIT_BEFORE_ACTION_TIME);
		
		WebElement radio_button = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		Boolean checked = radio_button.isSelected();
		TestLog.info("Selected state of \'" + this.s_element_name + "\' is: " + String.valueOf(checked));
		
		Wait.wait_during_action(Properties.WAIT_AFTER_ACTION, Properties.WAIT_AFTER_ACTION_TIME);
		return checked;
	}
}
