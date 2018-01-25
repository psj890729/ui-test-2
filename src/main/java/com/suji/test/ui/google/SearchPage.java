package com.suji.test.ui.google;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

	public SearchResultPage search(String keyword) {
		$("#lst-ib").should(visible).setValue(keyword);
		$("#lst-ib").should(value(keyword)).pressEnter();
		
		return new SearchResultPage();
	}
}
