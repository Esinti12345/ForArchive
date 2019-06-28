package com.class03;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

/**
 * TC 2: Saucedemo Username2(tag the groups - Smoke2, Regression2)
 * Step 1: Open browser and navigate to Saucedemo
 * Step 2: Enter username problem_user and enter password secret_sauce and click login button 
 * Step 3: Verify user successfully logged in
 * Note: Create BeforeMethod and AfterMethod annotations to open browser and logout from the application. 
 * Create a xml file and include smoke1, regression2 and exclude smoke2, regression1.
 * @author ahmetorhan
 *
 */
public class Task2 extends CommonMethods{
	
	@BeforeMethod
	public void SetUp() {
		setUpDriver("chrome","https://www.saucedemo.com/");
	}

	@Test
	public void Login() {
		sendText(driver.findElement(By.xpath("//input[@id='user-name']")),"problem_user");
		sendText(driver.findElement(By.xpath("//input[@id='password']")),"secret_sauce");
		driver.findElement(By.xpath("input.btn_action")).click();
	}
	
	@Test
	public void verifyPage() {
		String verifyURL = "https://www.saucedemo.com/inventory.html";
		try {
			URL url = new URL(verifyURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			int pageCode = connection.getResponseCode();
			if (pageCode == 200) {
				System.out.println("Everything is working properly");
			} else {
				System.out.println("!No Responce. Try later");
			}
		} catch (MalformedURLException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void teatDown() {
		driver.quit();
	}
}
