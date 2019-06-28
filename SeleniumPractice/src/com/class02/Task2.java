package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Task2 {
	public static void main(String[] args) {
		/*TC 2: Syntax Page URL Verification:
		 * Open chrome browser
		 * Navigate to “https://www.syntaxtechs.com/”
		 * Navigate to “https://www.google.com/”
		 * Navigate back to Syntax Technologies Page
		 * Refresh current page
		 * Verify url contains “Syntax”
		 * 
		 */
		
		System.setProperty("webdriver.gecko.driver", "/Users/ahmetorhan/Documents/Selenium/geckodriver");
		WebDriver driver=new FirefoxDriver();
	        driver.navigate().to("https://syntaxtechs.com/");
	        driver.navigate().to("https://google.com");
	        driver.navigate().back();
	        driver.navigate().refresh();
	        String url= "https://syntaxtechs.com//";
	    if (url.contains("syntax")) {
	        System.out.println("Correct");
	    }
	    else {
	        System.out.println("incorrcect");
	    }
	    }
	}
