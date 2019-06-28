package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;


public class HomePage extends BaseClass{
	
	@FindBy(xpath="//li[text()='Dashboard']")
	public WebElement dashboardText;
	
	@FindBy(xpath="//*[text()='PIM']")
    public WebElement PIM;
	
   
    
   @FindBy(xpath = "//*[@id=\"menu_training_defaultTrainingModulePage\"]/a/span[2]")
    public WebElement training;
    
    @FindBy(xpath = "//*[@id=\"menu_training_viewCourseList\"]/span[2]")
    public WebElement courses;
    
    @FindBy(xpath = "//*[@id=\"noncoreIframe\"]")
    public WebElement frame;
	
    @FindBy(xpath = "//*[@id=\"addItemBtn\"]/i")
	public WebElement addCourseButton;
    
  
    
//    @FindBy(xpath="//*[@id=\"menu_training_defaultTrainingModulePage\"]/a")
//    public WebElement training;
//    
//    @FindBy(xpath="//*[@id=\"menu_training_viewCourseList\"]/span[2]")
//    public WebElement courses;
//    
//    @FindBy(xpath="//*[@id=\"addItemBtn\"]/i")
//    public WebElement addingButton;
//    
    
	
	public  HomePage() {
		PageFactory.initElements(driver, this);
	}

}
