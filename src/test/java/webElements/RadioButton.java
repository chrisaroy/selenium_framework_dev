package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestLog;

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
	 */
	public void click(WebDriver driver){
		TestLog.info("Click Radiobutton: " + this.s_element_name);
		WebElement radio_button = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		radio_button.click();
	}
	
	/**
	 * Determines if radio button is selected.
	 * @param driver - web driver
	 * @return - True if selected
	 * 			 False if not selected.
	 */
	public Boolean is_selected(WebDriver driver){
		TestLog.info("Get selected state of " + this.s_element_name);
		WebElement radio_button = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		Boolean checked = radio_button.isSelected();
		TestLog.info("Selected state of " + this.s_element_name + " is: " + String.valueOf(checked));
		return checked;
	}
}
