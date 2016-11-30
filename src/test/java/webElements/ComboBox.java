package webElements;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestLog;

/**
 * Class for combo box select element
 * @author Chris
 */
public class ComboBox extends BaseElement{
	
	/**
	 * Constructor for combo box
	 * @param element_id - includes name, by type, and id.
	 */
	public ComboBox(String[] element_id){
		super(element_id);
	}
	
	/**
	 * Selects combo box by index.  Index is adjusted to account for zero based selection.
	 * @param driver
	 * @param index - index to select
	 */
	public void select_item_by_index(WebDriver driver, int index){
		TestLog.info("Select Combobox: \'" + this.s_element_name + "\' by index number: " + index);
		Select combobox = GetElementByType.get_select_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		combobox.selectByIndex(index-1);
	}
	
	/**
	 * Select a combo box item by value.  The value is the 'option' value.
	 * @param driver - web driver
	 * @param value - value in combo box to select
	 */
	public void select_item_by_value(WebDriver driver, String value){
		TestLog.info("Select Combobox \'" + this.s_element_name + "\' by value: " + value);
		Select combobox = GetElementByType.get_select_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		combobox.selectByValue(value);
	}
	
	/**
	 * Select combo box item by text
	 * @param driver - web driver
	 * @param text - text to select
	 */
	public void select_item_by_text(WebDriver driver, String text){
		TestLog.info("Select Combobox \'" + this.s_element_name + "\' by text: " + text);
		Select combobox = GetElementByType.get_select_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		combobox.selectByVisibleText(text);
	}
	
	/**
	 * Gets a list of all the items in a combo box.
	 * @param driver - web driver
	 * @return s_combo_box_items - list of items in the combo box
	 */
	public List<String> get_all_items(WebDriver driver){
		TestLog.info("Get all items from \'" + this.s_element_name + "\'");
		List<String> s_combo_box_items = new ArrayList<String>();
		Select combobox = GetElementByType.get_select_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		List<WebElement> we_combo_box_items = combobox.getOptions();
		
		int count = 1;
		for (WebElement element: we_combo_box_items)
		{
			String list_item = element.getText();
			TestLog.info("  item " + count + ": " + list_item);
			// Add to string list
			s_combo_box_items.add(list_item);
			count +=1;
		}
		return s_combo_box_items;
	}
	
	/**
	 * Gets the selected item of the combo box
	 * @param driver - web driver
	 * @return selected item as String
	 */
	public String get_selected_item(WebDriver driver){
		TestLog.info("Get selected item from \'" + this.s_element_name + "\'");
		Select combobox = GetElementByType.get_select_element_by_type(driver, this.s_element_by_type, this.s_element_id);
		String selected_item = combobox.getFirstSelectedOption().getText();
		TestLog.info("Selected item is: " + selected_item);
		return selected_item;
	}
}
