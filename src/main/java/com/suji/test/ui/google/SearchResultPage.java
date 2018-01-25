package com.suji.test.ui.google;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

public class SearchResultPage {
	
	private SelenideElement getFirstResult() {
		return $("#ires").should(visible).$$(".g").first();

	}
	
	public String getFirstResultUrl() {
		
		return getFirstResult().$(".r").$("a").getAttribute("href");
	}
}
