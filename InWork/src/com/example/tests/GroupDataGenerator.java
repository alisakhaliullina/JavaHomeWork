package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.tests.GroupObject;

public class GroupDataGenerator {

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

List<GroupObject> groups = generateRandomGroups(amount);
if ("csv".equals(format)) {
	saveGroupsToCsvFile(groups, file);
} else if ("xml".equals(format)){
	saveGroupsToXmlFile(groups, file);
	} else {
		System.out.println("Unknown format" + format);
		return;
		}
	}

	private static void saveGroupsToXmlFile(List<GroupObject> groups, File file) {
		// TODO Auto-generated method stub
		
	}

	private static void saveGroupsToCsvFile(List<GroupObject> groups, File file) throws IOException {
		
			FileWriter writer = new FileWriter(file);
			for (GroupObject group : groups) {
				writer.write(group.getName() + "," + group.getHeader() + "," + group.getFooter() + "," + "\n");
			}
			writer.close();
		}
		

	public static List<GroupObject> loadGroupsFromCsvFile(File file) throws IOException {
		List<GroupObject> list = new ArrayList<GroupObject>();
		FileReader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		String line = bufferedReader.readLine();
		while (line != null) {
			String[] part = line.split(",");
			GroupObject group = new GroupObject()
			.setName(part[0])
			.setHeader(part[1])
			.setFooter(part[2]);
			list.add(group);
			line = bufferedReader.readLine();
			
		}
				bufferedReader.close();
		return list;
	}

	public static List<GroupObject> generateRandomGroups(int amount) {
		
		List<GroupObject> list = new ArrayList<GroupObject>();
		for (int i = 0; i < amount; i++) {
			GroupObject group = new GroupObject()
			.setName("name"+rnd.nextInt())
			.setHeader("header"+rnd.nextInt())
			.setFooter("footer"+rnd.nextInt());	
		list.add(group);
		} 
	
		return list;
	}
	
	static Random rnd = new Random();
}