package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.TestLog;
import webElements.GetElementByType;

public class Button extends BaseElement{
	// Constructor for Button
	public Button(String element_name, String[] element_id) {
		super(element_name, element_id);
	}

	public void click_button(WebDriver driver){
		TestLog.info("Click button: " + this.s_element_name);
		WebElement button = GetElementByType.get_element_by_type(driver, this.s_element_id);
		button.click();
	}
}
