package ZExercise;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {

	
	public static void takeScreenshot(String folderName, String fileName) {
		
		WebDriver driver=new ChromeDriver();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
        File scr=ts.getScreenshotAs(OutputType.FILE);
        try {
			FileUtils.copyFile(scr, new File("screenshots/"+folderName+"/"+fileName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to take screesnhot");
		}
	}
}
