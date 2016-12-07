package appToolsQA.storeDemo;

import support.webElements.Button;
import support.webElements.GetElementByType;
import support.webElements.Link;

/**
 * ID's for the elements on the Home Page.
 * @author Chris
 */
class HomePageIDs{
	public static final String[] my_acct_lnk_id = {"My Account Link", GetElementByType.BY_ID, "account"};
	public static final String shoppping_cart_btn_name = "Shopping Cart Button";
	public static final String[] shopping_cart_btn_id = {"Shopping Cart Button", GetElementByType.BY_XPATH, "//span[contains(.,'Cart')]"};	
}

/**
 * Elements and related code for the Home Page
 * @author Chris
 */
public class Home_Page {
	public Link my_account_link = new Link(HomePageIDs.my_acct_lnk_id);
	public Button shopping_cart_button = new Button(HomePageIDs.shopping_cart_btn_id);
}
