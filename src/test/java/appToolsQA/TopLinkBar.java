package appToolsQA;

import org.openqa.selenium.WebDriver;
import support.webElements.GetElementByType;
import support.webElements.Link;
import appToolsQA.Practice_Form_Page;
import appToolsQA.storeDemo.store_demo_site;

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
	
	/**
	 * Selects the practice form link form the demo sites drop down link.
	 * @param driver web driver
	 * @return Practice_Form_Page() object
	 * @throws InterruptedException
	 */
	public Practice_Form_Page practice_form_link_select(WebDriver driver) throws InterruptedException{
		demo_sites_link.click_link(driver);
		demo_sites_practice_form_link.click_link(driver);
		return new Practice_Form_Page();	
	}

	/**
	 * Selects the demo sites e-commerce link and switches the driver.
	 * @param driver web driver
	 * @return store demo site
	 * @throws InterruptedException
	 */
	public store_demo_site e_commerce_link_select(WebDriver driver) throws InterruptedException{
		// Switch focus to new tab after selecting link.
		String parentHandle = driver.getWindowHandle();
		System.out.println(parentHandle);
		
		// Selecting link opens e-commerce in new tab.
		demo_sites_link.click_link(driver);
		demo_sites_e_commerce_link.click_link(driver);
		
		for (String winHandle : driver.getWindowHandles()) { 
			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
		}
		
		return new store_demo_site();
	}
	
}
