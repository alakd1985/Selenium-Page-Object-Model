package pages;

import org.openqa.selenium.By;

import base.Page;

public class LoginPage extends Page {

	public zohoAppPage doLogin(String username, String password) {

		driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys(username);
		driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();

		return new zohoAppPage();
	}
}
