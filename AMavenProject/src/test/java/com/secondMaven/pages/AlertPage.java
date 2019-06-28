package com.secondMaven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.secondMaven.utils.BaseClass;

public class AlertPage {
	
	@FindBy (xpath="//a[text()='JavaScript Alerts']")
	public WebElement alertBtn;
	
	@FindBy (xpath="//button[text()='Click for JS Alert']")
	public WebElement jsAlertBtn;
	
	@FindBy (xpath="//button[text()='Click for JS Confirm']")
	public WebElement jsConfirmBtn;
	
	public AlertPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
}
