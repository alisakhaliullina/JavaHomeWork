package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperWithWebDriverBase {

	protected ApplicationManager manager;
	private WebDriver driver;

	public HelperWithWebDriverBase (ApplicationManager manager) {
		this.manager = manager;
		driver = manager.getWebDriverHelper().getDriver();
		
	}
	protected void type(String locator, String name) {
		driver.findElement(By.name(locator)).clear();
	    driver.findElement(By.name(locator)).sendKeys(name);
	}


	protected boolean isElementPresent(By by) {
	    try {
	      driver.findElement(by);
	      return true;
	    } 
	    	catch (NoSuchElementException e) {
	    		return false;
	    	}
	}

	protected boolean isAlertPresent() {
	    try {
	    	driver.switchTo().alert();
	    	return true;
	    } 
	    	catch (NoAlertPresentException e) {
	    		return false;
	    	}
	}
	protected WebElement findElement(By linkText) {
		return driver.findElement(linkText);
	}
	protected void openUrl(String string) {
		driver.get(string);
	}
	
	protected void click(By linkText) {
		findElement(linkText).click();
	}


}
