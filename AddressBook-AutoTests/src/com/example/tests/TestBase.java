package com.example.tests;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import com.example.fw.ApplicationManager;

public class TestBase {

protected ApplicationManager app;
	

@BeforeClass
	public void setUp() throws Exception {
		app = ApplicationManager.getInstance();
	}
	
@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance().stop();
	}

}
