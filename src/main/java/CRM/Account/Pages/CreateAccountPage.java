package CRM.Account.Pages;

import org.openqa.selenium.By;

import base.Page;

public class CreateAccountPage extends Page {
	public void crateAccount(String AccountName) {
		driver.findElement(By.xpath("//input[@id='Crm_Accounts_ACCOUNTNAME']")).sendKeys(AccountName);
	}

}
