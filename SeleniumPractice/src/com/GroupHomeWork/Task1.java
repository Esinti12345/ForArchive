package com.GroupHomeWork;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.CommonMethods;

/**
 * C 1: Users Application Form Fill
1. Open chrome browser
2. Go to “http://uitestpractice.com/”
3. Click on “Forms” link
4. Fill out the entire form
5. Close the browser
MUST USE Functions:
 
 */
public class Task1 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
	
		
		setUpDriver("chrome","http://uitestpractice.com/");
		
		driver.findElement(By.xpath("//a[@href='/Students/Form']")).click();
		//FirstName
		WebElement firstName=driver.findElement(By.xpath("//input[@id='firstname']"));
		firstName.clear();
		firstName.sendKeys("Mary");
		//LastName
		WebElement lastName=driver.findElement(By.xpath("//input[@id='lastname']"));
		lastName.clear();
		lastName.sendKeys("Holy");
		//Marial Status
		WebElement married=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[3]/label[2]"));
		married.click();
		//Hobby		
		WebElement cricket=driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[4]/label[4]"));
		cricket.click();
		//Country
		WebElement country=driver.findElement(By.xpath("//*[@id=\"sel1\"]"));
		Select select=new Select(country);
		select.selectByVisibleText("Canada");
		//Calendar
	    driver.findElement(By.id("datepicker")).click();
		String expectedDate="25";
		List <WebElement> cells=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
		for (WebElement cell: cells) {
			String cellText=cell.getText();
			if (cellText.equals(expectedDate)) {
				cell.click();
			}
		}
		//PhoneNumber
		WebElement phoneNumber=driver.findElement(By.xpath("//input[@id='phonenumber']"));
		sendText(phoneNumber,"2014568932");
		//UserName
		WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
		sendText(userName,"marymary");
		//Email
		WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
		sendText(email,"mary@gmail.com");
		//Comment
		WebElement comment=driver.findElement(By.xpath("//*[@id=\"comment\"]"));
		String mySelf="I’m currently an account executive at Smith, where I handle our top performing client. "
				+ "Before that, I worked at an agency where I was on three different major national healthcare "
				+ "brands. ";
		sendText(comment,mySelf);
		//Password
		WebElement password=driver.findElement(By.xpath("//input[@id='pwd']"));
		sendText(password,"999888");
		Thread.sleep(1000);
		//Submit
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/form/div[12]/div/button")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
