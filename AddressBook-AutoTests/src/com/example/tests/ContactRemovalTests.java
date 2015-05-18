package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;


public class ContactRemovalTests extends TestBase {
  
	
@Test
  	public void testContactCanBeRemoved() throws Exception {
		
		app.getNavigationHelper().openStartPage();
	
		List<ContactInformationObject> oldList = app.getContactHelper().getContacts();
		
		app.getContactHelper().deleteContact(0); 
	
		List<ContactInformationObject> newList = app.getContactHelper().getContacts();
		  
		 
	oldList.remove(0);
	Collections.sort(oldList);
	Collections.sort(newList);
		assertEquals(newList, oldList);
	}
}

