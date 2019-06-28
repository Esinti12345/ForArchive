package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.CommonMethods;
/*
Identify Priority of Test Cases
http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx
TC 1: WebOrder Verify Successful Login ( )
Step 1: Open browser and navigate to WebOrder
Step 2: Enter valid username, enter valid password and click on the  login button
Step 3: Verify user successfully logged in
TC 2: WebOrder Creating and verifying Users( )
Step 1: Create Two users and fill out all the required fields
 Step 2: Verify that user one name appears within the table 
 Step 3: Edit user one  and update user one's State, assert the new updated State is displayed and save the changes.
 Step 4: Verify that user two name appears within the table 
 Step 5: Edit user two and update user two's City and assert the new updated City is displayed and save the changes.
TC 3: WebOrder verifying Users( )
        Step 1 : Assert Both User one and User Two are displayed
Note: Create BeforeClass and AfterClass annotations to open browser and logout from the application. 
The creation of users two should depend on the creation of users one.The validation both users should depend on the creation of both users. 
Create xml file and share a screenshot of the test.
*/
public class Task_Student extends CommonMethods{
    
    @Parameters({"browser","url","username","password"})
    @BeforeClass
    public void setUp(String browser, String url, String username, String password) {
        setUpDriver(browser, url);
        
        //Enter valid username, enter valid password and click on the  login button
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_username")),username);
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_password")),password);
        driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();
        
        //Verify user successfully logged in
        boolean verify = driver.findElement(By.cssSelector("div.login_info")).isDisplayed();
        Assert.assertTrue(verify);
        System.out.println("Successfully logged in");
    }
    
    @Parameters({"quantity","customerName","street","city","zip","cardNum","expNum"})
    @Test(priority = 0)
    public void creatingUser(String quantity, String customerName, String street,String city,String zip,String cardNum,String expNum) throws InterruptedException {
        
        //Create a user and fill out all the required fields
        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtQuantity")),quantity);
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_txtName")),customerName);
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox2")),street);
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox3")),city);
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox5")),zip);
        driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_cardList_0")).click();
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox6")),cardNum);
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox1")),expNum);
        driver.findElement(By.cssSelector("a#ctl00_MainContent_fmwOrder_InsertButton")).click();
        
        //Verify that user name appears on the table
        driver.findElement(By.xpath("//a[text()='View all orders']")).click();
        WebElement el = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid > tbody > tr:nth-child(2) > td:nth-child(2)"));
        String name=el.getText();
        String expName = customerName;
        Assert.assertEquals(name, expName);
        System.out.println("User name on the table");
        
        //Edit and update user's State, assert the new updated State is displayed and save the changes.
        driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td[13]")).click();
        sendText(driver.findElement(By.cssSelector("input#ctl00_MainContent_fmwOrder_TextBox4")), "New Jersey");
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_UpdateButton']")).click();
        WebElement el1 = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid > tbody > tr:nth-child(2) > td:nth-child(8)"));
        String state=el1.getText();
        String expState = "New Jersey";
        Assert.assertEquals(state, expState);
        System.out.println("State updated succesfully");  
    }
    
    @Parameters({"customerName"})
    @Test(priority = 1)
    public void verifyingUser(String customerName) {
        WebElement el = driver.findElement(By.cssSelector("#ctl00_MainContent_orderGrid > tbody > tr:nth-child(2) > td:nth-child(2)"));
        String name=el.getText();
        String expName = customerName;
        Assert.assertEquals(name, expName);
        System.out.println("User is displayed");
    }
    
    @AfterClass
    public void tearDown() {
        driver.close();
    }   
}
