package com.class06;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * TC 1: Amazon Department List Verification
Open chrome browser
Go to “http://amazon.com/”
Verify how many department options available.
Print each department
Select Computers
Quit browser

 */
public class Task1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().fullscreen(); 
		driver.get("http://amazon.com/");
		WebElement element = driver.findElement(By.id("searchDropdownBox"));

		Select select = new Select(element);
		
		List<WebElement> allOptions = select.getOptions();
		System.out.println(allOptions.size());
	
		
		String computers = "Computers";
		System.out.println("------For ile option-------------");
		for (WebElement option : allOptions) {
			System.out.println(option.getText());
			if (option.getText().equals(computers)) {
				option.click();
			}
		}

		Thread.sleep(1000);
		System.out.println("------Iterator ile option-------------");
		Iterator<WebElement> it = allOptions.iterator();
		while (it.hasNext()) {
			WebElement option = it.next();
			if (option.getText().equals(computers)) {
				option.click();
			}
		}

		Thread.sleep(2000);
		driver.quit();

	}

}
