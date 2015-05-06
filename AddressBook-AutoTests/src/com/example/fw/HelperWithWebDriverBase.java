package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.SelectDateObject;
import com.example.tests.SelectGroupObject;
import com.example.tests.SelectMonthObject;

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
	
	protected void type(By by, String text) {
    	if (text == null || text == "") return;
    	WebElement element = findElement(by);
	element.clear();
        element.sendKeys(text);
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
	
	protected WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	protected void openUrl(String string) {
		driver.get(string);
	}
	
	protected void click(By locator) {
		findElement(locator).click();
	}
	protected void selectMonth(SelectMonthObject selectMonthObject) {
			new Select(findElement(By.name("bmonth"))).selectByVisibleText(selectMonthObject.month);
	}
	protected void selectDate(SelectDateObject selectDateObject) {
			new Select(findElement(By.name("bday"))).selectByVisibleText(selectDateObject.day);
	}
	protected void selectGroup(SelectGroupObject selectGroupObject) {
		new Select(findElement(By.name("new_group"))).selectByVisibleText(selectGroupObject.groupname); 
	}
//	protected void click(By linkText) {
//		findElement(linkText).click();
//	}


	
}
