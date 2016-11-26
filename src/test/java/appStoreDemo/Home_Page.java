package appStoreDemo;

import webElements.Button;
import webElements.Link;
import webElements.GetElementByType;

class HomePageIDs{
	public static String[] my_acct_lnk_id = {"My Account Link", GetElementByType.BY_ID, "account"};
	public static String shoppping_cart_btn_name = "Shopping Cart Button";
	public static String[] shopping_cart_btn_id = {"Shopping Cart Button", GetElementByType.BY_XPATH, "//span[contains(.,'Cart')]"};	
}

public class Home_Page {
	public Link my_account_link = new Link(HomePageIDs.my_acct_lnk_id);
	public Button shopping_cart_button = new Button(HomePageIDs.shopping_cart_btn_id);
}
