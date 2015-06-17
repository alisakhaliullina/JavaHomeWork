package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.example.fw.ApplicationManager;

public class TestBase {

	static ApplicationManager app;

	@BeforeTest
		public void setUp() throws Exception {
		Properties properties = new Properties();
		properties.load(new FileReader(new File("application.properties")));
		
			app = ApplicationManager.getInstance(properties);
		}
	
	public static List<Object[]> wrapGroupsForDataProvider(List<GroupObject> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupObject group : groups) {
			
		
			list.add(new Object[]{group});
		}
		return list;
	}

	@AfterTest
		public void tearDown() throws Exception {
			ApplicationManager.getInstance().stop();
		}

	public static List<Object[]> wrapContactForDataProvider(List<ContactInformationObject> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactInformationObject contact : contacts) {
			list.add(new Object[]{contact});
		}
				return list;
	}
}