package commonActions

import org.apache.commons.io.filefilter.TrueFileFilter
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


public class SearchActions {

	@Keyword
	public static Boolean verifyVideoSuggest(TestObject object) {
		int x = APIs.getVideoSuggestListNumber().size();
		int y = BaseActions.getNumberofElements(object);
		List<String> videoListAPI = APIs.getVideoSuggestListNumber();
		if (x == y) {
			videoListAPI.equals(WebUI.getText(object));
			return true;
		}
		return false;
	}

	@Keyword
	public static Boolean verifyComicSuggest(TestObject object) {
		int x = APIs.getComicSuggestListNumber().size();
		int y = BaseActions.getNumberofElements(object);
		List<String> comicListAPI = APIs.getComicSuggestListNumber();
		if (x == y) {
			comicListAPI.equals(WebUI.getText(object));
			return true;
		}
		return false;
	}

	@Keyword
	public static boolean searchAnyVideo(TestObject object, String videoname){
		WebUI.waitForElementPresent(object, 0);
		WebUI.clearText(object);
		WebUI.setText(object, videoname);
		//		WebUI.sendKeys(object,  Keys.chord(Keys.ENTER));
		WebUI.click(findTestObject('SearchPageUI/ICON_SEARCH_BUTTON'));
		List<WebElement> elements = WebUI.findWebElements(findTestObject('SearchPageUI/RESULT_ELEMENTS'),0);
		String [] splitname = elements.get(0).getText().split(" ");
		String name = splitname[0];
		if(videoname.equalsIgnoreCase(name)) {
			return true;
		}
		return false;
	}

	@Keyword
	public static boolean searchAnyComic(TestObject object, String comicname){
		WebUI.waitForElementPresent(object, 0);
		WebUI.clearText(object);
		WebUI.setText(object, comicname);
		//		WebUI.sendKeys(object,  Keys.chord(Keys.ENTER));
		WebUI.click(findTestObject('SearchPageUI/ICON_SEARCH_BUTTON'));
		List<WebElement> elements = WebUI.findWebElements(findTestObject('SearchPageUI/COMIC_RESULT_ITEMS'),0);
		String [] splitname = elements.get(0).getText().split(" ");
		String name = splitname[0];
		if(comicname.equalsIgnoreCase(name)) {
			return true;
		}
		return false;
	}
}


