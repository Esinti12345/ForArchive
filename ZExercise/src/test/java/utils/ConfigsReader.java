package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {

	public static Properties prop;

	public static void readProperties(String filePath) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop = new Properties();

			prop.load(fis);
			// FileInputStream("src/test/resources/configs/Credentials.Properties")); //
			// combine of 16.and 20. lines
			// if we dont create a constant class, there is only this long way to access the
			// path
			// but after constant`s class presence, we dont need this anymore.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		System.out.println(prop);
		System.out.println("acessing the key");
		
		return prop.getProperty(key);
	}

	// above two methods in one method below

	public static String twoInOne(String key) throws IOException {
		
		Properties propTwo = new Properties();

		try {
			propTwo.load(new FileInputStream("src/test/resources/configs/credentials.properties"));
		} catch (Exception e) {

			e.printStackTrace();

		}
		return propTwo.getProperty(key);

	}

}
