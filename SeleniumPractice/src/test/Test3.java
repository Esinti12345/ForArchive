package test;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test3 {

    public static void main(String[] args) {
    	System.setProperty("webdriver.chrome.driver", "/Users/ahmetorhan/Documents/Selenium/chromedriver");
		WebDriver driver=new ChromeDriver();
        driver.get("http://google.com");
        
        driver.get("http://www.amazon.com");
        System.out.println(driver.getTitle());
        String title = driver.getTitle();
        if(title.equalsIgnoreCase("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more")) {
            System.out.println("This is the correct title!");
        }else {
            System.out.println("This is wrong title !");
        }
    }
}
