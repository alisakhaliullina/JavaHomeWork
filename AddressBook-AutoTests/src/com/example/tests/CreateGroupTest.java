package com.example.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateGroupTest extends TestBase {
	Random rnd = new Random();

	@DataProvider (name = "randomGroups")

	public Iterator<Object[]>  generateRandomGroups() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 2; i++) {
			GroupObject group = new GroupObject()
				.setName("name"+rnd.nextInt())
				.setHeader("header"+rnd.nextInt())
				.setFooter("footer"+rnd.nextInt());	
			list.add(new Object[]{group});
		} 
		
		return list.iterator();
	}
		
	@Test (dataProvider = "randomGroups")
		public void testValidGroupCanBeCreated(GroupObject validGroup) throws Exception {
			app.getNavigationHelper().openGroupTab();
		
		List<GroupObject> oldList = app.getGroupHelper().getGroups();
	
		app.getGroupHelper().createGroup(validGroup); 
  
		List<GroupObject> newList = app.getGroupHelper().getGroups();
  
		oldList.add(validGroup);
		Collections.sort(oldList);
			assertEquals(newList, oldList);

		}


	@Test
		public void testValidGroupWithEmptyFieldsCanBeCreated() throws Exception {
	
			app.getNavigationHelper().openGroupTab();
	
			List<GroupObject> oldList = app.getGroupHelper().getGroups();
 
			GroupObject validGroup = new GroupObject("", "", "");
				GroupObject emptyFieldGroup = validGroup;
					app.getGroupHelper().createGroup(emptyFieldGroup);
  
			List<GroupObject> newList = app.getGroupHelper().getGroups();
	 
			oldList.add(validGroup);
			Collections.sort(oldList);
				assertEquals(newList, oldList);

		}
}

