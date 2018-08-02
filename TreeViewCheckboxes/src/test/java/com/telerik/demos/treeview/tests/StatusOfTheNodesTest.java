package com.telerik.demos.treeview.tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.telerik.demos.treeview.utils.*;
import java.util.Random;

public class StatusOfTheNodesTest {

	@Before
	public void init() {
		Browser.setUp();
	}

	@Test
	public void checkStatusOfTheNodesMessageWhenNodesAreChecked() {

		String helperString = "";

		int elementId = 0;
		int indexOfElement = 0;

		// Generate random numbers
		Random rn = new Random();
		int randomNumberOfElements = rn.nextInt(12) + 1;
		int[] idsToClick = new int[randomNumberOfElements];

		for (int i = 0; i < randomNumberOfElements; i++) {
			idsToClick[i] = rn.nextInt(12) + 1;
		}

		// Get all checkbox elements
		List<WebElement> checkBoxElements = Browser.driver
				.findElements(By.xpath("//span[@class='k-checkbox-wrapper']"));

		// Check random chechboxes
		for (WebElement checkBox : checkBoxElements) {

			elementId++;
			for (int i = 0; i < idsToClick.length; i++) {
				if (elementId == idsToClick[i]) {
					checkBox.click();
				}
			}
		}

		// Get the index of the checked element
		for (WebElement checkBoxElement : checkBoxElements) {
			if (checkBoxElement.findElement(By.xpath("input[@type='checkbox']")).isSelected()) {

				indexOfElement = checkBoxElements.indexOf(checkBoxElement) + 1;
				helperString += indexOfElement + ",";

			}

		}
		// Create the final status message
		String finalMessage = "IDs of checked nodes: " + helperString.substring(0, helperString.length() - 1);

		// Get the result status message
		WebElement resultStatusMessage = Browser.driver.findElement(By.id("result"));
		String resultStatusMessageText = resultStatusMessage.getText();

		// Verify that the status message display the correct IDs
		assertEquals(finalMessage, resultStatusMessageText);

	}

	@After
	public void tearDown() {
		Browser.quit();
	}

}
