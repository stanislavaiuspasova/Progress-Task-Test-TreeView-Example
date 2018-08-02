package com.telerik.demos.treeview.tests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.telerik.demos.treeview.utils.*;

public class ParentNodeStatusIfAllChildrenAreUncheckedTest {

	@Before
	public void init() {
		Browser.setUp();
	}

	@Test
	public void checkParentNodeStatusIfAllChildrenNodesAreUnchecked() {
		// Check the root element - "My Documents"
		WebElement RootElement = Browser.driver
				.findElement(By.xpath("//div[@class='k-top k-bot']//span[@class='k-checkbox-wrapper']"));
		RootElement.click();

		// Find all group elements
		List<WebElement> groupElements = Browser.driver.findElements(By.xpath("//ul[@class='k-group']"));
		for (WebElement group : groupElements) {
			if (group != null) {

				// Find all parent elements
				List<WebElement> listElements = group.findElements(By.xpath("li[@role='treeitem']"));

				// Uncheck child node checkboxes
				for (WebElement list : listElements) {
					if (list != null) {
						WebElement checkBox = list.findElement(
								By.xpath("div[starts-with(@class,'k-')]/span[@class='k-checkbox-wrapper']"));
						checkBox.click();
					}
				}
			}
			// Verify that the parrent checkbox is unchecked
			assertFalse("The parrent checkbox is unchecked",
					group.findElement(By
							.xpath("li[@role='treeitem']/div[starts-with(@class,'k-')]/span[@class='k-checkbox-wrapper']/input[@type='checkbox']"))
							.isSelected());
		}
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
}
