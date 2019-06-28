package com.class03;

import org.testng.annotations.Test;

public class DependsOnGroups {

	@Test (groups="Smoke1")
	public void one() {
		System.out.println("one test");
	}
	@Test (groups="Smoke1")
	public void two() {
		System.out.println("two test");
	}
	@Test (groups="Smoke1")
	public void three
	() {
		System.out.println("one test");
	}
}
