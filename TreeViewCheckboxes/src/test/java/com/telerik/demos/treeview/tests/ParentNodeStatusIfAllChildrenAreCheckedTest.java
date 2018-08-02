package com.telerik.demos.treeview.tests;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.telerik.demos.treeview.utils.*;

public class ParentNodeStatusIfAllChildrenAreCheckedTest {

	@Before
	public void init() {
		Browser.setUp();
	}

	@Test
	public void checkParentNodeStatusIfAllChildrenNodesAreChecked() {

		List<WebElement> groupElements = Browser.driver.findElements(By.xpath("//ul[@class='k-group']"));
		for (WebElement group : groupElements) {
			if (group != null) {

				List<WebElement> listElements = group.findElements(By.xpath("li[@role='treeitem']"));
				// Check child node checkboxes
				for (WebElement list : listElements) {
					if (list != null) {
						WebElement checkBox = list.findElement(
								By.xpath("div[starts-with(@class,'k-')]/span[@class='k-checkbox-wrapper']"));
						checkBox.click();
					}
				}

				// Verify that the parrent checkbox is checked
				assertTrue("The parrent checkbox is checked",
						group.findElement(By
								.xpath("li[@role='treeitem']/div[@class='k-top']/span[@class='k-checkbox-wrapper']/input[@type='checkbox']"))
								.isSelected());

				// Uncheck checkboxes
				for (WebElement list : listElements) {
					if (list != null) {
						WebElement checkBox = list.findElement(
								By.xpath("div[starts-with(@class,'k-')]/span[@class='k-checkbox-wrapper']"));
						checkBox.click();
					}
				}

			}
		}
	}

	@After
	public void tearDown() {
		Browser.quit();
	}
}
