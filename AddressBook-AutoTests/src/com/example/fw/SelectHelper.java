package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.example.tests.SelectDateObject;
import com.example.tests.SelectGroupObject;
import com.example.tests.SelectMonthObject;

public class SelectHelper extends HelperWithWebDriverBase {

		public SelectHelper (ApplicationManager manager) {
		super(manager);
}

	protected void selectMonth(SelectMonthObject selectMonthObject) {
			new Select(findElement(By.name("bmonth"))).selectByVisibleText(selectMonthObject.month);
	}

	protected void selectDate(SelectDateObject selectDateObject) {
			new Select(findElement(By.name("bday"))).selectByVisibleText(selectDateObject.day);
	}

	protected void selectGroup(SelectGroupObject selectGroupObject) {
		new Select(findElement(By.name("new_group"))).selectByVisibleText(selectGroupObject.groupname); 
	}
	
	protected void click(By linkText) {
		findElement(linkText).click();
	}

	
}