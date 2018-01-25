package com.suji.test.ui;

import org.junit.BeforeClass;

public class BaseTestClass {
	
	@BeforeClass
	public static void setupConfig() throws Exception {
		System.setProperty("selenide.browser", "chrome");
		System.setProperty("webdriver.chrome.driver", "chromedriver");
	}
}
