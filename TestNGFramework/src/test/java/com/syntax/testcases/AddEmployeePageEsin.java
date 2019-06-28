package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass_OldOne;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;



public class AddEmployeePageEsin extends BaseClass_OldOne{
	
	@Test
	
	public void AddEmployee() throws InterruptedException {
	
	LoginPage log=new LoginPage();
	HomePage home=new HomePage();
	AddEmployeePage addEmp=new AddEmployeePage();
	
	log.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
	
	
	CommonMethods.click(home.PIM);
	CommonMethods.click(addEmp.addEmployee);
	
	CommonMethods.sendText(addEmp.firstName, "Bob");
	CommonMethods.sendText(addEmp.lastName, "White");
	CommonMethods.sendText(addEmp.middleName, "Kevin");
	CommonMethods.sendText(addEmp.employeeId, "456");
	CommonMethods.click(addEmp.location);
	
	List<WebElement> location=addEmp.locationList.findElements(By.tagName("li"));
	
	for(WebElement local:location) {
		
		String liText=local.getText().trim();
		if(liText.equals("eerwer")) {
			local.click();
			break;
		}
		
	}
	Thread.sleep(5000);
	CommonMethods.click(addEmp.saveBtn);
	
	Thread.sleep(5000);
	
	}

}
