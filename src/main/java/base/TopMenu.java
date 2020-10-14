package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CRM.Account.Pages.AccountsPage;

public class TopMenu {
	WebDriver driver;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}

	public void gotoHome() {

	}

	public void gotoFeeds() {

	}

	public void gotoLeads() {

	}

	public void gotoDeals() {

	}

	public AccountsPage gotoAccounts() {
		Page.driver.findElement(By.linkText("Accounts")).click();

		return new AccountsPage();

	}

	public void gotoActivities() {

	}

	public void signOut() {

	}
}
