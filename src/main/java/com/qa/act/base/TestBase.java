package com.qa.act.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shade.common.org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.act.utilities.TestUtil;

public class TestBase {
	public static WebDriver driver;
    public static Properties prop;

	public TestBase() {
		try 
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("C:\\Users\\Vidhya Sagar\\eclipse-workspace\\Act\\src\\main\\java\\"
					+ "com\\qa\\act\\config\\config.properties");
		    prop.load(ip);
		    }
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
		}	
	}//Closing constructor 
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Vidhya Sagar\\Desktop\\sagar\\chromedriver.exe");
		    driver = new ChromeDriver();
		}else if(browserName.equals("FF")){
			//Settings system property for Firefox driver
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Vidhya Sagar\\Downloads\\geckodriver.exe");
	        driver = new FirefoxDriver();
		}
		else {
			System.out.println("Browser not found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Timeout,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implict_Timeout,TimeUnit.SECONDS);
		 
		String urlName=prop.getProperty("url");
		driver.get(urlName);
	}		
	public static void takeScreenshot(String fileName) throws IOException {
		// Take screenshot and store it in file format
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//To save the screenshot in specified project file/directory
		FileUtils.copyFile(file, new File("C:\\Users\\Vidhya Sagar\\eclipse-workspace\\Act"
				+ "\\src\\main\\java\\Screenshots\\"+fileName+".jpg"));
		
	}
}
	
