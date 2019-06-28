package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class task {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
	
		driver.get("http:\\www.syntaxtechs.com");
		Thread.sleep(500);
		driver.navigate().to("https://www.toolsqa.com/automation-practice-form/");
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().refresh();
		String a=driver.getTitle();
		System.out.println(a);
		if(a.contains("Syntax")) {
			System.out.println("This is the rigtht title");
	    }else {
	        System.out.println("sorry this is not the title");
	    
		}
		driver.close();

	}

}
