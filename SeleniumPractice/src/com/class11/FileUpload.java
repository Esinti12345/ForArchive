package com.class11;


		import org.openqa.selenium.By;
		import org.testng.annotations.Test;

		import utils.CommonMethods;

		public class FileUpload extends CommonMethods{

			public static void main(String[] args) throws InterruptedException {
				
				String url="http://the-internet.herokuapp.com";
				setUpDriver("chrome", url);
				
				driver.findElement(By.linkText("File Upload")).click();
				Thread.sleep(3000);
				
				String filePath="/Users/Syntax/Desktop/UploadFile.jpg";
				driver.findElement(By.id("file-upload")).sendKeys(filePath);
				driver.findElement(By.id("file-submit")).click();
				
				boolean isDisplayed=driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed();
				
				if (isDisplayed) {
					System.out.println("File uploaded successfully");
				}else {
					System.out.println("File uploaded successfully");
				}
				
				Thread.sleep(2000);
				driver.quit();

			}
		

	}


