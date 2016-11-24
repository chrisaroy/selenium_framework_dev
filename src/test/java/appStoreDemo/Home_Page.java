package appStoreDemo;

import webElements.Button;
import webElements.Link;
import webElements.GetElementByType;

class HomePageIDs{
	public static String my_acct_lnk_name = "My Account Link";
	public static String[] my_acct_lnk_id = {GetElementByType.BY_ID, "account"};
	public static String shoppping_cart_btn_name = "Shopping Cart Button";
	public static String[] shopping_cart_btn_id = {GetElementByType.BY_XPATH, "//span[contains(.,'Cart')]"};
}

public class Home_Page {	
	public Link my_account_link = new Link(HomePageIDs.my_acct_lnk_name, HomePageIDs.my_acct_lnk_id);
	public Button shopping_cart_button = new Button(HomePageIDs.shoppping_cart_btn_name, HomePageIDs.shopping_cart_btn_id);
}
