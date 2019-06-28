package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * TC 1: Tools QA check all elements
Open chrome browser
Go to “https://www.toolsqa.com/automation-practice-form/”
Fill out:
First Name
Last Name
Check that sex radio buttons are enabled and select “Male”
Check all Years of Experience radio buttons are clickable
Date
Select both checkboxes for profession
Check all Automation Tools checkboxes are clickable and keep “Selenium WebDriver” option as selected
Quit browser

 */
public class HomeWork {

	static String firstName = "Jane";
	static String lastName = "Eyre";

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();

		String url = "https://www.toolsqa.com/automation-practice-form/";
		driver.get(url);
		// finding element by tagname
		// driver.findElement(By.name("firstname")).sendKeys(firstName);

		// finding element by xpath
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);

		// finding element by Css
		// driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(firstName);

		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(lastName);

		List<WebElement> list = driver.findElements(By.name("sex"));

		String expected = "Male";
		for (WebElement gender : list) {

			if (gender.isEnabled()) {

				String value = gender.getAttribute("value");

				if (value.equals(expected)) {

					gender.click();
					Thread.sleep(500);
				}
			}
		}

		List<WebElement> listOfYear = driver.findElements(By.name("exp"));

		for (WebElement year : listOfYear) {
			if (year.isEnabled()) {
				year.click();
			}
			Thread.sleep(500);
		}

		List<WebElement> listOfPro = driver.findElements(By.name("profession"));

		Iterator<WebElement> it = listOfPro.iterator();

		while (it.hasNext()) {
			WebElement pro = it.next();
			if (pro.isEnabled()) {
				pro.click();
				Thread.sleep(500);
			}
		}

		List<WebElement> listOfTool = driver.findElements(By.xpath("//input[@name='tool']"));

		for (WebElement tool : listOfTool) {

			String automationTools = tool.getAttribute("value");

			if (tool.isEnabled()) {
				System.out.println(automationTools + " is clickable");
			}
			if (automationTools.equals("Selenium Webdriver")) {
				System.out.println(automationTools);
				tool.click();

				Thread.sleep(500);
			}

		}

		Thread.sleep(5000);
		driver.quit();
	}

}
