package rough;

import CRM.Account.Pages.AccountsPage;
import CRM.Account.Pages.CreateAccountPage;
import base.Page;
import pages.HomePage;
import pages.LoginPage;
import pages.zohoAppPage;

public class LoginTest {

	public static void main(String[] args) {

		HomePage homePage = new HomePage();
		LoginPage lPage = homePage.gotoLogin();

		zohoAppPage zPage = lPage.doLogin("leoalak@gmail.com", "Toma*1996");

		zPage.gotoCRM();
		AccountsPage accountsPage = Page.menu.gotoAccounts();

		CreateAccountPage cPage = accountsPage.gotoCreateAccounts();

		cPage.crateAccount("Alak1985");

	}

}
