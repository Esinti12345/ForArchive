package com.class04;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class Task2 extends CommonMethods{

	
	@BeforeMethod(alwaysRun=true, groups="Smoke")
	public void SetUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
	}

	@Test(groups="Smoke",dependsOnMethods="Login2")
	public void Login() {
		sendText(driver.findElement(By.xpath("//input[@id='user-name']")),"problem_user");
		sendText(driver.findElement(By.xpath("//input[@id='password']")),"secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
	}
	
	@Test(groups ="Regression")
	public void Login2() {
		sendText(driver.findElement(By.xpath("//input[@id='user-name']")),"performance_glitch_user");
		sendText(driver.findElement(By.xpath("//input[@id='password']")),"secret_sauce");
		driver.findElement(By.cssSelector("input.btn_action")).click();
	}
	
	@AfterMethod (alwaysRun=true,groups="Smoke")
	public void tearDown() {
		driver.close();
	}
	
}
