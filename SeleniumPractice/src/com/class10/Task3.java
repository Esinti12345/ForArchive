package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

/**
 *  Table headers and rows verification
1. Open browser and go to “http://secure.smartbearsoftware.com/samples/testcomplete11 /WebOrders/login.aspx”
2. Login to the application
3. Create an Order
4. Verify order of that person is displayed in the table “List of All
Orders”
5. Click on edit of that specific order
6. Verify each order details
7. Update street address
8. Verify in the table that street has been updated
9. Close browser
 */
public class Task3 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		
	setUpDriver("chrome","http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
    driver.findElement(By.cssSelector("#ctl00_MainContent_username")).sendKeys("tester");
    driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys("test");
	driver.findElement(By.xpath("//input[@value='Login']")).click();
	
	List<WebElement> listOfNames=driver.findElements(By.xpath("//*[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[2]"));
	for(WebElement list:listOfNames) {
		String name=list.getText();
		System.out.println(name);
		String expected="Paul Brown";
		
		if(name.contains(expected)) {
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[13]/input")).click();
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys("Paul Abc");
			driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]")).click();
			break;
		}
	}
	
		
	
	
	
	
	Thread.sleep(500);
	driver.quit();
	
	
	
	}

}
