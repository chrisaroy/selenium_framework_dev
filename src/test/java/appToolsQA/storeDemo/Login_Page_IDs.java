package appToolsQA.storeDemo;

import support.webElements.GetElementByType;

/**
 * IDs for the elements on the Login Page
 * @author Chris
 */
class Login_Page_IDs {
	public static final String[] user_name_tb_id = {"User Name Text Box", GetElementByType.BY_XPATH, "//input[@id='log']"};
	public static final String[] password_tb_id = {"Password Text Box", GetElementByType.BY_ID, "pwd"};
	public static final String[] login_btn_id = {"Login Button", GetElementByType.BY_ID, "login"};	
}
