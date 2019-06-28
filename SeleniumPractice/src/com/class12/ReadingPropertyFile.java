package com.class12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utils.CommonMethods;
import utils.SeleniumMethods;

public class ReadingPropertyFile {

	Properties prop;
	
	@Test
	public void readFile() {
		
		String filePath="src/configs/credentials.properties";
		
		try {
			FileInputStream fis=new FileInputStream(filePath);
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(prop.getProperty("browser"));
		System.out.println(prop.getProperty("url"));
		
//		WebDriver driver2 = SeleniumMethods.getDriverAndOpenURL(prop.getProperty("browser"), prop.getProperty("url"))
		WebDriver driver1 = SeleniumMethods.getDriver(prop.getProperty("browser"));
		driver1.get(prop.getProperty("url"));
//		driver1.findElement()
		
		CommonMethods.setUpDriver(prop.getProperty("browser"), prop.getProperty("url"));
//		CommonMethods.driver.findElement()
		CommonMethods.driver.quit();
	}
}
