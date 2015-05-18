package com.example.fw;

import org.openqa.selenium.By;


public class NavigationHelper extends HelperWithWebDriverBase {

	
	public NavigationHelper (ApplicationManager manager) {
		super(manager);
		
	}
		
	public void openGroupTab() {
		findElement(By.linkText("groups")).click();
	}

	public void openStartPage() {
			openUrl("http://localhost/addressbookv4.1.4/");
	}
	
	void addNewContact() {
		click(By.linkText("add new"));
	}
	
}
	


