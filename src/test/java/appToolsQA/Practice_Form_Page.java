package appToolsQA;

import webElements.TextBox;
import webElements.GetElementByType;

class automation_practice_form_page_ids{
	/**
	 * ID's for the elements on the practice form page.
	 */
	public static String[] first_name_textbox = {"First Name Textbox", GetElementByType.BY_XPATH, "//input[@name='firstname']"};
	
}
public class Practice_Form_Page {
	/**
	 * Elements and related code for the practice form page.
	 */
	public TextBox first_name_textbox = new TextBox(automation_practice_form_page_ids.first_name_textbox);
}
