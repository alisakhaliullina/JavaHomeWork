package com.example.fw;


import org.testng.Assert;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	
	private static ApplicationManager singletone;

	private WebDriverHelper webDriverHelper;
	
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private NavigationHelper navigationHelper;
	private HelperWithWebDriverBase selectHelper;
		
	protected static WebDriver driver;
	private static Properties properties;

		
	public static ApplicationManager getInstance(Properties properties) {
		
		
		ApplicationManager.properties = properties;
		String browser = properties.getProperty("browser");
		
		if ("firefox".equals(browser)) {
		driver = new FirefoxDriver();
				} else if ("ie".equals(browser)) {
		driver = new InternetExplorerDriver();	
				}
				else {
					throw new Error ("Unsupported browser" + browser);
				}
		String baseUrl = properties.getProperty("baseUrl");
		driver.get(baseUrl);
		
		if (singletone == null) {
			singletone = new ApplicationManager();
		}
			return singletone;
		
			}
	
	public void stop() {
		if (webDriverHelper != null) {
			webDriverHelper.stop();
		}
		driver.quit();
	}
	
	

	public WebDriverHelper getWebDriverHelper() {
		if (webDriverHelper == null) {
				webDriverHelper = new WebDriverHelper(this);
		}	
					return webDriverHelper;
	}

	public GroupHelper getGroupHelper() {
		if (groupHelper == null) {
				groupHelper = new GroupHelper(this);
		}
					return groupHelper;
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
				contactHelper = new ContactHelper(this);
		}	
					return contactHelper;
	}

	
	public NavigationHelper navigateTo() {
		if (navigationHelper == null) {
				navigationHelper = new NavigationHelper(this);
		}		
					return navigationHelper;
	}
				

	public HelperWithWebDriverBase getSelectHelper() {
		if (selectHelper == null) {
				selectHelper = new SelectHelper(this);
		}		
					return selectHelper;
	}

	public static ApplicationManager getInstance() {
		return singletone;
	}
		
}