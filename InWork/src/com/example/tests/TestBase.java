package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//import java.util.Random;


import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;


public class TestBase {

static ApplicationManager app;
//Random rnd = new Random();
	

	@BeforeTest
		public void setUp() throws Exception {
//////////////////////////////////////////////////////////////////////////////////
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		
	/////////////////////////////////////////////////////////////////////////////	
			app = ApplicationManager.getInstance(properties);
		}
	
//	@DataProvider(name = "randomGroups")
//	public Iterator<Object[]> generateRndGroups() {
//		
////				new ArrayList<Object[]>();
////		for (int i = 0; i < 2; i++) {
////			GroupObject group = new GroupObject()
////			.setName("name"+rnd.nextInt())
////			.setHeader("header"+rnd.nextInt())
////			.setFooter("footer"+rnd.nextInt());	
////		list.add(new Object[]{group});
////		} 
//	
//		return wrapGroupsForDataProvider(generateRandomGroups(2)).iterator();
//	}

	public static List<Object[]> wrapGroupsForDataProvider(List<GroupObject> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupObject group : groups) {
			
		} {
			list.add(new Object[]{groups});
		}
		
		return list;
	}

	@AfterTest
		public void tearDown(Properties properties) throws Exception {
			ApplicationManager.getInstance(properties).stop();
		}

//	@DataProvider(name = "randomContacts")
//	public Iterator<Object[]> generateRndContacts() {
//		
////		
////		List<Object[]> list = new ArrayList<Object[]>();
////		for (int i = 0; i < 1; i++) {
////
////			ContactInformationObject contact = new ContactInformationObject()
////			.setFirstname("firstname"+rnd.nextInt())
////			.setLastname("lastname"+rnd.nextInt())
////			.setAddress("address"+rnd.nextInt())
////			.setHome("home"+rnd.nextInt())
////			.setMobile("mobile"+rnd.nextInt())
////			.setWork("work"+rnd.nextInt())
////			.setEmail("email"+rnd.nextInt())
////			.setEmail2("email2"+rnd.nextInt())
////			.setByear("byear"+rnd.nextInt())
////			.setAddress2("address2"+rnd.nextInt())
////			.setPhone2("phone2"+rnd.nextInt());
////			
////			list.add(new Object[]{contact});
////		} 
//
//		return wrapContactForDataProvider(generateRandomContacts(2)).iterator();
//
//	}

	

	public static List<Object[]> wrapContactForDataProvider(List<ContactInformationObject> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactInformationObject contact : contacts) {
			
		} {
			list.add(new Object[]{contacts});
		}
		
		return list;
	}




}