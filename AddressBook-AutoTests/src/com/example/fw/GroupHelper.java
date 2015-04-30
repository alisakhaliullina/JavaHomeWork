package com.example.fw;

import org.openqa.selenium.By;
import com.example.tests.GroupObject;

public class GroupHelper extends HelperWithWebDriverBase {

	public GroupHelper (ApplicationManager manager) {
		super(manager);
	}

	public void createGroup(GroupObject groupObject) {
		manager.getNavigationHelper().openGroupTab();
	    createNewGroup();
	    fillNewGroupFields(groupObject);
	    submitChanges();
	    goBackToGroupPage();
	}

	public void deleteGroup(int i) {
		manager.getNavigationHelper().openGroupTab();
		checkGroup(i);
		click(By.name("delete"));
		goBackToGroupPage();
	}

	private void checkGroup(int i) {
		click(By.name("selected[]"));
	}

	public void modifyGroup(int i, GroupObject groupObject) {
		manager.getNavigationHelper().openGroupTab();
		createGroupModification(i);
	    fillNewGroupFields(groupObject);
	    submitGroupModification();
	   	goBackToGroupPage();
	}
	
private void submitGroupModification() {
	click(By.name("update"));
	}

private void createGroupModification(int i) {
	checkGroup(i);
	click(By.name("edit"));
	}

private void goBackToGroupPage() {
		click(By.linkText("group page"));
	}

private void submitChanges() {
		click(By.name("submit"));
	}

private void fillNewGroupFields(GroupObject groupObject) {
		type("group_name", groupObject.name);
	    type("group_header", groupObject.header);
	    type("group_footer", groupObject.footer);
	}

private void createNewGroup() {
	findElement(By.name("new")).click();
}

protected void type(String locator, String name) {
	findElement(By.name(locator)).clear();
    findElement(By.name(locator)).sendKeys(name);
	}
}