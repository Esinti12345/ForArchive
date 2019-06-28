package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;

/**
 * TC 2: WebOrder Creating and verifying Users( ) Step 1: Create Two users and
 * fill out all the required fields Step 2: Verify that user one name appears
 * within the table Step 3: Edit user one and update user one’s State, assert
 * the new updated State is displayed and save the changes. Step 4: Verify that
 * user two name appears within the table Step 5: Edit user two and update user
 * two’s City and assert the new updated City is displayed and save the changes.
 *
 */
public class Task2 extends CommonMethods {

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
	    @DataProvider(name = "formOfInformation")
	    public Object[][] fillIn() {
	        Object[][] data = new Object[2][11];
	        data[0][0] = "Henry";
	        data[0][1] = "Pokemon";
	        data[0][2] = "67";
	        data[0][3] = "06/08/2019";
	        data[0][4] = "Batman St.";
	        data[0][5] = "FairFax";
	        data[0][6] = "US";
	        data[0][7] = "06079";
	        data[0][8] = "AmericanExpress";
	        data[0][9] = "18794758974357";
	        data[0][10] = "09/12";
	        
	        
	        data[1][0] = "Clark";
	        data[1][1] = "Bayblade";
	        data[1][2] = "3";
	        data[1][3] = "01/01/2020";
	        data[1][4] = "Mangolya St.";
	        data[1][5] = "Virginia";
	        data[1][6] = "US";
	        data[1][7] = "04045";
	        data[1][8] = "Visa";
	        data[1][9] = "435623456254245";
	        data[1][10] = "07/09";
	        return data;
	    }

	@Test(alwaysRun = true, dataProvider = "formOfInformation")
	public void addingNew(String name, String street, String city, String state, int zip, int cardNo, String expire) {
		driver.findElement(By.xpath("//a[text()='Order']")).click();

		WebElement DD = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_ddlProduct\"]"));
		Select product = new Select(DD);
		product.selectByVisibleText("ScreenSaver");

		WebElement quantity = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
		quantity.clear();
		quantity.sendKeys("67");

		WebElement price = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtUnitPrice\"]"));
		price.clear();
		price.sendKeys("330");

		WebElement discount = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtUnitPrice\"]"));
		discount.clear();
		discount.sendKeys("330");

		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_txtName\"]")).sendKeys(name);
		sendText(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")), street);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox3\"]")).sendKeys(city);
		sendText(driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox4\"]")), state);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox5\"]")).sendKeys("zip");

		List<WebElement> radioButton = driver
				.findElements(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_cardList\"]"));
		for (WebElement button : radioButton) {
			String text = button.getText();
			if (text.contains("AmericanExpress")) {
				button.click();
			}
		}

		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]")).sendKeys("cardNo");
		WebElement expireDate = driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox6\"]"));
		sendText(expireDate, expire);

		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_InsertButton\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ctl00_menu\"]/li[1]/a")).click();

	}

	@Test(alwaysRun = true)
	public void verifyInformation() throws InterruptedException {
		// Assert.assertTrue((driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_orderGrid\"]/tbody/tr[2]/td[2]"))).getText().contains(data[0][0]);
		Assert.assertTrue(driver.getTitle().contains("Henry"), "User is not able to login. Invalid Credentails");
		System.out.println("Row verified. New user is added");

		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_TextBox2\"]")).sendKeys("37 Mangolya St.");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder_UpdateButton\"]")).click();
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
	}

}
