package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Gets the element by the type passed in.
 * @author Chris
 */
public class GetElementByType {
	public static String BY_ID = "id";
	public static String BY_NAME = "name";
	public static String BY_XPATH = "xpath";
	
	/**
	 * Returns the element based on the id.
	 * @param driver - Web driver
	 * @param element_type - By Type such as 'name', 'id', 'xpath'
	 * @param element_id - id of the element
	 * @return element
	 */
	public static WebElement get_element_by_type(WebDriver driver, String element_type, String element_id){
		WebElement element = null;
		if (element_type == GetElementByType.BY_ID){
			element = driver.findElement(By.id(element_id));
		}
		else if (element_type == GetElementByType.BY_NAME){
			element = driver.findElement(By.name(element_id));
		}
		else if (element_type == GetElementByType.BY_XPATH){
			element = driver.findElement(By.xpath(element_id));
		}
		return element;
	}
	
	/**
	 * Returns a select element based on the id.  Select element is used 
	 * for combo boxes.
	 * @param driver - web driver
	 * @param element_type - By Type such as 'name', 'id', 'xpath'
	 * @param element_id - id of the element
	 * @return select_element used for combo boxes
	 */
	public static Select get_select_element_by_type(WebDriver driver, String element_type, String element_id){
		Select select_element = null;
		if (element_type == GetElementByType.BY_ID){
			select_element = new Select(driver.findElement(By.id(element_id)));
		}
		else if (element_type == GetElementByType.BY_NAME){
			select_element = new Select(driver.findElement(By.name(element_id)));
		}
		else if (element_type == GetElementByType.BY_XPATH){
			select_element = new Select(driver.findElement(By.xpath(element_id)));
		}
		return select_element;
	}
	
}
