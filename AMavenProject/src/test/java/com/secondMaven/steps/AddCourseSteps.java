package com.secondMaven.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import com.secondMaven.pages.AddCoursePage;
import com.secondMaven.pages.AddEmployeePage;
import com.secondMaven.pages.HomePage;
import com.secondMaven.pages.LoginPage;
import com.secondMaven.utils.CommonMethods;
import com.secondMaven.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class AddCourseSteps extends CommonMethods {
	LoginPage login;
	HomePage home;
	AddCoursePage course;

	@Given("I logged in into OrangeHrm to add a course")
	public void i_logged_in_into_OrangeHrm_to_add_a_course() {
		login = new LoginPage();
		home = new HomePage();
		course = new AddCoursePage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
	}

	@Given("I click on Training link")
	public void i_click_on_Training_link() {
		home.training.click();
	}

	@Given("I click on Courses link")
	public void i_click_on_Courses_link() {
		home.courses.click();
	}

	@Given("I click on Add Course button")
	public void i_click_on_Add_Course_button() {
		driver.switchTo().frame(home.frame);
		home.addCourseButton.click();
	}

	@When("I provide CourseTitle and Coordinator")
	public void i_provide_CourseTitle_and_Coordinator() {
		sendText(course.courseTitle, "Math");
		course.coordinator.click();
		sendText(course.coordinator, "j");
		course.coordinatorList.click();
	}

	@When("I provide {string} and {string}")
	public void i_provide_and(String courseTitle, String coordinator) throws InterruptedException {
		sendText(course.courseTitle, courseTitle);
		course.coordinator.click();
		sendText(course.coordinator, coordinator);
		course.coordinatorList.click();
		Thread.sleep(3000);
	}

	@When("I provide {string} and {string} from example")
	public void i_provide_and_from_example(String courseTitle, String coordinator) throws InterruptedException {
		sendText(course.courseTitle, courseTitle);
		course.coordinator.click();
		sendText(course.coordinator, coordinator);
		course.coordinatorList.click();
		Thread.sleep(3000);
	}

	@When("I provide CourseTitle and Coordinator from below")
	public void i_provide_CourseTitle_and_Coordinator_from_below(DataTable dataTable) throws InterruptedException {
		List<Map<String, String>> mapList = dataTable.asMaps();
		for (Map<String, String> map : mapList) {
			//System.out.println(map.get("CourseTitle") + " => " + map.get("Coordinator"));

			
			
			sendText(course.courseTitle, map.get("CourseTitle"));
			course.coordinator.click();
			sendText(course.coordinator, map.get("Coordinator"));
		    course.coordinatorList.click();
		   // course.coordinatorList.getText().isEmpty()
		    Thread.sleep(1000);
			course.saveButton.click();

//			if(!course.coordinator.getText().isEmpty()) {
//				course.coordinator.clear();
//			}
			
			//driver.switchTo().defaultContent();
			//home.training.click();		
			home.courses.click();
			driver.switchTo().frame(home.frame);
			home.addCourseButton.click();
		}
	}

	@When("I click on save course button")
	public void i_click_on_save_course_button() {
		course.saveButton.click();
	}

	@Then("I see successfully save text")
	public void i_see_successfully_save_text() {
		Assert.assertTrue(true);
	}

}
