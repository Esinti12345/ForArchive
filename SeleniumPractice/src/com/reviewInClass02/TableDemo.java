package com.reviewInClass02;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.SeleniumMethods;

public class TableDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = SeleniumMethods.getDriverAndOpenURL("chrome", "http://elvery.net/demo/responsive-tables/");

		int indexOfCompany = 0;
		int indexHigh = 0;
		List<WebElement> headers = driver.findElements(By.xpath("//*[@id=\"unseen\"]/table/thead/tr/th"));

		// 1. Use Standard For Loop
//		for (int i = 0; i < headers.size(); i++) {
//			WebElement header = headers.get(i);
//			if (header.getText().equals("High")) {
//				indexHigh = i;
//			} else if (headers.get(i).getText().startsWith("Comp")) {
//				indexOfCode = i;
//			}
//		}

		// 2. Use Enhanced For Loop
		int index = 0;
		for (WebElement header : headers) {
			if (header.getText().equals("High")) {
				indexHigh = index;
			} else if (header.getText().startsWith("Comp")) {
				indexOfCompany = index;
			}
			index++;
		}

		WebElement table = driver.findElement(By.xpath("//*[@id=\"unseen\"]/table"));

		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
//			System.out.println(cells.size());

			// This prints all the cells
//			for (WebElement cell : cells) {
//				System.out.print(cell.getText() + ", ");
//			}
//			System.out.println();

			// This prints only two cells by using index
			if (cells.size() > 2) {
				System.out.println(cells.get(indexOfCompany).getText() + " -> " + cells.get(indexHigh).getText());
			} else {
				System.out.println("This is header");
			}
		}

		Thread.sleep(1000);

		driver.quit();
	}
}