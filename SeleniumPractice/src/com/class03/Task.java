package com.class03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * TC 1: Facebook login:
Open chrome browser
Go to “https://www.facebook.com/”
Enter valid username and valid password and click login
User successfully logged in

TC 2: Mercury Tours Registration:
Open chrome browser
Go to “http://newtours.demoaut.com/”
Click on Register Link
Fill out all required info
Click Submit
User successfully registered
(Create 2 scripts using different locators)
 */
public class Task {

	public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
     WebDriver driver=new ChromeDriver();
     driver.navigate().to("http://newtours.demoaut.com/");
     Thread.sleep(3000);
     driver.findElement(By.linkText("REGISTER")).click();
     Thread.sleep(2000);
     driver.findElement(By.name("firstName")).sendKeys("Ela");
     Thread.sleep(2000);
     driver.findElement(By.name("lastName")).sendKeys("Germin");
     Thread.sleep(2000);
     driver.findElement(By.name("phone")).sendKeys("434537678");
     Thread.sleep(2000);
     driver.findElement(By.id("userName")).sendKeys("elagermin@gmail.com");
     Thread.sleep(2000);
     driver.findElement(By.name("address1")).sendKeys("Versingo");
     Thread.sleep(2000);
     driver.findElement(By.name("address2")).sendKeys("Flowers");
     Thread.sleep(2000);
     driver.findElement(By.name("city")).sendKeys("FortLee");
     Thread.sleep(2000);
     driver.findElement(By.name("state")).sendKeys("New Jersey");
     Thread.sleep(2000);
     driver.findElement(By.name("postalCode")).sendKeys("07356");
     Thread.sleep(2000);
     driver.findElement(By.name("country")).click();
     Thread.sleep(2000);
     driver.findElement(By.id("email")).sendKeys("elagermin@gmail.com");
     Thread.sleep(2000);
     driver.findElement(By.name("password")).sendKeys("asdfghj56789");
     Thread.sleep(2000);
     driver.findElement(By.name("confirmPassword")).sendKeys("asdfghj56789");
     Thread.sleep(2000);
     driver.findElement(By.name("register")).click();
     Thread.sleep(2000);
     
     
     
     
     
     
     
     
     
	}

}
