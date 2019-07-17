package com.secondMaven.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class UsersLabelsPage {
	
	@FindBy(xpath="//*[@id=\'menu_admin_viewAdminModule\']/a")
	public WebElement admin;
	
	
	@FindBy (xpath="//*[@id=\"menu_admin_UserManagement\"]/a/span[2]")
	public WebElement UserManagement;
	
	@FindBy (xpath="//*[@id=\"menu_admin_viewSystemUsers\"]/span[2]")
	public WebElement Users;
	
	
	@FindBy (xpath="//*[@id=\"systemUserDiv\"]/div/a/i")
	public WebElement addUsersBtn;
	
	@FindBy (xpath="//*[@id=\"modal1\"]/form/div[1]/div//label")
	public List<WebElement> addUserLabels;
	
	
	
	public UsersLabelsPage() {
		PageFactory.initElements(com.secondMaven.utils.BaseClass.driver, this);
	}
	
	
	

}
