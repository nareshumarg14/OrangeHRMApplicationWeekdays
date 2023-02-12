package com.OrangeHRM.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;
	
	//public Logger logger = LogManager.getLogger(this.getClass());
	
	public Logger logger = LogManager.getLogger(this.getClass());
	
	/***
	 * Method can be used to launch application
	 * @throws IOException 
	 */
	@BeforeMethod
	@Parameters("browsername")
	public void setup(String bname) throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Training\\Selenium\\SeleniumTraining_2023\\OrangeHRM\\resources\\config.properties");
		prop.load(fis);
		
		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			logger.info("Chrome browser is launched");
		} else if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			logger.info("Edge browser is launched");
		}else {
			logger.info("As of now supported browsers are Chrome / Edge");
		}
		
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		
		//System.out.println("Orange HRM application is opened.");
		logger.info("Orange HRM application is opened.");
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
	}
	
	/***
	 * Method can be used to close application.
	 */
	@AfterMethod
	public void closeApplication() {
		driver.quit();
		//System.out.println("Orange HRM application is closed");
		logger.info("Orange HRM application is closed");
	}
	
	
}
