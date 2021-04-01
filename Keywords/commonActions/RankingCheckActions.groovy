package commonActions



import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class RankingCheckActions {

	@Keyword
	public Boolean rankingCheck() throws IOException {
		WebUI.scrollToElement(findTestObject('Object Repository/ComicPageUI/COMIC_RANKING_SECTION'), 0)
		List<WebElement> Elements = WebUI.findWebElements(findTestObject('Object Repository/ComicPageUI/COMIC_RANKING_SECTION'),0);
		if (Elements.size() == 20) {
			return true;
		}
		return false;
	}

	public Boolean rankingItemsNumber()  {
		return false;
	}
}
