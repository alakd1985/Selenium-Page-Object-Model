package pages;

import org.openqa.selenium.By;

import CRMPages.CRMHomePage;
import base.Page;

public class zohoAppPage extends Page {

	public void gotoChat() {
		driver.findElement(By.cssSelector(".zicon-apps-chat.zicon-apps-96")).click();
	}

	public CRMHomePage gotoCRM() {

		click("crmlink_xpath");

		return new CRMHomePage();
	}
}
