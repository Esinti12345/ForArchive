package com.secondMaven.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.secondMaven.pages.AddEmployeePage;
import com.secondMaven.pages.HomePage;
import com.secondMaven.pages.LoginPage;
import com.secondMaven.utils.BaseClass;
import com.secondMaven.utils.CommonMethods;
import com.secondMaven.utils.ConfigsReader;
import com.secondMaven.utils.Constants;
import com.secondMaven.utils.ExcelUtility;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Sed;
import io.cucumber.datatable.DataTable;

public class AddEmployeeSteps extends CommonMethods {

	LoginPage login;
	HomePage home;
	AddEmployeePage emp;

	@Given("I logged in into OrangeHrm")
	public void i_logged_in_into_OrangeHrm() {
		login = new LoginPage();
		home = new HomePage();
		emp = new AddEmployeePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@When("I click on PIM link")
	public void i_click_on_PIM_link() {
		click(home.PIM);
	}

	@When("I click on  Add Employee link")
	public void i_click_on_Add_Employee_link() {
		click(home.addEmployee);
	}

	@When("I provide {string}, {string}, {string} and {string}")
	public void i_provide_and(String fName, String mName, String lName, String location) {
		sendText(emp.firstName, fName);
		sendText(emp.middleName, mName);
		sendText(emp.lastName, lName);
		click(emp.location);
		selectList(emp.locationList, location);
	}

	@When("I click on save button")
	public void i_click_on_save_button() {
		jsClick(emp.saveBtn);
	}

	@Then("I see {string}, {string} is displayed")
	public void i_see_is_displayed(String fName, String lName) {
		waitForElementBeClickable(emp.empCheck, 20);
		String empName = emp.empCheck.getText();
		Assert.assertEquals(fName + " " + lName, empName);

	}

	@Then("I see following labels")

	public void i_see_following_label(DataTable addEmpLabels) throws InterruptedException {
		System.out.println("----Printing expected labels from cucumber dataTable----");
		List<String> expectedLabels = addEmpLabels.asList();
		for (String label : expectedLabels) {
			System.out.println(label);
		}
		
		// create an empty arraylist where we store labels text
		List<String> actualLabels = new ArrayList<String>();
		Thread.sleep(3000);
		
		// get all label elements
		List<WebElement> labelList = emp.addEmpLabels;
		for (WebElement label : labelList) {
			String labeltxt = label.getText();
			// if text is not empty replace * and store it inside actualLabels
			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
			}
		}
		// expectedLabels.equals(labelList); //Even if this method is for to compare two
		// ArrayList,
		// it will give an error in this case. Why? Because ,
		// First List gives us a list Of String,Second One gives us a list of
		// WebElement.
		// We can't compare two different type of thingies.
		Assert.assertTrue(actualLabels.equals(expectedLabels));
	}

	@When("I provide firstname, midlename, lastname and location")
	public void i_provide_firstname_midlename_lastname_and_location() throws InterruptedException {
		sendText(emp.firstName, "Jane");
		sendText(emp.middleName, "J");
		sendText(emp.lastName, "Black");
		click(emp.location);
		selectList(emp.locationList, "HQ");

	}

	@When("I click on create login details")
	public void i_click_on_create_login_details() {
		click(emp.createLoginDetails);
	}

	@When("I provide all mandatory fields")
	public void i_provide_all_mandatory_fields() throws InterruptedException {
		sendText(emp.mandatoryUserName, "Admin1puh5");
		sendText(emp.mandatoryPassword, "l6VUS8uWx@");
		Thread.sleep(2000);
		sendText(emp.mandatoryConPassword, "l6VUS8uWx@");

		selectList(emp.mandatoryEssRole, "Default ESS");

		selectList(emp.mandatorySupervisorRole, "Default Supervisor");

		jsClick(emp.mandatorySave);
		// click(emp.mandatorySave);
	}

	@Then("I see employee is added successfully")
	public void i_see_employee_is_added_successfully() {
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (emp.verifyEmployee.isDisplayed()) {
			String expectedTitle = "Jane Black";
			String empName = emp.verifyEmployee.getText();
			Assert.assertEquals(expectedTitle, empName);
		}
	}

	@When("I provide employee details from Excel file {string}")
	public void i_provide_employee_details_from_Excel_file(String EmployeeDetails) throws InterruptedException {

		emp = new AddEmployeePage();
		ExcelUtility excel = new ExcelUtility();
		// String xl_filePath="src/test/resources/testdata.EmployeeList.xlsx";
		excel.openExcel(Constants.XL_FILEPATH, "EmployeeListOne");
		int rows = excel.getRowNum();
		int cols = excel.getColNum(0);

		for (int i = 1; i < rows; i++) {
			int h = 0;
			String fName = excel.getCellData(i, h);
			String midName = excel.getCellData(i, ++h);
			String lName = excel.getCellData(i, ++h);
			String location = excel.getCellData(i, ++h);

			sendText(emp.firstName, fName);
			sendText(emp.middleName, midName);
			sendText(emp.lastName, lName);
			click(emp.location);
			selectList(emp.locationList, location);

			click(emp.saveBtn);
			Thread.sleep(2000);

			waitForElementBeVisible(emp.verifyEmployee, 10);
			Thread.sleep(2000);

			// waitForElementBeClickable(emp.empCheck, 5);
			Assert.assertEquals(fName + " " + lName, emp.verifyEmployee.getText());
			Thread.sleep(2000);

			click(home.addEmployee);

		}

	}

}

//		String excelFilePath="/src/test/resources/testdata/EmployeeList.xlsx";

//		FileInputStream fis=new FileInputStream(Constants.XL_FILEPATH);
//		
//		XSSFWorkbook workbook= new  XSSFWorkbook(fis);
//		
//		XSSFSheet sheet=workbook.getSheet("EmployeeListOne");
//		
//		int rowNumber=sheet.getPhysicalNumberOfRows();
//		
//		int colNumber=sheet.getRow(0).getLastCellNum();
//		
//		for(int i=0; i<rowNumber; i++) {
//			for(int h=0; h<colNumber; h++) {
//				String cellValue=sheet.getRow(i).getCell(h).toString();
//				System.out.println("cell Value is:"+ cellValue);
//				
//				String NeBu=sheet.getRow(i).getCell(h).getStringCellValue();
//				System.out.println("What is the difference:"+NeBu);
//				//sendText(emp.firstName, value);
//			}
//	}

// lets say they come from excel
/*
 * fis workbook worksheet(sheetName) number #rows number# cols loop (rows){ loop
 * (cols){
 *
 * sendText(emp.firstName, valueFromeachCell); sendText(emp.middleName,
 * valueFromeachCell); sendText(emp.lastName, valueFromeachCell);
 * click(emp.location); selectList(emp.locationList, valueFromeachCell);
 * 
 * 
 * } }
 */
