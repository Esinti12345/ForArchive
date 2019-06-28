package com.syntax.testcases;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.annotations.Test;

import com.syntax.pages.AddCoursePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class AddCoursePageTest extends BaseClass {

	@Test
	public void addCourse() throws InterruptedException {
		LoginPage login = new LoginPage();
		HomePage home = new HomePage();
		AddCoursePage course = new AddCoursePage();

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		test.pass("Test passed: Login oldu");

		home.training.click();
		home.courses.click();
		test.pass("Test passed: Course Link'e tiklandi");

		driver.switchTo().frame(home.frame);
		test.info("Frame'e switch ediyorum");
		home.addCourseButton.click();

		CommonMethods.sendText(course.courseTitle, "Deneme");

		course.coordinator.click();
		CommonMethods.sendText(course.coordinator, "j");
//		test.fail("coordinatorList'e tiklanamadi");
//		int a = 3 / 0;
		course.coordinatorList.click();
		course.saveButton.click();

		Thread.sleep(5000);
	}

}