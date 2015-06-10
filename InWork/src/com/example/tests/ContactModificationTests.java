package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTests extends TestBase {
  
	
	@Test
  		public void testContactModifications() throws Exception {
	
			SortedListOf<ContactInformationObject> oldList = app.getContactHelper().getContacts();
		
		ContactInformationObject validContact = new ContactInformationObject("zzzzzzzzzzz", "b", "cwwwwwwwww", "123", "456", "789", "321", "654", "", "", "", "");
		
		app.getContactHelper().modifyContact(0, validContact, MODIFICATION); 
		
			SortedListOf<ContactInformationObject> newList = app.getContactHelper().getContacts();
			  
		assertThat(newList, equalTo(oldList.without(0).withAdded(validContact)));	
		}
}