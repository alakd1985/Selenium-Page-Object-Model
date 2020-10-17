package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.ExcelReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	// public ExtentReports reports = ExtentManager.getInstance();
	public static TopMenu menu;

	public Page() {
		if (driver == null) {

			{
				try {
					fis = new FileInputStream(".\\src\\test\\resources\\properties\\Config.properties");
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
				try {
					config.load(fis);
					log.debug("config file loaded!!!");

				} catch (IOException e) {

					e.printStackTrace();
				}

				try {
					fis = new FileInputStream(".\\src\\test\\resources\\properties\\OR.properties");
				} catch (FileNotFoundException e) {

					e.printStackTrace();
				}
				try {
					or.load(fis);
					log.debug("or file loaded!!!");
				} catch (IOException e) {

					e.printStackTrace();
				}

				if (config.getProperty("browser").equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();

					driver = new FirefoxDriver();

				}
				if (config.getProperty("browser").equals("chrome")) {
					WebDriverManager.chromedriver().setup();

					Map<String, Object> prefs = new HashMap<String, Object>();

					prefs.put("profile.default_content_setting_values.notifications", 1);

					prefs.put("credentials_enable_service", false);

					prefs.put("profile.password_manager_enabled", false);

					ChromeOptions options = new ChromeOptions();

					options.setExperimentalOption("prefs", prefs);

					options.addArguments("--disable-extensions");

					options.addArguments("--disable-infobars");

					driver = new ChromeDriver(options);
					log.debug("chrome file loaded!!!");
				}

				driver.get(config.getProperty("testsiteurl"));

				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
						TimeUnit.SECONDS);
				wait = new WebDriverWait(driver, 15);
				menu = new TopMenu(driver);
			}
		}
	}

	// key word

	public static void click(String locator) {
		if (locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(or.getProperty(locator))).click();
		} else if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(or.getProperty(locator))).click();
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(or.getProperty(locator))).click();
		}

		else if (locator.endsWith("_name")) {
			driver.findElement(By.name(or.getProperty(locator))).click();
		} else if (locator.endsWith("_linktext")) {
			driver.findElement(By.linkText(or.getProperty(locator))).click();
		}

		log.debug("Clicking on an Element : " + locator);

	}

	// Table Properties
	static List<WebElement> row;

	public void tab(String locator, String locator2) {
		if (locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(or.getProperty(locator)));
			row = driver.findElements(By.tagName(or.getProperty(locator2)));

		} else if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(or.getProperty(locator)));
			row = driver.findElements(By.tagName(or.getProperty(locator2)));

		} else if (locator.endsWith("_name")) {
			driver.findElement(By.name(or.getProperty(locator)));
			row = driver.findElements(By.tagName(or.getProperty(locator2)));

		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(or.getProperty(locator)));
			row = driver.findElements(By.tagName(or.getProperty(locator2)));

		}

		for (WebElement e : row) {
			String actual = e.getText();
			System.out.println(actual);
		}

	}

	// type Method

	public static void type(String locator, String value) {
		if (locator.endsWith("_css")) {

			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);

		} else if (locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_name")) {
			driver.findElement(By.name(or.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
		}
		log.debug("Typing in an Element : " + locator + " entered value as : " + value);
	}

	// Select Method

	static WebElement dropdown;

	public static void select(String locator, String value) {
		if (locator.endsWith("_css")) {
			dropdown = driver.findElement(By.cssSelector(or.getProperty(locator)));
		} else if (locator.endsWith("_xpath")) {
			dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
		} else if (locator.endsWith("_name")) {
			dropdown = driver.findElement(By.name(or.getProperty(locator)));
		} else if (locator.endsWith("_id")) {
			dropdown = driver.findElement(By.id(or.getProperty(locator)));
		}

		Select select = new Select(dropdown);
		select.selectByVisibleText(value);

		log.debug("Selecting from an element : " + locator + " value as : " + value);

	}

	public static void quit() {
		driver.quit();
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}