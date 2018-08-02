package com.telerik.demos.treeview.tests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.telerik.demos.treeview.utils.*;

public class ExpandParentNodesTest {

	@Before
	public void init() {
		Browser.setUp();

		// Collapse the first parent node "Kendo UI Project"
		WebElement firstParentNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-top']//span[@class='k-icon k-i-collapse']"));
		firstParentNode.click();

		// Collapse the second parent node "New Web Site"
		WebElement secondParentNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-mid']//span[@class='k-icon k-i-collapse']"));
		secondParentNode.click();

		// Collapse the third parent node "Reports"
		WebElement thirdParentNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-bot']//span[@class='k-icon k-i-collapse']"));
		thirdParentNode.click();

		// Collapse the root node "My Documents"
		WebElement RootNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-top k-bot']//span[@class='k-icon k-i-collapse']"));
		RootNode.click();
	}

	@Test
	public void expandParentNodes() {

		// Expand the root node "My Documents"
		WebElement RootNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-top k-bot']//span[@class='k-icon k-i-expand']"));

		WebDriverWait wait = new WebDriverWait(Browser.driver, 10);
		assertTrue(wait.until(ExpectedConditions.elementToBeClickable(RootNode)) != null);
		RootNode.click();

		// Expand the first parent node "Kendo UI Project"
		WebElement firstParentNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-top']//span[@class='k-icon k-i-expand']"));
		assertTrue(wait.until(ExpectedConditions.elementToBeClickable(firstParentNode)) != null);
		firstParentNode.click();

		// Expand the second parent node "New Web Site"
		WebElement secondParentNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-mid']//span[@class='k-icon k-i-expand']"));
		assertTrue(wait.until(ExpectedConditions.elementToBeClickable(secondParentNode)) != null);
		secondParentNode.click();

		// Expand the third parent node "Reports"
		WebElement thirdParentNode = Browser.driver
				.findElement(By.xpath("//div[@class='k-bot']//span[@class='k-icon k-i-expand']"));
		assertTrue(wait.until(ExpectedConditions.elementToBeClickable(thirdParentNode)) != null);
		thirdParentNode.click();

		assertTrue("Root node is collapsed", RootNode.isDisplayed());
		assertTrue("First parent node is collapsed", firstParentNode.isDisplayed());
		assertTrue("Second parent node is collapsed", secondParentNode.isDisplayed());
		assertTrue("Third parent node is collapsed", thirdParentNode.isDisplayed());
	}

	@After
	public void tearDown() {
		Browser.quit();
	}

}
