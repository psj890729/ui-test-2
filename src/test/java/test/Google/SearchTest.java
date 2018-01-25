package test.Google;
import static com.codeborne.selenide.Selenide.open;
import static org.fest.assertions.api.Assertions.assertThat; // main one

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.suji.test.ui.BaseTestClass;
import com.suji.test.ui.google.SearchPage;
import com.suji.test.ui.google.SearchResultPage;

public class SearchTest extends BaseTestClass {
	private static SearchPage searchPage;
	private SearchResultPage resultPage;
	
	@BeforeClass
	public static void setup() throws Exception {
		open("https://www.google.co.kr/");
		searchPage = new SearchPage();
	}
	
	@Before
	public void moveToGoogle() throws Exception {
		open("https://www.google.co.kr/");
	}
	
	@Test
	public void search_naver() throws Exception {		
		resultPage = searchPage.search("naver");
		
		assertThat(resultPage.getFirstResultUrl()).contains("www.naver.com");
	}

	@Test
	public void search_nexon() throws Exception {
		resultPage = searchPage.search("nexon");
		
		assertThat(resultPage.getFirstResultUrl()).contains("www.nexon.com");
	}
	
	@Test
	public void search_daum_fail() throws Exception {
		resultPage = searchPage.search("daum");
		
		assertThat(resultPage.getFirstResultUrl()).contains("www.naver.com");
	}
}
