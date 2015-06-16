package com.example.fw;

import org.testng.Assert;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverHelper {
	
	protected WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	private ApplicationManager manager;
	private Properties properties;
	
	public WebDriverHelper( ApplicationManager manager, Properties properties) {
	this.manager = manager;
		
			///////////////////////////////////////////
		this.properties = properties;
		String browser = properties.getProperty("browser");
			if ("firefox".equals(browser)) {
			driver = new FirefoxDriver();
					} else if ("ie".equals(browser)) {
			driver = new InternetExplorerDriver();	
					}
					else {
						throw new Error ("Unsupported browser" + browser);
					}
		
		//////////////////////////////////////
			
//			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://localhost/addressbookv4.1.4/");
	}
		
	public void stop() {
		driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    	if (!"".equals(verificationErrorString)) {
	    		Assert.fail(verificationErrorString);
	    	}
	}

	public WebDriver getDriver() {
				return driver;
	}
}
