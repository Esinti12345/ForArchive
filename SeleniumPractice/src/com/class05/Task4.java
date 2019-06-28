package com.class05;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * * Check all Years of Experience radio buttons are clickable
* -----------------------------------------------
* Check all Automation Tools checkboxes are clickable
* and keep “Selenium WebDriver” option as selected
 */
public class Task4 {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().fullscreen();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		List<WebElement> radioButton=driver.findElements(By.xpath("//input[@name='exp']"));
		
		for(WebElement listOfButton:radioButton){
			
			listOfButton.click();
			Thread.sleep(700);
			System.out.println(listOfButton.isSelected());
			
		
			
			
		}
		Thread.sleep(6000);
		driver.quit();
		
		/* Aselin cozumu
		 * 
		 * public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/Syntax/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		
		List<WebElement> radioExp=driver.findElements(By.xpath("//input[@name='exp']"));
		for (WebElement radio: radioExp) {
			if(radio.isEnabled()) {
				radio.click();
				Thread.sleep(2000);
			}
		}
		driver.quit();
		 */

	}

}
