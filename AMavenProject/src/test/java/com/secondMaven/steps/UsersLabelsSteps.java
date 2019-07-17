package com.secondMaven.steps;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.secondMaven.pages.HomePage;
import com.secondMaven.pages.LoginPage;
import com.secondMaven.pages.UsersLabelsPage;
import com.secondMaven.utils.CommonMethods;
import com.secondMaven.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UsersLabelsSteps {

	LoginPage login;
	HomePage home;
	UsersLabelsPage uLabel;

	@Given("I logged in into OrangeHRM website")
	public void i_logged_in_into_OrangeHRM() {

		login = new LoginPage();
		home = new HomePage();
		uLabel = new UsersLabelsPage();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

	}

	@Given("I am on Users Page")
	public void i_am_on_Users_Page() throws InterruptedException {
		CommonMethods.click(uLabel.admin);
		Thread.sleep(500);
		CommonMethods.click(uLabel.UserManagement);
		Thread.sleep(500);
		CommonMethods.click(uLabel.Users);

	}

	@When("I click on Add Users")
	public void i_click_on_Add_Users() {
		CommonMethods.click(uLabel.addUsersBtn);

	}

	@Then("I see the following location labels")
	public void i_see_the_following_location_labels(io.cucumber.datatable.DataTable addUserLabels) {

		List<String> expectedLabels = addUserLabels.asList();
		for (String label : expectedLabels) {
			System.out.println(label);
		}
		List<String> actualLabels = new ArrayList<String>();

		List<WebElement> labelList = uLabel.addUserLabels;

		for (WebElement label : labelList) {
			String labeltxt = label.getText();
			if (!labeltxt.isEmpty()) {
				actualLabels.add(labeltxt.replace("*", ""));
			}

		}
		System.out.println("ExpectedLabels is " + expectedLabels);
		System.out.println("actualLabels is " + actualLabels);
		System.out.println("labelList is " + labelList);

		Assert.assertTrue(actualLabels.equals(expectedLabels));

	}

}
