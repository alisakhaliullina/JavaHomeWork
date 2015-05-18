package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {
  
	
@Test
  	public void testContactModifications() throws Exception {
	
		app.getNavigationHelper().openStartPage();
		
		List<ContactInformationObject> oldList = app.getContactHelper().getContacts();
		
		ContactInformationObject validContact = new ContactInformationObject("zzzzzzzzzzz", "b", "cwwwwwwwww", "123", "456", "789", "321", "654", "", "", "", "");
			app.getContactHelper().modifyContact(0, validContact); 
		
		List<ContactInformationObject> newList = app.getContactHelper().getContacts();
			  
	oldList.remove(0);
	oldList.add(validContact);
	Collections.sort(oldList);
	Collections.sort(newList);
		assertEquals(newList, oldList);
	}
}

