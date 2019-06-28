package com.reviewInClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

public class CalendarDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://jqueryui.com/datepicker/";
		setUpDriver("chrome", url);

		// store frame element and then switch
		WebElement frame = driver.findElement(By.cssSelector("iframe.demo-frame"));
		switchToFrame(frame);

		driver.findElement(By.id("datepicker")).click();

		WebElement element;
		for (int i = 0; i < 5; i++) {
			Thread.sleep(1000);
			element = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span"));
			element.click();
		}

		Thread.sleep(3000);
		driver.quit();
	}
}
