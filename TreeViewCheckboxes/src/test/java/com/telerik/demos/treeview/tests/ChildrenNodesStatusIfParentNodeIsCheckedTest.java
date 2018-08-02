package com.telerik.demos.treeview.tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.telerik.demos.treeview.utils.*;

public class ChildrenNodesStatusIfParentNodeIsCheckedTest {

	@Before
	public void init() {
		Browser.setUp();
	}

	@Test
	public void testChildrenNodesStatusIfTheParentNodeIsChecked() {

		// Check the root element - "My Documents"
		WebElement RootElement = Browser.driver
				.findElement(By.xpath("//div[@class='k-top k-bot']//span[@class='k-checkbox-wrapper']"));
		RootElement.click();

		// Wait until the root element - "My Documents" is checked
		WebDriverWait wait = new WebDriverWait(Browser.driver, 15);
		assertTrue(wait.until(ExpectedConditions.elementToBeSelected(
				By.xpath("//div[@class='k-top k-bot']//span[@class='k-checkbox-wrapper']/input[@type='checkbox']"))));

		// Verify that the children nodes checkboxes are checked
		List<WebElement> allCheckBoxes = Browser.driver
				.findElements(By.xpath("//span[@class='k-checkbox-wrapper']/input[@type='checkbox']"));
		for (WebElement checkBox : allCheckBoxes) {
			assertTrue("All children checkboxes are checked", checkBox.isSelected());
		}

		// Uncheck the root element - "My Documents"
		RootElement.click();

		// Get all group elements
		List<WebElement> groupElements = Browser.driver.findElements(By.xpath("//ul[@class='k-group']"));
		for (WebElement group : groupElements) {
			if (group != null) {

				List<WebElement> listElements = group.findElements(By.xpath("li[@role='treeitem']"));
				// Check parent node checkboxes
				for (WebElement list : listElements) {
					if (!list.findElements(By.xpath("ul[@class='k-group']/li[@role='treeitem']")).isEmpty()) {
						WebElement checkBox = list.findElement(
								By.xpath("div[starts-with(@class,'k-')]/span[@class='k-checkbox-wrapper']"));
						checkBox.click();
					}
					// Verify that the children nodes checkboxes are checked
					assertTrue("The children nodes checkboxes are checked",
							list.findElement(By
									.xpath("div[starts-with(@class,'k-')]/span[@class='k-checkbox-wrapper']/input[@type='checkbox']"))
									.isSelected());
				}

			}

		}
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
}
