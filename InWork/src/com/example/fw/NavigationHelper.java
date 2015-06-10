package com.example.fw;

import org.openqa.selenium.By;

public class NavigationHelper extends HelperWithWebDriverBase {

	
	public NavigationHelper (ApplicationManager manager) {
		super(manager);
		
	}
		
	public void groupTab() {
		if (! onGroupTab()) {
			findElement(By.linkText("groups")).click();
			}	
	}

	private boolean onGroupTab() {
		if (driver.getCurrentUrl().contains("/group.php")
			&& driver.findElements(By.name("new")).size() > 0) {
		return true;
		} 
		else {
		return false;
		}
	}
	
	public void startPage() {
		if (! onStartPage()) {	
			click(By.linkText("home"));
		}
	}
	
	private boolean onStartPage() {
		return driver.findElements(By.id("maintable")).size() > 0;
	}

	void addNewContact() {
		click(By.linkText("add new"));
	}	
}