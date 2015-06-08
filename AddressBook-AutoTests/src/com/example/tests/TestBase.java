package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {

static ApplicationManager app;
Random rnd = new Random();
	

	@BeforeClass
		public void setUp() throws Exception {
			app = ApplicationManager.getInstance();
		}
	
	@DataProvider(name = "randomGroups")
	public Iterator<Object[]> generateRandomGroups() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i = 0; i < 2; i++) {
			GroupObject group = new GroupObject()
			.setName("name"+rnd.nextInt())
			.setHeader("header"+rnd.nextInt())
			.setFooter("footer"+rnd.nextInt());	
		list.add(new Object[]{group});
		} 
	
		return list.iterator();
	}

	@AfterTest
		public void tearDown() throws Exception {
			ApplicationManager.getInstance().stop();
		}

	@DataProvider(name = "randomContacts")
	public Iterator<Object[]> generateRandomContacts() {
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
}