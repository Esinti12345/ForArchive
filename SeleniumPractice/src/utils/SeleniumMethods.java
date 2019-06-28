package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumMethods {

	private static void setProperty(String browser) {
		if (browser.equalsIgnoreCase("chrome"))
			System.setProperty("webdriver.chrome.driver", "/Users/elionlimanaj/Projects/Selenium/chromedriver");
		else if (browser.equalsIgnoreCase("firefox"))
			System.setProperty("webdriver.gecko.driver", "/Users/elionlimanaj/Projects/Selenium/geckodriver");
	}

	public static WebDriver getDriver(String browser) {
		setProperty(browser);

		WebDriver driver;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("wrong browser");
			return null;
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getDriverAndOpenURL(String browser, String url) {
		WebDriver driver = getDriver(browser);
		driver.get(url);
		return driver;
	}
}