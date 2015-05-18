package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class GroupModificationTests extends TestBase {
  
	
@Test
  	public void testFirstGroupCanBeRemoved() throws Exception {
	
		app.getNavigationHelper().openGroupTab();
		
		List<GroupObject> oldList = app.getGroupHelper().getGroups();
		 
		GroupObject validGroup = new GroupObject("321", "ewq", "dsa");
			app.getGroupHelper().modifyGroup(0, validGroup); 
		
		List<GroupObject> newList = app.getGroupHelper().getGroups();

	oldList.remove(0);
		oldList.add(validGroup);
			Collections.sort(oldList);
	assertEquals(newList, oldList);
	
	}
}

