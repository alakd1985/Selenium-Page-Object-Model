package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import CRM.Account.Pages.AccountsPage;
import CRM.Account.Pages.CreateAccountPage;
import Utilities.DataUtil;
import base.Page;
import pages.zohoAppPage;

public class CreateAccountTest {

	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")
	public void createAccountTest(Hashtable<String, String> data) {
		zohoAppPage zPage = new zohoAppPage();
		zPage.gotoCRM();
		AccountsPage accountsPage = Page.menu.gotoAccounts();

		CreateAccountPage cPage = accountsPage.gotoCreateAccounts();

		cPage.crateAccount(data.get("accountname"));
	}
}
