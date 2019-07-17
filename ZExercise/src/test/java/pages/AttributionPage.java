package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AttributionPage {
	
	@FindBy(xpath="/html/body/main/div[2]/div[5]")
	public WebElement letsTalk; 
	
	@FindBy(xpath="//*[@id=\"310041_24164pi_310041_24164\"]")
	public WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"310041_24166pi_310041_24166\"]")
	public WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"310041_24168pi_310041_24168\"]")
	public WebElement company;
	
	@FindBy(xpath="//*[@id=\"310041_24170pi_310041_24170\"]")
	public WebElement companyMail;
	
	@FindBy(xpath="//*[@id=\"310041_56941pi_310041_56941\"]")
	public WebElement jobFunctionDD;
	
	@FindBy(xpath="//*[@id=\"310041_56889pi_310041_56889\"]")
	public WebElement jobTitle;
	
	@FindBy(xpath="//*[@id=\"310041_24172pi_310041_24172\"]")
	public WebElement industryDD;
	
	@FindBy(xpath="//*[@id=\"310041_55216pi_310041_55216\"]")
	public WebElement interestedDD;
	
	@FindBy(xpath="//*[@id=\"310041_33615pi_310041_33615_323675\"]")
	public WebElement checkBox;
	
	@FindBy(xpath="//*[@id=\"pardot-form\"]/div[16]/input")
	public WebElement contactButton;
	
	

}
