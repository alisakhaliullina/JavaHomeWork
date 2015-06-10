package com.example.fw;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.example.tests.ContactInformationObject;
import com.example.tests.SelectDateObject;
import com.example.tests.SelectGroupObject;
import com.example.tests.SelectMonthObject;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperWithWebDriverBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
	super(manager);
	}

	private SortedListOf<ContactInformationObject> cachedContacts;

	public SortedListOf<ContactInformationObject> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
	return cachedContacts;
	}
	
	private void rebuildCache() {
		 cachedContacts = new SortedListOf<ContactInformationObject>();
			 manager.navigateTo().startPage();
			 List<WebElement> rows = driver.findElements(By.name ("entry"));
			 	for(WebElement row : rows) {
			 		ContactInformationObject contact = new ContactInformationObject()
			 		.setFirstname(row.findElement(By.xpath(".//td[2]")).getText())
			 		.setLastname(row.findElement(By.xpath(".//td[3]")).getText());
			 	cachedContacts.add(contact); 

			 	}
	}

	public ContactHelper fillContactForm(ContactInformationObject contactInformationObject, SelectDateObject validDate, SelectMonthObject validMonth, SelectGroupObject validGroupAdd, boolean formType) {
		manager.navigateTo().addNewContact();
			manager.getSelectHelper()
			.selectMonth(validMonth)
			.selectDate(validDate)
			.selectGroup(validGroupAdd);
    	
			fillContactInformation(contactInformationObject); 
    			submitChanges();
    				goBackToContactsPage();
    					rebuildCache();
    	return this;
	}	

	public ContactHelper modifyContact(int i, ContactInformationObject contactInformationObject, boolean formType) {
		manager.navigateTo().startPage();
			editContact(i);
				fillContactInformation(contactInformationObject);
					click(By.xpath("(//input[@name='update'])[1]"));
						goBackToContactsPage();
						rebuildCache();
						cachedContacts = null;
		return this;
	}

	public ContactHelper deleteContact(int i) {
		manager.navigateTo().startPage();
			editContact(i);
				click(By.xpath("(//input[@name='update'])[2]"));
					goBackToContactsPage();
					rebuildCache();
		return this;
	}

	private ContactHelper submitChanges() {
		click(By.name("submit"));
			cachedContacts = null;
		return this;
	}

	private ContactHelper goBackToContactsPage() {
		click(By.linkText("home page"));
		return this;
	}

	private ContactHelper fillContactInformation(ContactInformationObject contactInformationObject) {
		type("firstname", contactInformationObject.getFirstname());
		type("lastname", contactInformationObject.getFirstname());
		type("address", contactInformationObject.getAddress());
		type("home", contactInformationObject.getHome());
		type("mobile", contactInformationObject.getMobile());
		type("work", contactInformationObject.getWork());
		type("email", contactInformationObject.getEmail());
		type("email2", contactInformationObject.getEmail());
		type("byear", contactInformationObject.getByear());
		type("address2", contactInformationObject.getAddress());
		type("phone2", contactInformationObject.getPhone2());
		return this;
	}

	protected void type(String locator, String name) {
		findElement(By.name(locator)).clear();
		findElement(By.name(locator)).sendKeys(name);
	}

	protected ContactHelper addNewContact() {
		click(By.linkText("add new"));
		return this;
	}

	private ContactHelper editContact(int i) {
		click(By.cssSelector("img[alt=\"Edit\"]"));
		return this;
	}
}