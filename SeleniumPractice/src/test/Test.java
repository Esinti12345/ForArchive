package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
	
		//Driver.get("http:\\www.google.com");
		
		System.setProperty("webdriver.gecko.driver", "/Users/ahmetorhan/Documents/Selenium/geckodriver");
		WebDriver Driver1=new FirefoxDriver();
		//Driver1.get("http:\\www.google.com");
	}

}
