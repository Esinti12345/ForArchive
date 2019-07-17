package com.GroupHomeWork;

import java.util.List;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class foursquare_attribution {

	public static void main(String[] args) {

		

		System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/eclipse-workspace/SeleniumPractice/src/drivers/chromedriver");
		System.out.println("Baslangic");
		WebDriver driver = new ChromeDriver();
		System.out.println(driver.getTitle());
		driver.get("https://foursquare.com/");

		

		System.out.println("Baslangic1");

			//driver.switchTo().frame(hpa.iframe);

		
		Actions action = new Actions(driver = new ChromeDriver());
		driver.navigate().refresh();
		System.out.println("Baslangic2");
		WebElement products = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[3]/div[1]"));

		action.moveToElement(products).build();
		System.out.println("Baslangic3");
			System.out.println(products.getText());
		

		// hpa.products.click();

		Select obj = new Select(products);
		List<WebElement> allOptions = obj.getOptions();
		for (WebElement option : allOptions) {
			String optionText = option.getText();
			if (optionText.equals("Attribution")) {
				obj.selectByVisibleText("Attribution");
			}
		}

	}

}
