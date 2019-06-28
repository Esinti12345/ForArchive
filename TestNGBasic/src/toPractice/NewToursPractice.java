package toPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class NewToursPractice extends CommonMethods {

	@BeforeMethod
	public void LoginRegister() {

		String url = "http://newtours.demoaut.com/mercuryregister.php";
		setUpDriver("chrome", url);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a"))
				.click();
	}

	@DataProvider(name = "register")
	public Object[][] register() {

		Object[][] data = new Object[2][11];

		data[0][0] = "Ahmet";
		data[0][1] = "Dogan";
		data[0][2] = "8976754325";
		data[0][3] = "ahmetgogan@yahoo.com";
		data[0][4] = "Krakov st. 09234 FL ";
		data[0][5] = "Miami";
		data[0][6] = "FL";
		data[0][7] = "09234";
		data[0][8] = "Ahmettttt";
		data[0][9] = "Ahmet&ahmet";
		data[0][10] = "Ahmet&ahmet";

		data[1][0] = "Melek";
		data[1][1] = "Dogan";
		data[1][2] = "8976754325";
		data[1][3] = "ahmetgogan@yahoo.com";
		data[1][4] = "Krakov st. 09234 FL ";
		data[1][5] = "Miami";
		data[1][6] = "FL";
		data[1][7] = "09234";
		data[1][8] = "Melekkk";
		data[1][9] = "Ahmet&ahmet";
		data[1][10] = "Ahmet&ahmet";

		return data;

	}

	@Test(dataProvider = "register")
	public void fillInRegister(String name, String lastname, String phone, String email, String address, String city,
			String state, String Pcode, String Uname, String pass, String cpass) {

		sendText(driver.findElement(By.xpath("//input[@name='firstName']")), name);
		sendText(driver.findElement(By.xpath("//input[@name='lastName']")), lastname);
		sendText(driver.findElement(By.xpath("//input[@name='phone']")), phone);
		sendText(driver.findElement(By.xpath("//input[@id='userName']")), email);

		sendText(driver.findElement(By.xpath("//input[@name='address1']")), address);
		sendText(driver.findElement(By.xpath("//input[@name='city']")), city);
		sendText(driver.findElement(By.xpath("//input[@name='state']")), state);
		sendText(driver.findElement(By.xpath("//input[@name='postalCode']")), Pcode);
		
		List<WebElement> countries = driver.findElements(By.xpath("//select[@name='country']"));

		for (WebElement country : countries) {
			Select select = new Select(country);
			select.selectByVisibleText("WEST BANK");}

		sendText(driver.findElement(By.xpath("//input[@id='email']")), Uname);
		sendText(driver.findElement(By.xpath("//input[@name='password']")), pass);
		sendText(driver.findElement(By.xpath("//input[@name='confirmPassword']")), cpass);
		
		

		
		driver.findElement(By.xpath(
				"/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[18]/td/input"))
				.click();

	}

//	@Test
//	public void jcountryDropDown() {
//		List<WebElement> countries = driver.findElements(By.xpath("//select[@name='country']"));
//
//		for (WebElement country : countries) {
//			Select select = new Select(country);
//			select.selectByVisibleText("WEST BANK");
//
//		}
//
//	}

	

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(9000);
		driver.quit();
	}

}
