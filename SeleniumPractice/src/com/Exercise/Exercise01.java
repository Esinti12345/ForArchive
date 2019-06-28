package com.Exercise;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.CommonMethods;

/*
 *  * TC 1: OrangeHRM Login

Navigate to “https://opensource-demo.orangehrmlive.com/”
Login to the application
Verify user is successfully logged in

 */
public class Exercise01 {

	public static void main(String[] args) throws InterruptedException {

		CommonMethods.setUpDriver("Chrome", "https://opensource-demo.orangehrmlive.com/");

		WebElement username = CommonMethods.driver.findElement(By.xpath("//input[@id='txtUsername']"));
		username.clear();
		username.sendKeys("Admin");
		WebElement passWord = CommonMethods.driver.findElement(By.xpath("//input[@id='txtPassword']"));
		passWord.clear();
		passWord.sendKeys("admin123");
		CommonMethods.driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		String verifyUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		try {
			URL url = new URL(verifyUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			int code = conn.getResponseCode();
			if (code == 200) {
				System.out.println("Everything is working properly");
			} else {
				System.out.println("!No Responce. Try later");
			}
		} catch (MalformedURLException e) {

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Thread.sleep(3000);
		CommonMethods.driver.quit();

	}
}
