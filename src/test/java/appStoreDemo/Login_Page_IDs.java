package appStoreDemo;

import webElements.GetElementByType;

class Login_Page_IDs {
	// User name
	public static String user_name_tb_name = "User name textbox";
	public static String[] user_name_tb_id = {GetElementByType.BY_XPATH, "//input[@id='log']"};

	// Password
	public static String password_tb_name = "Password textbox";
	public static String[] password_tb_id = {GetElementByType.BY_ID, "pwd"};
	
	// Login Button
	public static String login_btn_name = "Login Button";
	public static String[] login_btn_id = {GetElementByType.BY_ID, "login"};
}
