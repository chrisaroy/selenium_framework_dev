package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.TestLog;
import webElements.GetElementByType;

public class BaseElement {
	String[] s_element_id;
	String s_element_name;
	
	public BaseElement(String element_name, String[] element_id){
		s_element_name = element_name;
		s_element_id = element_id;
	}
	public Boolean is_enabled(WebDriver driver){
		TestLog.info("Get enabled state of " + this.s_element_name);
		WebElement element = GetElementByType.get_element_by_type(driver, this.s_element_id);
		Boolean enabled = element.isEnabled();
		TestLog.info("Enabled state of " + this.s_element_name + " is: " + String.valueOf(enabled));
		return enabled;
	}
	
	public Boolean is_displayed(WebDriver driver){
		TestLog.info("Get displayed state of " + this.s_element_name);
		WebElement element = GetElementByType.get_element_by_type(driver, this.s_element_id);
		Boolean displayed = element.isDisplayed();
		TestLog.info("Displayed state of " + this.s_element_name + " is: " + String.valueOf(displayed));
		return displayed;		
	}
}
