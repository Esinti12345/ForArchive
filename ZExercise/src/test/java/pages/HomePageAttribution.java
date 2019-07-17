package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageAttribution {
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div/div[3]/div[1]")
	public WebElement products;
	
	@FindBy(xpath="//*[@id=\"container\"]/div[1]/div/div/div[3]/div[3]/div/a[2]")
	public WebElement attribution;
	
	@FindBy(xpath="/html/body/main/div[10]/div/iframe")
	public WebElement iframe;
	
	

}
