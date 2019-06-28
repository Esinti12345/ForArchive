package com.class11;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.CommonMethods;

/**
 * TC 1: Upload file and Take Screenshot
 * 
 * Navigate to
 * “http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload”
 * Upload file Verify file got successfully uploaded and take screenshot
 *
 */
public class TaskToDoYourself {

	static String expectedText="File Uploaded!";

	public static void main(String[] args) {

		String url="http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwFileUpload";
		CommonMethods.setUpDriver("chrome", url);
		
		TakesScreenshot ts=(TakesScreenshot)CommonMethods.driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		
		String scrPath="⁨/Users⁩/ahmetorhan⁩/Documents/uploadFile.png⁩";
		CommonMethods.driver.findElement(By.cssSelector("input.gwt-FileUpload")).sendKeys(scrPath);
		
		CommonMethods.driver.findElement(By.cssSelector("button.gwt-Button")).click();
		
		Alert al=CommonMethods.driver.switchTo().alert();
		
		String alertText=al.getText();
		
		if(alertText.equals(expectedText)) {
			
			System.out.println("File Is Uploaded");
			
		}else {
			System.out.println("File is not Uploaded");
		}
		al.accept();
		
		TakesScreenshot ts1=(TakesScreenshot)CommonMethods.driver;
		
		File scr1=ts1.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scr1, new File("/Users⁩/ahmetorhan⁩/Documents/Desktop/Upload.png"));
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screesnhot");
		}
		
		
		CommonMethods.driver.quit();
		
		
	}

}
