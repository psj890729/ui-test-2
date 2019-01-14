package com.suji.test.ui;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.ScreenShooter;

public class BaseTestClass {
	
	@ClassRule
	public static BrowserWebDriverContainer chrome =
      new BrowserWebDriverContainer()
          .withRecordingMode(BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL, new File("build"))
          .withDesiredCapabilities(DesiredCapabilities.chrome());

	@BeforeClass
	public static void setUp() {
		RemoteWebDriver driver = chrome.getWebDriver();
		WebDriverRunner.setWebDriver(driver);
	}

	@AfterClass
	public static void tearDown() {
		WebDriverRunner.closeWebDriver();
	}
			
	@Rule
	public ScreenShooter screenShooter = ScreenShooter.failedTests();
	
	//@BeforeClass
	public static void setupConfig() throws Exception {		
		com.codeborne.selenide.Configuration.browser = "chrome";
		com.codeborne.selenide.Configuration.baseUrl = "https://www.google.co.kr";

		System.out.println("start testing");
		/*if(System.getProperty("execEnv").compareTo("jenkins") == 0) {
			System.out.println("execenv jenkins");
			
		} else {
			com.codeborne.selenide.Configuration.browser = "chrome";
			System.out.println("not jenkins");
		}*/
		System.out.println("report folder : " + com.codeborne.selenide.Configuration.reportsFolder);
		System.out.println("report url : " + com.codeborne.selenide.Configuration.reportsUrl);
		System.out.println("selenide.browser : " + System.getProperty("selenide.browser"));
	}
	
}
