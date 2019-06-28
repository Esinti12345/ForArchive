package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utils.CommonMethods;

/**
 * TC 1: Table headers and rows verification

Open chrome browser
Go to “https://the-internet.herokuapp.com/”
Click on “Click on the “Sortable Data Tables” link

Verify tables consist of 4 rows and 6 columns
Print name of all column headers
Print data of all rows
 *
 *
 */
public class Task1 extends CommonMethods{

	public static void main(String[] args) {
		setUpDriver("chrome","https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		
	
		List<WebElement> listOfRows=driver.findElements(By.xpath("//*[@id=\"table1\"]/tbody/tr"));
		
		
		List<WebElement> listOfColum=driver.findElements(By.xpath("//*[@id=\"table1\"]/thead/tr/th"));
 
		System.out.println(listOfRows.size());
		
		driver.quit();
	}

}
