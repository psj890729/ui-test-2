package com.suji.test.ui.util;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

/*
 * TODO
 * 전체 엘리먼트의 z-index 가져오기
 */

public class ZindexSeletor {
	
	public static ElementsCollection getAllZindexElements(String url, SelenideElement visibleElement) {
		
		open(url);
		
		System.out.println("url : " + WebDriverRunner.url());
		visibleElement.shouldBe(visible);
		
		ElementsCollection allZindexElements = $$("*[style*='z-index']");
		System.out.println("zindex elements size " + allZindexElements.size());
		System.out.println("elements to string : " + allZindexElements);
		
		return allZindexElements;
	}

	public static int getZindexValue(SelenideElement element) {
		
		System.out.println("element style : " + element.attr("style"));
		
		int value = 0 ;
		String style = element.attr("style");
		style = style.trim();
		String[ ] styleList = style.split(";");
		for(String op : styleList) {
			if(op.contains("z-index")) {
				value = Integer.parseInt(op.split(":")[1].trim());
			}
		}	
		
		return value;
	}
		
}
