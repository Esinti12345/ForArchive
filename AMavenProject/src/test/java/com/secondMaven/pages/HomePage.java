package com.secondMaven.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.secondMaven.utils.BaseClass;



public class HomePage extends BaseClass{
	
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(partialLinkText="PIM")
    public WebElement PIM;
	
    @FindBy(partialLinkText="Add Employee")
    public WebElement addEmployee;
    
    @FindBy(xpath="//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")
    public WebElement googleSearch;
    
    @FindBy(xpath="//*[@id=\"tsf\"]/div[2]/div/div[3]/center/input[1]")
    public WebElement searchButton;
    
   @FindBy(xpath="//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[1]/input") 
    public WebElement newPageVerify;
   
   @FindBy(xpath = "//*[@id=\"menu_training_defaultTrainingModulePage\"]/a/span[2]")
    public WebElement training;
    
    @FindBy(xpath = "//*[@id=\"menu_training_viewCourseList\"]/span[2]")
    public WebElement courses;
    
    @FindBy(xpath = "//*[@id=\"noncoreIframe\"]")
    public WebElement frame;
	
    @FindBy(xpath = "//*[@id=\"addItemBtn\"]/i")
	public WebElement addCourseButton;
    
	
	public  HomePage() {
		PageFactory.initElements(driver, this);
	}

}
