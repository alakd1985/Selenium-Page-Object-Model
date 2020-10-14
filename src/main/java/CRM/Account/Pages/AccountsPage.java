package CRM.Account.Pages;

import org.openqa.selenium.By;

import base.Page;

public class AccountsPage extends Page {

	public CreateAccountPage gotoCreateAccounts() {

		driver.findElement(By.xpath("//lyte-tbody/lyte-tr[@id='table_row_1']/lyte-td[2]/span[1]/link-to[1]/button[1]"))
				.click();
		return new CreateAccountPage();
	}

	public void gotoImportAccounts() {

	}
}
