package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

//import java.io.BufferedReader;
import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.CREATION;
//import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.ContactDataGenerator.loadContactsFromCsvFile;
//import static com.example.tests.TestBase.wrapContactForDataProvider;



@Test (dataProvider = "contactsFromFile")
public class CreateNewContact extends TestBase {

	
	@DataProvider //(name = "randomContacts")
	public Iterator<Object[]> contactsFromFile()  throws IOException {

		return wrapContactForDataProvider(loadContactsFromCsvFile(new File("contacts.txt"))).iterator();

	}

//public static List<Object[]> loadContactsFromCsvFile(File file)  throws IOException {
//		
//		List<ContactInformationObject> list = new ArrayList<ContactInformationObject>();
//		FileReader reader = new FileReader(file);
//		BufferedReader bufferedReader = new BufferedReader(reader);
//		String line = bufferedReader.readLine();
//		while (line != null) {
//			String[] part = line.split(",");
//			ContactInformationObject contact = new ContactInformationObject()
//			.setFirstname(part[0])
//			.setLastname(part[1]);
//			
//			list.add(contact);
//			line = bufferedReader.readLine();
//			
//		}
//				bufferedReader.close();
//		return list;
//	
//	}

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