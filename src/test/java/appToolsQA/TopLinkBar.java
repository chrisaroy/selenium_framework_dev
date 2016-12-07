package appToolsQA;

import org.openqa.selenium.WebDriver;
import support.webElements.GetElementByType;
import support.webElements.Link;
import appToolsQA.Practice_Form_Page;

/**
 * ID's for the elements in the Top Link Bar
 * @author Chris
 */
class TopLinkBar_IDs{
	public static final String[] home_link_id = {"Home Link", GetElementByType.BY_XPATH, "//span[contains(.,'HOME')]"};
	public static final String[] contact_us_link_id = {"Contact Us Link", GetElementByType.BY_XPATH, "//span[contains(.,'CONTACT Us')]"};
	
	public static final String[] demo_sites_link_id = {"Demo Sites Link", GetElementByType.BY_XPATH, "//span[contains(.,'DEMO SITES')]"};
	public static final String[] demo_site_e_commerce_link_id = {"Demo Sites - E Commerce Link", GetElementByType.BY_XPATH, "//span[contains(.,'E-Commerce Demo Site')]"};
	public static final String[] demo_site_practice_form_link_id = {"Demo Sites - Practice Form Link", GetElementByType.BY_XPATH, "//span[contains(.,'Automation Practice Form')]"};
	public static final String[] demo_site_practice_switch_id = {"Demo Sites - E Commerce Link", GetElementByType.BY_XPATH, "//span[contains(.,'Automation Practice Switch Windows')]"};
}

/**
 * Elements and related code for the top link bar.
 * @author Chris
 */
public class TopLinkBar {
	public Link home_link = new Link(TopLinkBar_IDs.home_link_id);
	public Link contact_us_link = new Link(TopLinkBar_IDs.contact_us_link_id);
	
	public Link demo_sites_link = new Link(TopLinkBar_IDs.demo_sites_link_id);
	public Link demo_sites_e_commerce_link = new Link(TopLinkBar_IDs.demo_site_e_commerce_link_id);
	public Link demo_sites_practice_form_link = new Link(TopLinkBar_IDs.demo_site_practice_form_link_id);
	public Link demo_sites_practice_switch_link = new Link(TopLinkBar_IDs.demo_site_practice_switch_id);
	
	// create method to select practice form link and return the practice form page. 
	public Practice_Form_Page practice_form_link_select(WebDriver driver) throws InterruptedException{
		demo_sites_link.click_link(driver);
		demo_sites_practice_form_link.click_link(driver);
		return new Practice_Form_Page();	
	}

}
