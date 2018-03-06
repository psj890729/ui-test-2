package com.suji.test.ui;

import org.junit.BeforeClass;
import org.junit.Rule;

import com.codeborne.selenide.junit.ScreenShooter;

public class BaseTestClass {
			
	@Rule
	public ScreenShooter screenShooter = ScreenShooter.failedTests();
	
	@BeforeClass
	public static void setupConfig() throws Exception {		
		com.codeborne.selenide.Configuration.browser = "chrome";
		com.codeborne.selenide.Configuration.baseUrl = "https://www.google.co.kr";

		System.out.println("report folder : " + com.codeborne.selenide.Configuration.reportsFolder);
		System.out.println("report url : " + com.codeborne.selenide.Configuration.reportsUrl);
		System.out.println("selenide.browser : " + System.getProperty("selenide.browser"));
	}
	
}
