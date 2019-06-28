package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

}
