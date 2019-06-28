package com.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utils.CommonMethods;

/*
 * TC 1: OrangeHRM Title Validation

TC 2: OrangeHRM Successful Login 
https://opensource-demo.orangehrmlive.com/
Please make sure to use the following:
 annotations:
	@BeforeMethod
	@AfterMethod
	@Test

What would you do if you do not want to execute any specific test case?
What would you do if you want to execute any specific test case first?
 */
public class TaskToDoYourself {
	
	//WebDriver driver=new ChromeDriver();
	
	
	@BeforeClass 
	
	public void setUp() {
		CommonMethods.setUpDriver("chrome","https://opensource-demo.orangehrmlive.com");

	}
	
	@Test (enabled=true)
	public void verifyTitle() {
		boolean verified=CommonMethods.driver.findElement(By.xpath("/html/head/title")).isDisplayed();
		
		if(verified=true) {
			System.out.println("Title is active");
		}else {
			System.out.println("Title is not enabled");
		}
	}
	
	@Test (enabled=true, priority=1)
	public void firstName() {
		WebElement firstName=CommonMethods.driver.findElement(By.xpath("//input[@id=\"txtUsername\"]"));
		firstName.clear();
		firstName.sendKeys("Admin");
		
		
	}
	
	@Test (enabled=true, priority=2)
	public void verifyPassword() {
		WebElement passWord=CommonMethods.driver.findElement(By.xpath("//input[@id=\"txtPassword\"]"));
		passWord.clear();
		passWord.sendKeys("admin123");
		CommonMethods.driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	}
	
	@AfterMethod (enabled=true)
	public void exit() throws InterruptedException {
		Thread.sleep(3000);
		CommonMethods.driver.quit();
	}

	
}
