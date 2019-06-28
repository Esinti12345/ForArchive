package com.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * TC 2: Swag Labs Negative login:
Open chrome browser
Go to “https://www.saucedemo.com/”
Enter invalid username and password and click login
Verify error message contains: “Username and password do not match any user in this service”
 */
public class Task2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.xpath("//input[@data-test='username']")).sendKeys("something");
		driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("invalid");
		driver.findElement(By.xpath("//input[@value='LOGIN']")).click();
		
		

	}

}
