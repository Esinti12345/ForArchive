package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.CommonMethods;

/**
 * Identify Priority of Test Cases
 * 
 * http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx
 * 
 * TC 1: WebOrder Verify Successful Login ( ) Step 1: Open browser and navigate
 * to WebOrder Step 2: Enter valid username, enter valid password and click on
 * the login button Step 3: Verify user successfully logged in
 * 
 * @author ahmetorhan
 *
 */
public class Task1 extends CommonMethods {

	

	@BeforeClass
	public void setUp() {
		String url = "http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx";
		setUpDriver("chrome", url);
	}

	@Test
	public void Login() {
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_username\"]")).sendKeys("Tester");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_password\"]")).sendKeys("test");
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_login_button\"]")).click();
		Assert.assertTrue(driver.getTitle().contains("Web Orders"), "User is not able to login- Invalid Credentails");
		System.out.println("Page title is verified- User is able to login Successfully");
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
