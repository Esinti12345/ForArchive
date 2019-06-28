package com.class06;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
 * TC 1: Amazon Department List Verification
Open chrome browser
Go to “http://amazon.com/”
Verify how many department options available.
Print each department
Select Computers
Quit browser
----------------------------------------------------
TC 2: Select and Deselect values
Open chrome browser
Go to “http://uitestpractice.com/”
Click on “Select” tab
Verify how many options available in the first drop down and then select “United states of America”
Verify how many options available in the second drop down and then select all.
Deselect China from the second drop down
Quit browser (edited) 
 */
public class ToDoForYourself {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		WebElement list=driver.findElement(By.cssSelector("select#gh-cat"));
		Thread.sleep(2000);
		Select s=new Select(list);
		List<WebElement> op=s.getOptions();
		System.out.println(op.size());
		for(WebElement ele:op) {
			System.out.println(ele.getText());
			System.out.println("--------------");
			
		}
		
		driver.quit();
		
	}

}
