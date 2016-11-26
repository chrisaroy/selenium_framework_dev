package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.TestLog;
import webElements.GetElementByType;

public class BaseElement {
	String s_element_name;
	String s_element_by_type;
	String s_element_id;
	
	public BaseElement(String[] element_id){
		s_element_name = element_id[0];
		s_element_by_type = element_id[1];
		s_element_id = element_id[2];
	}
	
	public Boolean is_enabled(WebDriver driver){
		TestLog.info("Get enabled state of " + this.s_element_name);
		WebElement element = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		Boolean enabled = element.isEnabled();
		TestLog.info("Enabled state of " + this.s_element_name + " is: " + String.valueOf(enabled));
		return enabled;
	}
	
	public Boolean is_displayed(WebDriver driver){
		TestLog.info("Get displayed state of " + this.s_element_name);
		WebElement element = GetElementByType.get_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		Boolean displayed = element.isDisplayed();
		TestLog.info("Displayed state of " + this.s_element_name + " is: " + String.valueOf(displayed));
		return displayed;		
	}
}
