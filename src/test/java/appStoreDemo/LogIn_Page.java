package appStoreDemo;

import webElements.TextBox;
import appStoreDemo.Login_Page_IDs;
import webElements.Button;

public class LogIn_Page {
	// User name
	public TextBox user_name_textbox = new TextBox(Login_Page_IDs.user_name_tb_name, Login_Page_IDs.user_name_tb_id);
	
	// Password
	public TextBox password_textbox = new TextBox(Login_Page_IDs.password_tb_name,Login_Page_IDs. password_tb_id);
	
	// Login Button
	public Button login_button = new Button(Login_Page_IDs.login_btn_name, Login_Page_IDs.login_btn_id);
}
