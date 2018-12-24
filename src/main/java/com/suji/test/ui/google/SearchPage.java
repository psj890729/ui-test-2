package com.suji.test.ui.google;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

	public SearchResultPage search(String keyword) {
		$("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input").should(visible).setValue(keyword);
		$("#tsf > div:nth-child(2) > div > div.RNNXgb > div > div.a4bIc > input").should(value(keyword)).pressEnter();
		
		return new SearchResultPage();
	}
}
