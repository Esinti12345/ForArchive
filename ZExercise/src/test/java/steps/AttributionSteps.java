package steps;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AttributionPage;
import pages.HomePageAttribution;

public class AttributionSteps {

	HomePageAttribution hpa;
	WebDriver driver;
	AttributionPage atr;

	@Given("I navigate in into FOURSQUARE for attribution")
	public void i_navigate_in_into_FOURSQUARE() {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://foursquare.com/");
	}

	@Given("I am on Attribution Page")
	public void i_am_on_Attribution_Page() {
		System.out.println("Baslangic");
		hpa = new HomePageAttribution();
		System.out.println("Baslangic1");
		
//		driver.switchTo().frame(hpa.iframe);
		
		try {
		Actions action = new Actions(driver = new ChromeDriver());
		action.moveToElement(hpa.products).build();
		System.out.println("Baslangic2");
		System.out.println(hpa.products.getText());
		}catch(IllegalArgumentException e) {
			
		}
		
		// hpa.products.click();

		Select obj = new Select(hpa.products);
		List<WebElement> allOptions = obj.getOptions();
		for (WebElement option : allOptions) {
			String optionText = option.getText();
			if (optionText.equals("Attribution")) {
				obj.selectByVisibleText("Attribution");
			}
		}

	}

	@When("I click on LET'S TALK")
	public void i_click_on_LET_S_TALK() {
		atr.letsTalk.click();

	}

	@When("I fill  all contact infos")
	public void i_fill_all_contact_infos() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@When("click to contact us button")
	public void click_to_contact_us_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

	@Then("i see the valid mail message")
	public void i_see_the_valid_mail_message() {
		// Write code here that turns the phrase above into concrete actions
		throw new cucumber.api.PendingException();
	}

}
