package com.telerik.demos.treeview.tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.telerik.demos.treeview.utils.*;

public class ChildrenNodesStatusIfParentNodeIsUncheckedTest {

	@Before
	public void init() {
		Browser.setUp();
	}

	@Test
	public void testChildrenNodesStatusIfTheParentNodeIsUnchecked() {

		// Check the root element - "My Documents"
		WebElement RootElement = Browser.driver
				.findElement(By.xpath("//div[@class='k-top k-bot']//span[@class='k-checkbox-wrapper']"));
		RootElement.click();

		// Get all group elements
		List<WebElement> groupElements = Browser.driver.findElements(By.xpath("//ul[@class='k-group']"));
		for (WebElement group : groupElements) {
			if (group != null) {

				List<WebElement> listElements = group.findElements(By.xpath("li[@role='treeitem']"));
				// Uncheck parent node checkboxes
				for (WebElement list : listElements) {
					if (!list.findElements(By.xpath("ul[@class='k-group']/li[@role='treeitem']")).isEmpty()) {
						WebElement checkBox = list.findElement(
								By.xpath("div[starts-with(@class,'k-')]/span[@class='k-checkbox-wrapper']"));

						checkBox.click();
					}
					// Verify that the children nodes checkboxes are unchecked
					assertFalse("The children nodes checkboxes are unchecked",
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
