package com.class07;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import utils.CommonMethods;

public class windows extends CommonMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		CommonMethods.setUpDriver("chrome", "http://uitestpractice.com/Students/Switchto");
		
		String parent = driver.getTitle();
		String parentId = driver.getWindowHandle();
		
		System.out.println("title: " + parent + " " + " ID: " + parentId);
		
		driver.findElement(By.xpath("//a[text()='Opens in a new window']")).click();
		
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println(allWindows);

		for (String window : allWindows) {
			System.out.println("****************");
			System.out.println(window);	 
		}

//		Iterator<String> it = allWindows.iterator();
//		while (it.hasNext()) {
//			String window = it.next();
//			System.out.println("............");
//			System.out.println(window);
//		}

		 Iterator<String> it = allWindows.iterator();
		parent = it.next();
		String child = it.next();
		Thread.sleep(2000);
		driver.switchTo().window(child);
		child = driver.getTitle();
		System.out.println("Child is "+ child);
		String childId = driver.getWindowHandle();
		System.out.println("title: " + child + " " + " ID: " + childId);
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		driver.quit();

	}

}
