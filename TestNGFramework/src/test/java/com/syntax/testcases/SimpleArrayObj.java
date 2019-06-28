package com.syntax.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SimpleArrayObj {
	
	
	@Test(dataProvider="getData")
		public void arrayData(String uName,String pass) {
			System.out.println("User name is:: "+uName);
			System.out.println("Password is:: "+pass);
		}
	
	
	@DataProvider()
	public  Object[][] getData() {
		
		Object[][] data=new Object[][]{
			
			{"username1","Password1"},
			{"userName2","Password2"},
			{"userName3","Password3"},
	};
		return data;
	
	}
	
	
	
	
//	@DataProvider()
//	public  Object[][] getData() {
//		
//		Object[][] data=new Object[2][2];
//		//1st Row
//		data[0][0]="UserName";
//		data[0][1]="password";
//		//2nd Row
//		data[1][0]="UserName1";
//		data[1][1]="password1";
//		
//		return data;
//		
//	}
	
	

}
