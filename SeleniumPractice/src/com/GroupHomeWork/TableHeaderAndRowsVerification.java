package com.GroupHomeWork;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import utils.CommonMethods;

public class TableHeaderAndRowsVerification extends CommonMethods{

	public static void main(String[] args) throws InterruptedException{

	setUpDriver("chrome","https://jqueryui.com/");
	//driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[text()='Datepicker']")).click();
	
	driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
	WebElement frame = driver.findElement(By.xpath("//*[@id='content']/iframe"));
	switchToFrame(frame);
	driver.findElement(By.xpath("//*[@id='datepicker']")).click();
	driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[2]/span")).click();
	driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[2]/span")).click();
	driver.findElement(By.xpath("//*[@id=\'ui-datepicker-div\']/div/a[2]/span")).click();
	driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[2]/td[7]/a")).click();
	String a =driver.findElement(By.xpath("//*[@id=\'datepicker\']")).getAttribute("value");
	String expectedDate="08/10/2019";
	if(a.equals(expectedDate)) {
		System.out.println("test is ok");
	}else {System.out.println("false");}
	driver.close();

	
	
		
	}
}
