package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass_OldOne;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest_oldOne extends BaseClass_OldOne{

	//static String login = ConfigsReader.getProperty("username");
	//static String password = ConfigsReader.getProperty("password");

	
	@Test(groups="smoke")
	public void loginToOrangeHRM() {
		
		LoginPageWithoutPageFactory  login=new LoginPageWithoutPageFactory ();
		
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "06I@PjFbgM");
		CommonMethods.click(login.btnLogin);
		
	}	
		
	@Test(groups="smoke")
		public void doLogin() {
			//driver.get(URL);
			LoginPage loginPage=new LoginPage();
			//loginPage.Login(login, password);
			
//			CommonMethods.sendText(loginPage.userName, ConfigsReader.getProperty("username"));
//			CommonMethods.sendText(loginPage.password, ConfigsReader.getProperty("password"));
//			CommonMethods.click(loginPage.loginBtn);
		
			loginPage.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
			
			
			HomePage home=new HomePage();
			boolean isDisplayed=home.dashboardText.isDisplayed();
			
			//AssertJUnit.assertTrue(isDisplayed);
			Assert.assertTrue(isDisplayed);
		}
		
		/*
		 * verify user is unable to login with wrong credentials
		 */
		
		@Test(groups="regression")
		public void negativeLogin() {

			LoginPage login = new LoginPage();

			login.login("admins", "test");

			String errorText = login.message.getText();

			Assert.assertEquals(errorText, "Invalid Credentials");

		}
	}
