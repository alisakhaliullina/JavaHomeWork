package com.example.tests;


import org.testng.annotations.Test;


public class CreateNewContact extends TestBase {


@Test
  public void createValidContact() throws Exception {
	ContactInformationObject validContactInformation = new ContactInformationObject("aaaa", "bbb", "ccc", "123", "456", "789", "321", "654", "1111", "123qwe", "456ewq");
	SelectDateObject validDate = new SelectDateObject("1");
	SelectMonthObject validMonth = new SelectMonthObject("January");
	SelectGroupObject validGroupAdd = new SelectGroupObject("123");
	app.getContacthelper().fillContactForm(validContactInformation, validDate, validMonth,
			validGroupAdd);
    
  }
  
@Test
public void createEmptyContact() throws Exception {
ContactInformationObject emptyContactInformation = new ContactInformationObject("", "", "", "", "", "", "", "", "", "", "");
	SelectDateObject validDate = new SelectDateObject("-");
	SelectMonthObject validMonth = new SelectMonthObject("-");
	SelectGroupObject validGroupAdd = new SelectGroupObject("[none]");
	app.getContacthelper().fillContactForm(emptyContactInformation, validDate, validMonth,
			validGroupAdd);
    
  }
  
}

