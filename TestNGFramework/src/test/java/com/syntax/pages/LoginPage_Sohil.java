package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.ConfigsReader;

public class LoginPage_Sohil {
	
	@FindBy (css="input#txtUsername")
	private WebElement userName;
	
	@FindBy (css="input#txtPassword")
	private WebElement password;

	@FindBy (css= "input#btnLogin")
	private WebElement loginBtn;
	
	@FindBy (css= "div.toast.toast-error")
	public WebElement errorMessage;
	
	public LoginPage_Sohil() {
		PageFactory.initElements(BaseClass.driver, LoginPage_Sohil.class);
	}
	
	
	public void enterUserName(String username) {
		//userName.sendKeys("Admin"); //hard coding- when you wanna test a negative senario invalid username,it wont work if you write in this way.
		userName.sendKeys(ConfigsReader.getProperty(username));
		}
	
	public void enterPassword(String pass) {
		//password.sendKeys("l6VUS8uWx@");
		password.sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	
	
	
}
