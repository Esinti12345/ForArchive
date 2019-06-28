package com.syntax.testcases;

import org.testng.annotations.Test;

import com.syntax.pages.LoginPage_Sohil;
import com.syntax.utils.BaseClass;
import com.syntax.utils.ConfigsReader;

public class LoginPage_SohilTest extends BaseClass {

	public LoginPage_Sohil pageObj;

	// validate login functionality with valid credentials.
	@Test
	public void login() {
		pageObj=new LoginPage_Sohil();
		pageObj.enterUserName(ConfigsReader.getProperty("username"));
		pageObj.enterPassword(ConfigsReader.getProperty("password"));
		pageObj.clickLoginBtn();
	}
	
	
		//validate login functionality with invalid credentials.
		
      @Test
		public void loginWithInvC () {
			pageObj=new LoginPage_Sohil();
			pageObj.enterUserName("testMe1");
			pageObj.enterPassword("323gre");
			pageObj.clickLoginBtn();
			if(pageObj.errorMessage.isDisplayed()) { // to fail the case you can put ! at the beginning of if statement 
				System.out.println("Test Case passed");
			}else {
				System.err.println("Test Case Failed");
			}
			
		}
		
		
	

}
