package pages;

import org.openqa.selenium.By;

import base.Page;

public class HomePage extends Page {

	public void gotoSignUp() {
		driver.findElement(By.xpath("//a[contains(text(),'Free Sign Up')]")).click();
	}

	public LoginPage gotoLogin() {
		click("loginlink_xpath");
		return new LoginPage();
	}

	public void gotoZOhoEdu() {

	}

	public void validateFooterLinks() {

	}

	public void gotoSupport() {
		driver.findElement(By.cssSelector(".signing>a:nth-child(2)")).click();
	}
}
