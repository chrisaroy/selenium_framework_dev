package appToolsQA.storeDemo;

import appToolsQA.storeDemo.Login_Page_IDs;
import support.webElements.Button;
import support.webElements.TextBox;

/**
 * Elements and related code for the Log in page
 * @author Chris
 */
public class LogIn_Page {
	public TextBox user_name_textbox = new TextBox(Login_Page_IDs.user_name_tb_id);
	public TextBox password_textbox = new TextBox(Login_Page_IDs.password_tb_id);
	public Button login_button = new Button(Login_Page_IDs.login_btn_id);
}
