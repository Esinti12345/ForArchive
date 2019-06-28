package com.class05;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
TC 1: Facebook dropdown verification
Open chrome browser
Go to “https://www.facebook.com”
Verify:
month dd has 12 month options
day dd has 31 day options
year dd has 115 year options
Select your date of birth    
Quit browser
 */
public class Homework2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();

		driver.get("https://www.facebook.com");
		// List<WebElement> months=driver.findElements(By.id("month"));

		WebElement element;

		element = driver.findElement(By.id("month"));

		Select obj = new Select(element);

		List<WebElement> list = obj.getOptions();

		if (list.size() - 1 == 12) {
			System.out.println("Everything is working well");
		} else {
			System.out.println("There is an error");
		}

		
		// System.out.println(list.size());

		element = driver.findElement(By.id("day"));

		Select obj1 = new Select(element);
		List<WebElement> list1 = obj1.getOptions();
		if (list1.size() - 1 == 31) {
			for (WebElement dayList : list1) {
				System.out.println(dayList.getText());
			}
		}

		element = driver.findElement(By.id("year"));

		Select obj2 = new Select(element);
		List<WebElement> list2 = obj.getOptions();
		if (list2.contains("115")) {
			System.out.println("There is a problem");
		} else {
			System.out.println("Ok");
		}

		Thread.sleep(1000);
		driver.quit();

	}

}
