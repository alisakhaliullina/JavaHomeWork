package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;

@Test (dataProvider = "contactsFromFile")
	public class CreateNewContact extends TestBase {

	
@DataProvider 
	public Iterator<Object[]> contactsFromFile()  throws IOException {

		return wrapContactForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();
	}

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