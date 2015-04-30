package com.example.tests;

import org.testng.annotations.Test;


public class ContactModificationTests extends TestBase {
  
	
@Test
  	public void testContactModifications() throws Exception {
	ContactInformationObject validContactInformation = new ContactInformationObject("zzzzzzzzzzz", "b", "cwwwwwwwww", "123", "456", "789", "321", "654", "", "", "");
		app.getContacthelper().modifyContact(0, validContactInformation); 
		
	}
}

