package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

/**
 * TC 1: Table headers and rows verification

Open chrome browser
Go to “http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx”
Login to the application
Verify customer “Susan McLaren” is present in the table
Click on customer details
Update customers last name
Verify updated customers name is displayed in table
Close browser
 * 
 *
 */
public class Task2 extends CommonMethods {

	public static void main(String[] args) {
		
		setUpDriver("chrome","http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
		
		sendText(driver.findElement(By.cssSelector("input[id$='username']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		List<WebElement> listOfRows=driver.findElements(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr"));
		List<WebElement> listOfColum=driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[1]/th"));
		
		
		String expected="Susan McLaren";
		for(int i=0; i<listOfRows.size(); i++) {
			String textOfRows=driver.findElement(By.xpath("//*[@id=\\\"ctl00_MainContent_orderGrid\\\"]/tbody/tr["+i+"]")).getText();
			if(textOfRows.contains(expected)) {
				driver.findElement(By.xpath("//input[@type='image']")).click();
			}	
		}
		
//		driver.findElement(By.xpath("//input[@value='Susan McLaren']")).
		
		
	}

	

}
