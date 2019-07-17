package steps;

import java.io.IOException;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.HomePage;
import pages.LocationsPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigsReader;

public class LocationsSteps {
	LoginPage login;
	HomePage home;
	LocationsPage location;
	
	
	
	@Given("I logged in into OrangeHRM website to test")
	public void i_logged_in_into_OrangeHRM_website_to_test() {
		login = new LoginPage();
		home = new HomePage();
		location=new LocationsPage();
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
	}

	@Given("I am on Locations Page")
	public void i_am_on_Locations_Page() {
	    CommonMethods.click(location.admin);
	    CommonMethods.click(location.organization);
	    CommonMethods.click(location.locations);
	    CommonMethods.click(location.addLocationBtn);
	}

	@When("I provide locations name, country, city and zip code")
	public void i_provide_locations_name_country_city_and_zip_code() {
	   
	}

	@Then("I location added successfully")
	public void i_location_added_successfully() {
	 
	}

	@When("I click on Add Locations")
	public void i_click_on_Add_Locations() {
	   
	}

	@Then("I see following location labels")
	public void i_see_following_location_labels(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    
	}


}
