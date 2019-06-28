package com.reviewInClass01;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.SeleniumMethods;



public class IleriGeri {
	/*
	 * Open chrome browser Go to "http://uitestpractice.com/Students/Switchto" Click
	 * on “Opens in a new window” link inside the page
	 * Find the Id of the second page
	 * Navigate back and forth between the two pages
	 * Close only the current page
	 * Switch to the other page
	 * Close the current page
	 */

	public static void main(String[] args) throws InterruptedException {

//		WebDriver driver = SeleniumMethods.getDriverAndOpenURL("chrome", "http://uitestpractice.com/Students/Switchto");
		WebDriver driver = SeleniumMethods.getDriver("chrome");
		driver.get("http://uitestpractice.com/Students/Switchto");

		String firstPageId = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[text()='Opens in a new window']")).click();

		Set<String> allWindows = driver.getWindowHandles();

		String secondPageId = "";
		for (String Id : allWindows) {
			if (!firstPageId.equals(Id)) {
				secondPageId = Id;
				break;
			}
		}

		driver.switchTo().window(firstPageId);
		Thread.sleep(1000);
		driver.switchTo().window(secondPageId);
		Thread.sleep(1000);
		driver.switchTo().window(firstPageId);
		Thread.sleep(1000);
		driver.switchTo().window(secondPageId);
		Thread.sleep(1000);
		driver.switchTo().window(firstPageId);
		Thread.sleep(1000);
		driver.switchTo().window(secondPageId);
		Thread.sleep(1000);
		driver.switchTo().window(firstPageId);
		Thread.sleep(1000);
		driver.switchTo().window(secondPageId);
		Thread.sleep(1000);

		driver.close();// Closes only current tab
		Thread.sleep(1000);

		driver.switchTo().window(firstPageId); // You have to switch to the other page before closing it!!!
		driver.close();// Closes the current tab
	}
}
