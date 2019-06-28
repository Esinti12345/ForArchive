package com.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSALertHandling {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().fullscreen(); 
		driver.get("http://uitestpractice.com");

		// click on Switch link & alert button
		driver.findElement(By.linkText("Switch to")).click();
		driver.findElement(By.id("alert")).click();
		
		// switch to the alert window
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		driver.findElement(By.id("confirm")).click();
		Alert confirmAlert=driver.switchTo().alert();
		String textOfAlert=confirmAlert.getText();
		System.out.println(textOfAlert);
		confirmAlert.dismiss();
		
		
		driver.findElement(By.id("prompt")).click();
		Alert promptAlert=driver.switchTo().alert();
		//getting text of alert
		System.out.println("Text of prompt alert = "+promptAlert.getText());
		promptAlert.sendKeys("Hello");
		

		Thread.sleep(3000);
		driver.quit();

	}

}
