package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

	public void gotoAccounts() {
		Page.driver.findElement(By.linkText("Accounts")).click();

	}

	public void gotoActivities() {

	}

	public void signOut() {

	}
}
