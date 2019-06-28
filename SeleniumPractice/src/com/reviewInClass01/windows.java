package com.reviewInClass01;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class windows extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		
		CommonMethods.setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");

		String firstPageId = driver.getWindowHandle();
		System.out.println("This is firstPage id " +firstPageId);

		driver.findElement(By.xpath("//a[text()='Opens in a new window']")).click();

		Set<String> allWindows = driver.getWindowHandles();

		// Ikinci sayfayi bulup ona gecmek.
		for (String Id : allWindows) {
			if (!firstPageId.equals(Id)) {
				driver.switchTo().window(Id);
				break;
			}
		}
		Thread.sleep(2000);

		// This two loops are the same. One is done with Enhanced FOR LOOP, the other is
		// done with ITERATOR
//		FOR LOOP
//		for(String window:allWindows) {
//			
//		}	

//		ITERATOR
//		Iterator<String> it = allWindows.iterator();
//		while (it.hasNext()) {
//			String window = it.next();
//			
//		}

		System.out.println("Enhanced For loop");
		for (String Id : allWindows) {
			driver.switchTo().window(Id);
			String title = driver.getTitle();
			System.out.println("title: " + title + " " + " ID: " + Id);

			Thread.sleep(1000);
		}

		System.out.println("Iterator");
		Iterator<String> it = allWindows.iterator();
		while (it.hasNext()) {
			String Id = it.next();
			driver.switchTo().window(Id);
			String title = driver.getTitle();
			System.out.println("title: " + title + " " + " ID: " + Id);

			Thread.sleep(1000);
		}

		driver.quit();
	}
}