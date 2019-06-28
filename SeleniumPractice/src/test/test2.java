package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class test2 {

	
		public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
			WebDriver driver=new ChromeDriver();
		    driver.navigate().to("http://google.com");
		    driver.navigate().to("http://www.amazon.com");
		    System.out.println(driver.getTitle());
		    String title=driver.getTitle();
		    if(title.equalsIgnoreCase("amazon.com")) {
		        System.out.println("Correct title ");
		    }else {
		        System.out.println("incorrect title");
		    }
	}

}
