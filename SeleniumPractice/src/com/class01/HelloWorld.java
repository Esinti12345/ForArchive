package com.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", "/Users/Syntax/Selenium/chromedriver");
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://facebook.com");
//		driver.get("https://www.amazon.com");
		
		System.setProperty("webdriver.gecko.driver","/Users/ahmetorhan/eclipse-workspace/SeleniumPractice/src/drivers/chromedriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://google.com");
		
		
	}

}