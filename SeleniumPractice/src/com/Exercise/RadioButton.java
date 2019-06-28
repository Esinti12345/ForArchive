package com.Exercise;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.toolsqa.com/automation-practice-form/");
		driver.manage().window().maximize();

		//String selected="Male";
		
		List<WebElement> radiobutton = driver.findElements(By.xpath("//input[@name='sex']"));//(By.name("sex"))
		for (WebElement Radio : radiobutton) {
			if (Radio.isEnabled()) {
				String Value = Radio.getAttribute("value");
				System.out.println(Value);
				if (Value.equals("Male")) {
					Radio.click();
				}
			}

		}
		Thread.sleep(500);
		driver.quit();
	}
}