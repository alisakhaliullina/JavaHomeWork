package com.example.tests;

import org.testng.annotations.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import com.example.utils.SortedListOf;

public class GroupRemovalTests extends TestBase {
  

	@Test
  		public void testFirstGroupCanBeRemoved() throws Exception {
	
			SortedListOf<GroupObject> oldList = app.getGroupHelper().getGroups();
	 
		app.getGroupHelper().deleteGroup(0); 
	
			SortedListOf<GroupObject> newList = app.getGroupHelper().getGroups();

		assertThat(newList, equalTo(oldList.without(0)));
	}
}