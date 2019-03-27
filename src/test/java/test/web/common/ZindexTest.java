package test.web.common;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.openqa.selenium.By;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.suji.test.ui.util.ZindexSeletor;


/*
 * TODO
 * headless 처리
 * assert 변경 
 */

public class ZindexTest {
	
	@Test
	public void nexonMainPageTest() throws Exception {
		String url = "https://www.nexon.com";
		SelenideElement visibleElement = $(By.linkText("메이플스토리"));
		
		ElementsCollection elements = ZindexSeletor.getAllZindexElements(url, visibleElement);
		
		assertThat(getFailCount(elements, 9999999), equalTo(0));
	}
	
	@Test
	public void a1MainPageTest() throws Exception {
		String url = "https://a1.nexon.com/main/index";
		SelenideElement visibleElement = $(".midArea");
		
		ElementsCollection elements = ZindexSeletor.getAllZindexElements(url, visibleElement);
		
		assertThat(getFailCount(elements, 9999999), equalTo(0));
		
	}
	
	private int getFailCount(ElementsCollection elements, int no) {
		int failCount = 0;
		for(SelenideElement element : elements) {
			if(ZindexSeletor.getZindexValue(element) >= no) {
				failCount = failCount+1;
			}
		}
		return failCount;
	}
}
