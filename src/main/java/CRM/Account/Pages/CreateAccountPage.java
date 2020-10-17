package CRM.Account.Pages;

import base.Page;

public class CreateAccountPage extends Page {
	public void crateAccount(String AccountName) {
		type("accountname_xpath", AccountName);
	}

}
