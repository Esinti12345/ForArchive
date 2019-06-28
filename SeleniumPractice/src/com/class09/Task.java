package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

/**
 * 
 *TC 1: Verify element is present
Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Dynamic Loading” link
Click on “Example 1...” and click on “Start”
Verify element with text “Hello World!” is displayed
Close the browser
 *
 */
public class Task extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		
		setUpDriver("chrome","https://the-internet.herokuapp.com/");
		
		
		driver.findElement(By.linkText("Dynamic Loading")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]")).click();
		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		WebElement el=driver.findElement(By.xpath("//h4[text()='Hello World!']"));
		
		if(el.isDisplayed()) {
			String text=el.getText();
			System.out.println(text);
		}else {
			System.out.println("Hello World is not found");
		}
		
		
		
		Thread.sleep(3000);
		driver.close();
	}

}
