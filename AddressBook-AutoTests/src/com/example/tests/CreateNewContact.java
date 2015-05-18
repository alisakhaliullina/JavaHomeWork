package com.example.tests;


import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CreateNewContact extends TestBase {


	Random rnd = new Random();


	@DataProvider (name = "randomContacts")

		public Iterator<Object[]>  generateRandomContacts() {
	
		List<Object[]> list = new ArrayList<Object[]>();
			for (int i = 0; i < 1; i++) {
		
			ContactInformationObject contact = new ContactInformationObject()
				.setFirstname("firstname"+rnd.nextInt())
				.setLastname("lastname"+rnd.nextInt())
				.setAddress("address"+rnd.nextInt())
				.setHome("home"+rnd.nextInt())
				.setMobile("mobile"+rnd.nextInt())
				.setWork("work"+rnd.nextInt())
				.setEmail("email"+rnd.nextInt())
				.setEmail2("email2"+rnd.nextInt())
				.setByear("byear"+rnd.nextInt())
				.setAddress2("address2"+rnd.nextInt())
				.setPhone2("phone2"+rnd.nextInt());
			list.add(new Object[]{contact});
		} 
	
		return list.iterator();
	
		}

	@Test (dataProvider = "randomContacts")
		public void createValidContact(ContactInformationObject validContact) throws Exception {
	
		app.getNavigationHelper().openStartPage();
		
		List<ContactInformationObject> oldList = app.getContactHelper().getContacts();
	
		SelectDateObject validDate = new SelectDateObject("1");
			SelectMonthObject validMonth = new SelectMonthObject("January");
				SelectGroupObject validGroupAdd = new SelectGroupObject("123");
					app.getContactHelper().fillContactForm(validContact, validDate, validMonth, validGroupAdd);
	
		List<ContactInformationObject> newList = app.getContactHelper().getContacts();
	  
		oldList.add(validContact);
			Collections.sort(oldList);
				Collections.sort(newList);
		assertEquals(newList, oldList);	


}
  
	@Test
		public void createEmptyContact() throws Exception {
		
		app.getNavigationHelper().openStartPage();
		
		List<ContactInformationObject> oldList = app.getContactHelper().getContacts();
		
		ContactInformationObject emptyContactInformation = new ContactInformationObject("", "", "", "", "", "", "", "", "", "", "", "");
			
		SelectDateObject validDate = new SelectDateObject("-");
			SelectMonthObject validMonth = new SelectMonthObject("-");
				SelectGroupObject validGroupAdd = new SelectGroupObject("[none]");
					app.getContactHelper().fillContactForm(emptyContactInformation, validDate, validMonth, validGroupAdd);
		
		List<ContactInformationObject> newList = app.getContactHelper().getContacts();
					  
					oldList.add(emptyContactInformation);
						Collections.sort(oldList);
							Collections.sort(newList);
					assertEquals(newList, oldList);	   
		}
  
}

