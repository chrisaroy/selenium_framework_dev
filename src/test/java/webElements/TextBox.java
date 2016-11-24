package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.TestLog;
import webElements.GetElementByType;

public class TextBox extends BaseElement {
	// Constructor for text box
	public TextBox(String element_name, String[] element_id) {
		super(element_name, element_id);
	}

	public void enter_text(WebDriver driver, String text){
		TestLog.info("Enter text: \"" + text + "\" in "+ this.s_element_name);
		WebElement link = GetElementByType.get_element_by_type(driver, this.s_element_id);
		link.sendKeys(text);
	}
}
