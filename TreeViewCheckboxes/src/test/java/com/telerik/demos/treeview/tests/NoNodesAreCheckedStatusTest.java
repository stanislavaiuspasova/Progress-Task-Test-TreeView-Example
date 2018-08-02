package com.telerik.demos.treeview.tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.telerik.demos.treeview.utils.*;

public class NoNodesAreCheckedStatusTest {

	@Before
	public void init() {
		Browser.setUp();
	}

	@Test
	public void checkStatusOfTheNodesWhenNoNodesAreChecked() {
		// Get the result status message
		WebElement element = Browser.driver.findElement(By.id("result"));
		String messageText = element.getText();
		
		// Verify message element's text displays "No nodes checked."
		assertEquals("No nodes checked.", messageText);
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
}