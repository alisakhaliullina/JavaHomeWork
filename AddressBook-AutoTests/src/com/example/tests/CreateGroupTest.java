package com.example.tests;
	
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.*;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
public class CreateGroupTest extends TestBase {
	
	@DataProvider 
		public Iterator<Object[]> groupsFromFile() throws IOException{
			return wrapGroupsForDataProvider(loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
		}
	
	

	@Test (dataProvider = "groupsFromFile")
		public void testValidGroupCanBeCreated(GroupObject validGroup) throws Exception {

			SortedListOf<GroupObject> oldList = app.getGroupHelper().getGroups();
	
		app.getGroupHelper().createGroup(validGroup); 
  
			SortedListOf<GroupObject> newList = app.getGroupHelper().getGroups();
  
		assertThat(newList, equalTo(oldList.withAdded(validGroup)));
		}


	@Test
		public void testValidGroupWithEmptyFieldsCanBeCreated() throws Exception {
	
			SortedListOf<GroupObject> oldList = app.getGroupHelper().getGroups();
 
		GroupObject emptyGroup = new GroupObject("", "", "");
				GroupObject emptyFieldGroup = emptyGroup;
					app.getGroupHelper().createGroup(emptyFieldGroup);
  
			SortedListOf<GroupObject> newList = app.getGroupHelper().getGroups();
		
		assertThat(newList, equalTo(oldList.withAdded(emptyGroup)));

		}
}