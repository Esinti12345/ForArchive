package com.class10;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

/**
 * 1. Open chrome browser
2. Go to “https://jqueryui.com/”
3. Click on “Datepicker”
4. Select August 10 of 2019
5. Verify date “08/10/2019” has been entered succesfully
6. Close browser
 */
public class Task4 extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		setUpDriver("chrome","https://jqueryui.com/");
		
		Thread.sleep(800);
		driver.findElement(By.xpath("//a[text()='Datepicker']")).click();
		
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
		driver.switchTo().frame(ele);
		driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
		Thread.sleep(800);
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click();
		   
//		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/span[1]"));
//		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[7]/a")).click();
//		
		
//		driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
//		
//		
//		WebElement dateWidgetFrom = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody"));
//		 List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
//		
//		
//		
//		//List<WebElement> dates=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div"));
//		
//		for(WebElement date:columns) {
//			System.out.println(date.getText());
//		}
		
		
		
		
Thread.sleep(2000);
driver.quit();
	}

}
