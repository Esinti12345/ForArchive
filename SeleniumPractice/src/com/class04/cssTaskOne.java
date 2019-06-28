package com.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssTaskOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/Syntax/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.xpath("//a[text()='REGISTER']")).click();
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("bob");
		driver.findElement(By.cssSelector("input[name*='last']")).sendKeys("tom");
		driver.findElement(By.cssSelector("input#email")).sendKeys("test");
		driver.findElement(By.cssSelector("input[name^='pass']")).sendKeys("123");
		driver.findElement(By.cssSelector("input[name$='Password']")).sendKeys("123");
		driver.findElement(By.cssSelector("input[name='register']")).click();

	}

}