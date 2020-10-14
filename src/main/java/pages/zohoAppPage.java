package pages;

import org.openqa.selenium.By;

import CRMPages.CRMHomePage;
import base.Page;

public class zohoAppPage extends Page {

	public void gotoChat() {
		driver.findElement(By.cssSelector(".zicon-apps-chat.zicon-apps-96")).click();
	}

	public CRMHomePage gotoCRM() {

		driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/div[7]/div[1]/a[1]/span[1]")).click();

		return new CRMHomePage();
	}
}
