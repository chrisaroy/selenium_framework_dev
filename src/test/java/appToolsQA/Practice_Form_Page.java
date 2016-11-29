package appToolsQA;

import webElements.TextBox;
import webElements.RadioButton;
import webElements.CheckBox;
import webElements.GetElementByType;

class automation_practice_form_page_ids{
	/**
	 * ID's for the elements on the practice form page.
	 */
	public static final String[] first_name_textbox_id = {"First Name Textbox", GetElementByType.BY_XPATH, "//input[@name='firstname']"};
	public static final String[] male_radio_button_id = {"Male Radio Button", GetElementByType.BY_XPATH, "//input[@id='sex-0']"};
	public static final String[] female_radio_button_id = {"Female Radio Button", GetElementByType.BY_XPATH, "//input[@id='sex-1']"};
	public static final String[] manual_tester_check_box = {"Manual Tester Check box", GetElementByType.BY_ID, "profession-0"};
	public static final String[] automation_tester_check_box = {"Automation Test Check box", GetElementByType.BY_ID, "profession-1"};
}


public class Practice_Form_Page {
	/**
	 * Elements and related code for the practice form page.
	 */
	public TextBox first_name_textbox = new TextBox(automation_practice_form_page_ids.first_name_textbox_id);
	public RadioButton male_radio_button = new RadioButton(automation_practice_form_page_ids.male_radio_button_id);
	public RadioButton female_radio_button = new RadioButton(automation_practice_form_page_ids.female_radio_button_id);
	public CheckBox manual_tester_checkbox = new CheckBox(automation_practice_form_page_ids.manual_tester_check_box);
	public CheckBox automation_tester_checkbox = new CheckBox(automation_practice_form_page_ids.automation_tester_check_box);
}
