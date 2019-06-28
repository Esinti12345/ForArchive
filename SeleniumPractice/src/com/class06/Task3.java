package com.class06;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
/*
 * TC 1: JavaScript alert text verification
Open chrome browser
Go to “https://www.seleniumeasy.com/test/javascript-alert-box-demo.html”
Verify
alert box with text “I am an alert box!” is present
confirm box with text “Press a button!” is present
prompt box with text “Please enter your name” is present
Quit browser
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		
		/////////////////////
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[1]/div[2]/button")).click();
		Alert alert=driver.switchTo().alert();
		//Before we have to get message from the alert to check whether it exists or not
		String text = alert.getText();
		
		System.out.println(text);
		if(text.equals("I am an alert box!")) {
			System.out.println("It is present");
		}else {
			System.out.println("It is not present");
		}
		Thread.sleep(2000);
		alert.accept();
		
		//////////////////////
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/button")).click();
		//Alert alert2=driver.switchTo().alert();
		String text2=alert.getText();
		System.out.println(text2);
		if(text2.equals("Press a button!")) {
			System.out.println("It is present");
		}else {
			System.out.println("It is not present");
		}
		Thread.sleep(2000);
		alert.accept();
		
		////////////////////
		driver.findElement(By.xpath("//*[@id=\"easycont\"]/div/div[2]/div[3]/div[2]/button")).click();
		//Alert alert3=driver.switchTo().alert();
		String text3=alert.getText();
		System.out.println(text3);
		if(text3.equals("Please enter your name")) {
			System.out.println("It is present");
		}else {
			System.out.println("It is present");
		}
		Thread.sleep(2000);
		alert.accept();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
