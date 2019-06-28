package com.reviewInClass01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumMethods;



public class Iframe {

	public static void main(String[] args) throws InterruptedException {

//		You can get the driver and then open the page OR you can do it by calling just one method
		
//		WebDriver driver = SeleniumMethods.getDriver("chrome");
//		driver.get("http://uitestpractice.com/Students/Switchto");
		WebDriver driver = SeleniumMethods.getDriverAndOpenURL("chrome", "http://uitestpractice.com/Students/Switchto");

		WebElement el = driver.findElement(By.cssSelector("iframe[name='iframe_a']"));
		driver.switchTo().frame(el);
		Thread.sleep(1000);

		WebElement el2 = driver.findElement(By.xpath("//input[@type='text']"));
		el2.sendKeys("Tom");
		Thread.sleep(1000);

		driver.switchTo().defaultContent();// You have to switch to the main page before closing it!!!
		driver.close();
	}
}