package CRM.Account.Pages;

import base.Page;

public class AccountsPage extends Page {

	public CreateAccountPage gotoCreateAccounts() {

		click("createaccountbtn_xpath");
		return new CreateAccountPage();
	}

	public void gotoImportAccounts() {

	}
}
