package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;

public class CreateNewContact extends TestBase {


	@Test (dataProvider = "randomContacts")
		public void createValidContact(ContactInformationObject validContact) throws Exception {
	
			SortedListOf<ContactInformationObject> oldList = app.getContactHelper().getContacts();
	
		SelectDateObject validDate = new SelectDateObject("1");
			SelectMonthObject validMonth = new SelectMonthObject("January");
				SelectGroupObject validGroupAdd = new SelectGroupObject("123");
					app.getContactHelper().fillContactForm(validContact, validDate, validMonth, validGroupAdd, CREATION);
	
			SortedListOf<ContactInformationObject> newList = app.getContactHelper().getContacts();
	  
		assertThat(newList, equalTo(oldList.withAdded(validContact)));

}
  
	@Test
		public void createEmptyContact() throws Exception {
		
			SortedListOf<ContactInformationObject> oldList = app.getContactHelper().getContacts();
		
		ContactInformationObject emptyContact = new ContactInformationObject("", "", "", "", "", "", "", "", "", "", "", "");
			
		SelectDateObject validDate = new SelectDateObject("-");
			SelectMonthObject validMonth = new SelectMonthObject("-");
				SelectGroupObject validGroupAdd = new SelectGroupObject("[none]");
					app.getContactHelper().fillContactForm(emptyContact, validDate, validMonth, validGroupAdd, CREATION);
		
			SortedListOf<ContactInformationObject> newList = app.getContactHelper().getContacts();
					  
		assertThat(newList, equalTo(oldList.withAdded(emptyContact)));	
	}
 }