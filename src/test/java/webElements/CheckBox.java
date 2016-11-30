package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestLog;
import webElements.GetElementByType;

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
	 */
	public void check(WebDriver driver){
		TestLog.info("Select Checkbox: " + this.s_element_name);
		WebElement checkbox = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		checkbox.click();
	}
	
	/**
	 * Determine if check box is checked.
	 * @param driver - web driver
	 * @return checked state
	 */
	public Boolean is_checked(WebDriver driver){
		TestLog.info("Get checked state of " + this.s_element_name);
		WebElement checkbox = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		Boolean checked = checkbox.isSelected();
		TestLog.info("Checked state of " + this.s_element_name + " is: " + String.valueOf(checked));
		return checked;
	}
}

