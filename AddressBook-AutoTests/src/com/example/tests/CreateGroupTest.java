package com.example.tests;

import org.testng.annotations.Test;


public class CreateGroupTest extends TestBase {
  
	
@Test
  public void testValidGroupCanBeCreated() throws Exception {
  GroupObject validGroup = new GroupObject("123", "qwe", "asd");
  app.getGroupHelper().createGroup(validGroup); 
}

@Test
  public void testValidGroupWithEmptyFieldsCanBeCreated() throws Exception {
  GroupObject emptyFieldGroup = new GroupObject("", "", "");
	app.getGroupHelper().createGroup(emptyFieldGroup);
  }
}

