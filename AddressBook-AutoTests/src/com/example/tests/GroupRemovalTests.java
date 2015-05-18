package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import org.testng.annotations.Test;
public class GroupRemovalTests extends TestBase {
  
	
@Test
  	public void testFirstGroupCanBeRemoved() throws Exception {
	
	app.getNavigationHelper().openGroupTab();
	
	List<GroupObject> oldList = app.getGroupHelper().getGroups();
	 
	app.getGroupHelper().deleteGroup(0); 
	
	List<GroupObject> newList = app.getGroupHelper().getGroups();


	oldList.remove(0);
		Collections.sort(oldList);
	assertEquals(newList, oldList);
	}
}

