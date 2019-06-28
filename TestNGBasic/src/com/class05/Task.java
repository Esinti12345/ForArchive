package com.class05;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

/**
 * Identify Priority of Test Cases

http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Process.aspx
TC 1: Saucedemo Username1(Data Provider - Quantity:, Customer name:,Street: City:, State: ,Zip:,Card:,Card Nr:, Expire date )
Step 1: Open browser and navigate to smartbearsoftware
Step 2: Enter valid username, password and click login button
Step 3: Verify user successfully logged in
Step 4: Click on Order
Step 5: Make an order for two user,enter all the information for both users(Quantity:, Customer name:,Street: City:, State: ,Zip:,Card:,Card Nr:, Expire date)
Step 6: Take ScreenShot before submitting each user 
 
 */
public class Task extends CommonMethods{
	
	
	@BeforeMethod
	public void SetUp() {
		
		setUpDriver("chrome","http://secure.smartbearsoftware.com");
		
	}
	
	@Test
	public void Login() {
		sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_username")), "Tester");
		sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_password")), "test");
		driver.findElement(By.cssSelector("input.button")).click();
		
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scr, new File("/Users⁩/ahmetorhan⁩/Documents/Desktop/Upload.png"));
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screesnhot");
		}
		
	}
	

}
