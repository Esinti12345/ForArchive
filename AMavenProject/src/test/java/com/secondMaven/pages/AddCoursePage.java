package com.secondMaven.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.secondMaven.utils.BaseClass;


public class AddCoursePage {

	@FindBy(id = "addCourse_title")
	public WebElement courseTitle;

	@FindBy(id = "addCourse_coordinator_empName")
	public WebElement coordinator;

	@FindBy(xpath = "/html/body/div[5]/ul/li[1]")
	public WebElement coordinatorList;

	@FindBy(id = "btnSaveCourse")
	public WebElement saveButton;

	public AddCoursePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}

}