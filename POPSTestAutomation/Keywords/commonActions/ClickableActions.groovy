package commonActions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.testng.Assert;

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.StringEscapeUtils

public class ClickableActions {

	
	@Keyword
	public boolean clickingOnGenre(TestObject object){
		String seriesname=PageActions.openSeriesPage(findTestObject('SeriesDetailPageUI/SERIES_LIST_ITEMS'));
		String genrename = BaseActions.getTextFirstElement(object, 0).trim();
		BaseActions.clickFirstElement(object, 0)
		Assert.assertEquals(genrename, getGenreTitlePage())
	}

	public String getGenreTitlePage(){
		String title = WebUI.getText(findTestObject('Object Repository/SeriesDetailPageUI/GENRE_HEADER_TITLE'));
		return title.trim();
	}

	@Keyword
	public void  addToMyList() {
		WebElement element = WebUI.findWebElement(findTestObject('Object Repository/MyListPageUI/ADD_TO_LIST'),0);
		if (element != null) {
			BaseActions.clickUsingJS(findTestObject('Object Repository/MyListPageUI/ADD_TO_LIST'),2);
			String text  = WebUI.getText(findTestObject('Object Repository/MyListPageUI/TEXT_SAVED_VIDEO'));
			Assert.assertTrue(text.trim().contains("Đã"));
		}
		String videoname = WebUI.getText(findTestObject('Object Repository/VideoDetailPageUI/CURRENT_VIDEO_TITLE_TEXT'));
		PageActions.openMyListPage();
		WebUI.waitForElementVisible(findTestObject('Object Repository/MyListPageUI/TEXT_TITLE_NAME'),2)
		String mylistvideoname = WebUI.getText(findTestObject('Object Repository/MyListPageUI/TEXT_TITLE_NAME'));
		Assert.assertEquals(videoname,mylistvideoname);
	}
}
