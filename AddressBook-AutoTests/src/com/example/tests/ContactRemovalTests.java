package com.example.tests;

import org.testng.annotations.Test;


public class ContactRemovalTests extends TestBase {
  
	
@Test
  	public void testContactCanBeRemoved() throws Exception {
		app.getContacthelper().deleteContact(0); 
	}
}

