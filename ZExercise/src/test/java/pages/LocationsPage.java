package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BaseClass;

public class LocationsPage {
	
	@FindBy (xpath="//*[@id=\"menu_admin_viewAdminModule\"]/a/span[2]")
	public WebElement admin;
	
	@FindBy (xpath="//span[text()='Organization']")
	public WebElement organization;
	
	@FindBy (xpath="//span[text()='Locations']")
	public WebElement locations;
	
	@FindBy (xpath="//*[@id=\"locationDiv\"]/div/a/i")
	public WebElement addLocationBtn;
	
	@FindBy(css="#name")
	public WebElement name;
	
	@FindBy(xpath="//*[@id=\"countryCode_inputfileddiv\"]/div/input")
	public WebElement country;
	
	@FindBy(xpath = " //div[@id='countryCode_inputfileddiv']/div/ul")
	public WebElement countryList;
	
	@FindBy(css="#city")
	public WebElement city;
	
	@FindBy(css="#zipCode")
	public WebElement zip;
	
	@FindBy(xpath="//a[text()='Save']")
	public WebElement saveLocationBtn;
	
	public LocationsPage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}
