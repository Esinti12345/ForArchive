package com.class09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;

/**
 * TC 2: Verify element is clickable
1. Open chrome browser
2. Go to “https://the-internet.herokuapp.com/”
3. Click on “Click on the “Dynamic Controls” link
4. Select checkbox and click Remove
5. Click on Add button and verify “It's back!” text is displayed 6. Close the browser

 * 
 *
 */
public class Task2 extends CommonMethods{

	public static void main(String[] args) throws InterruptedException {
		setUpDriver("chrome","https://the-internet.herokuapp.com/");
		
		driver.findElement(By.linkText("Dynamic Controls")).click();
		WebElement checkBox=driver.findElement(By.cssSelector("input[type='checkbox']"));
		
		if(checkBox.isEnabled()) {
			checkBox.click();
		}
		
		
		driver.findElement(By.xpath("//button[text()='Remove']")).click();
		
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[onclick='swapCheckbox()']")));
	
		
		WebElement addButton=driver.findElement(By.xpath("//button[text()='Add']"));
		
		wait.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
		
		WebElement element=driver.findElement(By.id("message"));
		wait.until(ExpectedConditions.visibilityOf(element));
		
		System.out.println(element.getText());
		String buttonText=element.getText();
	
		if(buttonText.contains("It's back!")) {
			System.out.println("Text is Displayed");
		}else {
			System.out.println("Text is not Displayed");
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
