package com.secondMaven.steps;


import com.secondMaven.utils.BaseClass;
import com.secondMaven.utils.CommonMethods;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	@Before
	public void start(Scenario scenario) {
		System.out.println("Starting test:" + scenario.getName());
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario) {
		System.out.println("Ending test:" + scenario.getName());
		
		if(scenario.isFailed()) {
			byte[] shot=CommonMethods.takeScreenshot();
			scenario.embed(shot, "image/png");
		}
		
		BaseClass.tearDown();
	}
	
	
//	@After
//	public void end(Scenario scenario) {
//		System.out.println("Ending test:" + scenario.getName());
//		BaseClass.tearDown();
//	}
}