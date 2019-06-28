package com.class04;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utils.CommonMethods;

/**
 * Identify Priority of Test Cases

https://www.saucedemo.com/

TC 1: Saucedemo Username1(parameters - username and password)
Step 1: Open browser and navigate to Saucedemo
Step 2: Enter username standard_user and enter password secret_sauce and click login button
Step 3: Verify user successfully logged in

TC 2: Saucedemo Username2(parameters - username and password)
Step 1: Open browser and navigate to Saucedemo
Step 2: Enter username problem_user and enter password secret_sauce and click login button
Step 3: Verify user successfully logged in


Note: Create BeforeMethod and AfterMethod annotations to open browser and logout 
from the application. Create a xml file with parameters username and password .
 * @author ahmetorhan
 *
 */
public class Task3 extends CommonMethods{
	
	@Parameters({"browser","url"})
	@BeforeMethod(alwaysRun=true, groups="Smoke")
	public void SetUp(String chrome, String link) {
		setUpDriver("chrome","https://www.saucedemo.com/");
	}
	
	@Parameters({"userName","passWord"})
	@Test(groups="Smoke",dependsOnMethods="Login2")
	public void Login(String userName, String passWord) {
		sendText(driver.findElement(By.xpath("//input[@id='user-name']")),"userName");
		sendText(driver.findElement(By.xpath("//input[@id='password']")),"passWord");
		driver.findElement(By.cssSelector("input.btn_action")).click();
	}
	
//	@Test(groups ="Regression")
//	public void Login2() {
//		sendText(driver.findElement(By.xpath("//input[@id='user-name']")),"performance_glitch_user");
//		sendText(driver.findElement(By.xpath("//input[@id='password']")),"secret_sauce");
//		driver.findElement(By.cssSelector("input.btn_action")).click();
//	}
	
	@AfterMethod (alwaysRun=true,groups="Smoke")
	public void tearDown() {
		driver.close();
	}

}
