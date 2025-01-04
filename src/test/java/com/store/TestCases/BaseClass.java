package com.store.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.store.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();
	
	public static WebDriver driver ;
	public static Logger logger;

	@BeforeClass
	public void setUp() {
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "msedge":
			WebDriverManager.chromedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;
		}
		
		//Implicit wait for 10 second 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//maximum windows
		driver.manage().window().maximize();
		
		//Logger 
		logger = LogManager.getLogger("MyStore");
		
		//Open URL
		driver.get(url);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit(); 
		
	}
	
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
			
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		
		File dest =  new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");
		FileUtils.copyFile(src, dest);
	}
	
	
	
	
		
}	


