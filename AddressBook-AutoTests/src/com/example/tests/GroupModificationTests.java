package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class GroupModificationTests extends TestBase {
  
	
@Test
  	public void testFirstGroupCanBeRemoved() throws Exception {
			
		SortedListOf<GroupObject> oldList = app.getGroupHelper().getGroups();
		 
	GroupObject validGroup = new GroupObject("321", "ewq", "dsa");
		app.getGroupHelper().modifyGroup(0, validGroup); 
		
		SortedListOf<GroupObject> newList = app.getGroupHelper().getGroups();

	assertThat(newList, equalTo(oldList.without(0).withAdded(validGroup)));
	}
}