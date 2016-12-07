package support.webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.Properties;
import support.utilities.TestLog;
import support.utilities.Wait;
import support.webElements.GetElementByType;

/**
 * Class for check box element.
 * @author Chris
 */
public class CheckBox extends BaseElement{
	
	/**
	 * Constructor for check box
	 * @param element_id - includes name, by type, and id.
	 */
	public CheckBox(String[] element_id){
		super(element_id);
	}
	
	/**
	 * Selects the check box
	 * @param driver - web driver
	 * @throws InterruptedException 
	 */
	public void check(WebDriver driver) throws InterruptedException{
		TestLog.info("Select Check box \'" + this.s_element_name + "\'");
		Wait.wait_during_action(Properties.WAIT_BEFORE_ACTION, Properties.WAIT_BEFORE_ACTION_TIME);
		
		WebElement checkbox = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		checkbox.click();
		
		Wait.wait_during_action(Properties.WAIT_AFTER_ACTION, Properties.WAIT_AFTER_ACTION_TIME);
	}
	
	/**
	 * Determine if check box is checked.
	 * @param driver - web driver
	 * @return checked state
	 * @throws InterruptedException 
	 */
	public Boolean is_checked(WebDriver driver) throws InterruptedException{
		TestLog.info("Get checked state of \'" + this.s_element_name + "\'");
		Wait.wait_during_action(Properties.WAIT_BEFORE_ACTION, Properties.WAIT_BEFORE_ACTION_TIME);
		
		WebElement checkbox = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		Boolean checked = checkbox.isSelected();
		TestLog.info("Checked state of \'" + this.s_element_name + "\' is: " + String.valueOf(checked));
		
		Wait.wait_during_action(Properties.WAIT_AFTER_ACTION, Properties.WAIT_AFTER_ACTION_TIME);
		return checked;
	}
}

