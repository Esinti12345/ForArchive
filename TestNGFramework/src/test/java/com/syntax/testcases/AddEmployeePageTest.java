package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass_OldOne;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddEmployeePageTest extends BaseClass_OldOne {

	@Test
	public void addEmployee() throws InterruptedException {

		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddEmployeePage addEmp = new AddEmployeePage();

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		CommonMethods.click(addEmp.PIM);
		CommonMethods.click(addEmp.addEmployee);

		CommonMethods.sendText(addEmp.firstName, "John");
		CommonMethods.sendText(addEmp.lastName, "Doe");

		CommonMethods.click(addEmp.location);

		// 1 identify list
		// 2 get all children with li tags
		// loop through each li tag and get text
		// if text is matching then we click
		// break

		List<WebElement> listLocations = addEmp.locationList.findElements(By.tagName("li"));

		for (WebElement li : listLocations) {
			String liText = li.getText().trim();

			if (liText.contains("Venedik")) {
				li.click();
				break;
			}
		}
		
		CommonMethods.click(addEmp.saveBtn);
		
		
		Thread.sleep(9000);
	}

}
