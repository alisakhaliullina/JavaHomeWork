package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.GroupObject;
import com.example.utils.SortedListOf;


public class GroupHelper extends HelperWithWebDriverBase {

	public GroupHelper (ApplicationManager manager) {
		super(manager);
	}

	private SortedListOf<GroupObject> cachedGroups;
	
			
	public SortedListOf<GroupObject> getGroups() {
		if (cachedGroups == null) {
			rebuildCache();
		}
		return cachedGroups;
	}
		
	private void rebuildCache() {
		cachedGroups = new SortedListOf<GroupObject>();
			manager.navigateTo().groupTab();
				List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
				for (WebElement checkbox : checkboxes) {
					String title = checkbox.getAttribute("title");
					String name = title.substring("Select (".length(), title.length() - ")".length());
					cachedGroups.add(new GroupObject().setName(name));
				}
	}
	
	public GroupHelper createGroup(GroupObject groupObject) {
		manager.navigateTo().groupTab();
	    	createNewGroup();
	    		fillNewGroupFields(groupObject); 
	    			submitChanges();
	    				goBackToGroupPage();
	    				rebuildCache();
	    return this;
	}
	
	public GroupHelper deleteGroup(int i) {
		manager.navigateTo().groupTab();
			checkGroup(i);
				click(By.name("delete"));
					goBackToGroupPage();
						rebuildCache();
		return this;
	}
	
	
	public GroupHelper modifyGroup(int i, GroupObject groupObject) {
		createGroupModification(i);
			fillNewGroupFields(groupObject);
				submitGroupModification();
					goBackToGroupPage();
						rebuildCache();
		return this;
	}
	
	private GroupHelper fillNewGroupFields(GroupObject groupObject) {
		type("group_name", groupObject.getName());
	    type("group_header", groupObject.getHeader());
	    type("group_footer", groupObject.getFooter());
	   
	    return this;
	}
	
	private GroupHelper checkGroup(int i) {
		click(By.name("selected[]"));
		return this;
	}

	private GroupHelper submitGroupModification() {
		click(By.name("update"));
			cachedGroups = null;
		return this;
	}

	private GroupHelper createGroupModification(int i) {
		checkGroup(i);
			click(By.name("edit"));
		return this;
	}

	private GroupHelper goBackToGroupPage() {
		click(By.linkText("group page"));
		return this;
	}

	private GroupHelper submitChanges() {
		click(By.name("submit"));
			cachedGroups = null;
		return this;
	}

	private GroupHelper createNewGroup() {
		findElement(By.name("new")).click();
		return this;
	}

	protected void type(String locator, String name) {
		findElement(By.name(locator)).clear();
    	findElement(By.name(locator)).sendKeys(name);
    	}
}