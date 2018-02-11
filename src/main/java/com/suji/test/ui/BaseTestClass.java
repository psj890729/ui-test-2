package com.suji.test.ui;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.codeborne.selenide.WebDriverRunner;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {
		
	@BeforeClass
	public static void setupConfig() throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        WebDriverRunner.setWebDriver(driver);
		//System.setProperty("selenide.browser", "chrome");
		//System.setProperty("webdriver.chrome.driver", "chromedriver");
	}
}
