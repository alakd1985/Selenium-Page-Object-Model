package rough;

import base.Page;
import pages.HomePage;
import pages.LoginPage;
import pages.zohoAppPage;

public class LoginTest {

	public static void main(String[] args) {

		HomePage homePage = new HomePage();
		homePage.gotoLogin();
		LoginPage loginPage = new LoginPage();

		loginPage.doLogin("leoalak@gmail.com", "Toma*1996");
		zohoAppPage zohoAppPage = new zohoAppPage();
		zohoAppPage.gotoCRM();
		Page.menu.gotoAccounts();

	}

}
