package com.example.tests;
	
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class CreateGroupTest extends TestBase {
	
	@Test (dataProvider = "randomGroups")
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

