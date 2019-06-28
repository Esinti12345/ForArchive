package com.secondMaven.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.secondMaven.pages.AlertPage;
import com.secondMaven.utils.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class AlertPageSteps {

	String url = "https://the-internet.herokuapp.com/";
	AlertPage alert;

	@When("I navigated to HerOkuApp")
	public void i_navigated_to_HerOkuApp() {
		System.out.println("Hi there 1");
	}

	@When("I click Alerts Button")
	public void i_click_Alerts_Button() {
		System.out.println("Hi there 2");
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to(url);
		alert = new AlertPage(driver);
		
		alert.alertBtn.click();
	}

	@When("I clicked onJS Alert")
	public void i_clicked_onJS_Alert() {
		alert.jsAlertBtn.click();
	}

	@When("I swicth to Alert")
	public void i_swicth_to_Alert() {
		BaseClass.driver.switchTo().alert().accept();
	}

//	@When("I click Ok button on the Alert")
//	public void i_click_Ok_button_on_the_Alert() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new cucumber.api.PendingException();
//	}

	@When("I come back to Alerts page")
	public void i_come_back_to_Alerts_page() {
		BaseClass.driver.switchTo().defaultContent();
	}

	@When("I clicked Js Confirm Alert")
	public void i_clicked_Js_Confirm_Alert() {
		alert.jsConfirmBtn.click();
	}

	@When("I switch to Alert")
	public void i_switch_to_Alert() {
		BaseClass.driver.switchTo().alert().dismiss();
	}

//	@When("I click on Cancel Button")
//	public void i_click_on_Cancel_Button() {
//		// Write code here that turns the phrase above into concrete actions
//		throw new cucumber.api.PendingException();
//	}

}
