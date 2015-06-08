package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;


public class ContactRemovalTests extends TestBase {
  
	
	@Test
  		public void testContactCanBeRemoved() throws Exception {
		
			SortedListOf<ContactInformationObject> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().deleteContact(0); 
	
			SortedListOf<ContactInformationObject> newList = app.getContactHelper().getContacts();
		  
		assertThat(newList, equalTo(oldList.without(0)));

	}
}

