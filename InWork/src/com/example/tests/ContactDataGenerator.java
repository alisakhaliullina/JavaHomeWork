package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.tests.ContactInformationObject;
import com.thoughtworks.xstream.XStream;

public class ContactDataGenerator {

	public static void main(String[] args) throws IOException {
		
	if (args.length < 3) {
	System.out.println("Please specify parametrs: <amount of test data> <file> <format>");
	return;
	}
	
	int amount = Integer.parseInt(args[0]);
	File file = new File(args[1]);
	String format = args[2];
	
	if (file.exists()) {
		System.out.println("File exists, please remove it mannually: " + file);
		return;	
	}

	List<ContactInformationObject> contacts = generateRandomContacts(amount);
	if ("csv".equals(format)) {
		saveContactsToCsvFile(contacts, file);
	} else if ("xml".equals(format)){
		saveContactsToXmlFile(contacts, file);
		} else {
			System.out.println("Unknown format" + format);
			return;
			}
		
	}
	private static void saveContactsToXmlFile(List<ContactInformationObject> contacts, File file) throws IOException {
		// TODO Auto-generated method stub
		XStream xstream = new XStream();
		xstream.alias("contact", ContactInformationObject.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static  List<ContactInformationObject> loadGroupsFromXmlFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact", ContactInformationObject.class);
		return (List<ContactInformationObject>) xstream.fromXML(file);
	}
	
	
	private static void saveContactsToCsvFile(List<ContactInformationObject> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactInformationObject contact : contacts) {
			writer.write(contact.getFirstname() + "," + contact.getLastname() + ",!" + "\n");
		}
		writer.close();
	}
	
	//
public static List<ContactInformationObject> loadContactsFromCsvFile(File file)  throws IOException {
		
		List<ContactInformationObject> list = new ArrayList<ContactInformationObject>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			ContactInformationObject contact = new ContactInformationObject()
			.setFirstname(part[0])
			.setLastname(part[1]);
			
			list.add(contact);
			line = bufferedReader.readLine();
			
		}
				bufferedReader.close();
		return list;
	
	}
	
	public static List<ContactInformationObject> generateRandomContacts(int amount) {
	List<ContactInformationObject> list = new ArrayList<ContactInformationObject>();
	for (int i = 0; i < amount; i++) {

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
		
		list.add(contact);
	} 

	return list;
}

	
	static Random rnd = new Random();
}







































