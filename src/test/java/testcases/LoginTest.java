package testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import Utilities.DataUtil;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest {
	@Test(dataProviderClass = DataUtil.class, dataProvider = "dp")

	public void loginTest(Hashtable<String, String> data) {
		HomePage homePage = new HomePage();
		LoginPage lPage = homePage.gotoLogin();
		lPage.doLogin(data.get("username"), data.get("password"));
	}

}
