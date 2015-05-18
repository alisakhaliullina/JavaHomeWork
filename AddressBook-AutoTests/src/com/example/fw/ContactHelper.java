package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactInformationObject;
import com.example.tests.SelectDateObject;
import com.example.tests.SelectGroupObject;
import com.example.tests.SelectMonthObject;

public class ContactHelper extends HelperWithWebDriverBase {

public ContactHelper(ApplicationManager manager) {
	super(manager);
}

public void fillContactForm(ContactInformationObject contactInformationObject, SelectDateObject validDate, SelectMonthObject validMonth, SelectGroupObject validGroupAdd) {
		manager.getNavigationHelper().addNewContact();
	    manager.getSelectHelper().selectMonth(validMonth);
	    manager.getSelectHelper().selectDate(validDate);
	    manager.getSelectHelper().selectGroup(validGroupAdd);
	    	fillContactInformation(contactInformationObject); 
	    		submitChanges();
	    			goBackToContactsPage();
}

private void submitChanges() {
		click(By.name("submit"));
}

private void goBackToContactsPage() {
		click(By.linkText("home page"));
}


private void fillContactInformation(ContactInformationObject contactInformationObject) {
	type("firstname", contactInformationObject.firstname);
	type("lastname", contactInformationObject.lastname);
	type("address", contactInformationObject.address);
	type("home", contactInformationObject.home);
    type("mobile", contactInformationObject.mobile);
    type("work", contactInformationObject.work);
    type("email", contactInformationObject.email);
    type("email2", contactInformationObject.email2);
    type("byear", contactInformationObject.byear);
    type("address2", contactInformationObject.address2);
    type("phone2", contactInformationObject.phone2);
    
}

protected void type(String locator, String name) {
	findElement(By.name(locator)).clear();
		findElement(By.name(locator)).sendKeys(name);
}

protected void addNewContact() {
	click(By.linkText("add new"));
}


public void deleteContact(int i) {
	manager.getNavigationHelper().openStartPage();
		editContact(i);
			click(By.xpath("(//input[@name='update'])[2]"));
				goBackToContactsPage();
}

private void editContact(int i) {
	click(By.cssSelector("img[alt=\"Edit\"]"));
}

public void modifyContact(int i, ContactInformationObject contactInformationObject) {
	manager.getNavigationHelper().openStartPage();
		editContact(i);
			fillContactInformation(contactInformationObject);
				click(By.xpath("(//input[@name='update'])[1]"));
					goBackToContactsPage();
}


public List<ContactInformationObject> getContacts() {
	List<ContactInformationObject> contacts = new ArrayList<ContactInformationObject>();
		List<WebElement> lastNamesTable = driver.findElements(By.xpath(".//*[@id='maintable']/tbody/tr/td[3]"));
	
		for(WebElement lastName : lastNamesTable){
			ContactInformationObject contact = new ContactInformationObject();
				contact.firstname = lastName.getText();
					contacts.add(contact);
		}
	return contacts;
}

}