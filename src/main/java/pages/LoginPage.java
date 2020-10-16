package pages;

import base.Page;

public class LoginPage extends Page {

	public zohoAppPage doLogin(String username, String password) {

		type("username_xpath", username);
		click("nextbtn_xpath");
		type("password_xpath", password);
		click("signinBtn_xpath");

		return new zohoAppPage();
	}
}
