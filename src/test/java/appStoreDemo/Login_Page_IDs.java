package appStoreDemo;

import webElements.GetElementByType;

class Login_Page_IDs {
	public static String[] user_name_tb_id = {"User name textbox", GetElementByType.BY_XPATH, "//input[@id='log']"};
	public static String[] password_tb_id = {"Password textbox", GetElementByType.BY_ID, "pwd"};
	public static String[] login_btn_id = {"Login Button", GetElementByType.BY_ID, "login"};	
}
