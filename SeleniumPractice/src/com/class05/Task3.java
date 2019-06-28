package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * TC 1: Amazon link count:
Open chrome browser
Go to “https://www.amazon.com/”
Using Iterator get text of each link
Get number of links that has text
 */
public class Task3 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().fullscreen();
		driver.get("https://www.amazon.com/");

		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));

		System.out.println(listOfLinks.size());

		int count = 0;
		Iterator<WebElement> it = listOfLinks.iterator();

		while (it.hasNext()) {
			WebElement e = it.next();
			String textLink = e.getText();

			if (!textLink.isEmpty()) {
				System.out.println(textLink);
				count++;
			}
		}
		driver.quit();
	}

}
