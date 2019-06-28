package com.reviewInClass02;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

import utils.CommonMethods;

public class FluentWaitDemo extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		String url = "https://the-internet.herokuapp.com/";
		setUpDriver("chrome", url);

		String text = "Dynamic Controls";
		driver.findElement(By.linkText(text)).click();

		String buttonXpath = "//button[text()='Enable']";
		driver.findElement(By.xpath(buttonXpath)).click();

//		Thread.sleep(7000);
//		WebElement el = driver.findElement(By.xpath("//*[@id='input-example']/input"));
//		el.sendKeys("Thread");

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(ElementNotInteractableException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				WebElement element = driver.findElement(By.xpath("//*[@id='input-example']/input"));
				element.sendKeys("FluentWait");
				return element;
			}
		});

		Thread.sleep(2000);
		driver.quit();
	}
}