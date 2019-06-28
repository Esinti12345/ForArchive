package com.secondMaven.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.secondMaven.utils.BaseClass;

public class AddEmployeePage extends BaseClass{
	
	@FindBy(xpath="//*[@id=\"firstName\"]")
    public WebElement firstName;
    
    @FindBy(id="middleName")
    public WebElement middleName;
    
    @FindBy(id="lastName")
    public WebElement lastName;
    
    @FindBy(id="employeeId")
    public WebElement employeeId;
    
    @FindBy(xpath="//*[@id=\"location_inputfileddiv\"]/div/input")
    public WebElement location;
    
    @FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
    
    @FindBy(xpath="//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    public WebElement createLoginDetails;
    
    @FindBy(id="systemUserSaveBtn")
    public WebElement saveBtn;
    
    @FindBy(xpath="//span[@id='pim.navbar.employeeName']")
    public WebElement empCheck;
    
    @FindBy(xpath="//form[@id='pimAddEmployeeForm']//label")
    public List<WebElement> addEmpLabels;
    
    @FindBy (xpath="//*[@id=\"username\"]")
    public WebElement mandatoryUserName;
    
    @FindBy (xpath="//*[@id=\"password\"]")
    public WebElement mandatoryPassword;
    
    @FindBy (xpath="//*[@id=\"confirmPassword\"]")
    public WebElement mandatoryConPassword;
    
    @FindBy (xpath="//*[@id=\"essRoleId_inputfileddiv\"]/div/input")
    public WebElement mandatoryEssRole;
    
    @FindBy (xpath="//*[@id=\"supervisorRoleId_inputfileddiv\"]/div/input")
    public WebElement mandatorySupervisorRole;
    
  
    @FindBy (xpath="//*[@id=\"systemUserSaveBtn\"]")
    public WebElement mandatorySave;
    
    @FindBy (xpath="//*[@id='pim.navbar.employeeName']")
    public WebElement verifyEmployee;
    
    public AddEmployeePage() {
        PageFactory.initElements(driver,this);
    } 
}