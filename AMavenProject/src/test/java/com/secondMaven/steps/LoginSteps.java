package com.secondMaven.steps;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.secondMaven.pages.HomePage;
import com.secondMaven.pages.LoginPage;
import com.secondMaven.utils.CommonMethods;
import com.secondMaven.utils.ConfigsReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class LoginSteps extends CommonMethods {

	LoginPage login;

	@Given("I see OrangeHrm logo")
	public void i_see_OrangeHrm_logo() {
		login = new LoginPage();
		boolean isDisplayed = login.logo.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		sendText(login.userName, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
	}

	@When("I click login button")
	public void i_click_login_button() {
		click(login.loginBtn);
	}

	@Then("I successfully logged in")
	public void i_successfully_logged_in() {
		HomePage home = new HomePage();
		Assert.assertTrue(home.dashboardText.isDisplayed());
	}

	@Then("I close browser")
	public void i_close_browser() {
		tearDown();
	}

	@When("I enter invalid username and password")
	public void i_enter_invalid_username_and_password() {
		sendText(login.userName, "Test");
		sendText(login.password, "Test123");
	}

	@Then("I see error message is displayed")
	public void i_see_error_message_is_displayed() {
		Assert.assertTrue(login.message.isDisplayed());
		String errorText = login.message.getText().trim();
		Assert.assertEquals("Invalid Credentials", errorText);
	}

	@When("I enter invalid username and password I see errorMessage")
	public void i_enter_invalid_username_and_password_I_see_errorMessage(DataTable wrongCredentials) {
		
		List<Map<String, String>> maps = wrongCredentials.asMaps();
		for (Map<String, String> map : maps) {
			//printing values of each key
			System.out.println(map.get("UserName"));
			System.out.println(map.get("Password"));
			System.out.println(map.get("ErrorMessage"));
			System.out.println("------------------------------");
			//passing username and password values from datatable/map
			sendText(login.userName, map.get("UserName"));
			sendText(login.password, map.get("Password"));
			click(login.loginBtn);
			// verifying the text of error message
			String actualError = login.message.getText().trim();
			String expectedError = map.get("ErrorMessage");
//			System.out.println(expectedError);
//			System.out.println(actualError);
			Assert.assertEquals(expectedError, actualError);
		}
	}
	
	@When("I enter invalid {string} and {string} I see {string}")
    public void i_enter_invalid_and_I_see(String userName, String password, String errorMessage) {
        sendText(login.userName, userName);
        sendText(login.password, password);
        click(login.loginBtn);

        // verifying text of error message
        String actualError = login.message.getText().trim();
        String expectedError = errorMessage;
        Assert.assertEquals(expectedError, actualError);
    }
}