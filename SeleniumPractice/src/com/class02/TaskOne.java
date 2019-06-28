package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskOne {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https;//www.amazon.com");
		String title=driver.getTitle();
		String actual=title;
		String expected="Amazon.com: Online Shopping for Electronics, Apperal";
		if(expected.equalsIgnoreCase(actual)) {
			System.out.println("valid title");
		}else {
			System.out.println("invalid title");
		}
        driver.quit();
	}

}
