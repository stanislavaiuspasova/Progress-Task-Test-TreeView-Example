package com.telerik.demos.treeview.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	public static WebDriver driver;

	public static void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Navigate to :
		// 'https://demos.telerik.com/kendo-ui/treeview/checkboxes'
		driver.get("https://demos.telerik.com/kendo-ui/treeview/checkboxes");
		driver.manage().window().maximize();
	}

	public static void quit() {
		driver.quit();
	}

}
