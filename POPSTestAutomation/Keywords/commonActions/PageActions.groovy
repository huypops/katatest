package commonActions

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.io.filefilter.TrueFileFilter
import org.testng.Assert

import com.jayway.jsonpath.JsonPath
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.sun.org.apache.bcel.internal.generic.RETURN

import internal.GlobalVariable


public class PageActions {

	@Keyword
	def verifyLinksOnPage() {
		def brokenLink = BaseActions.CheckBrokenLink()
		brokenLink.each { k,v->
			println("${k}:${v}")
			Assert.assertTrue(false,"Failed at ${k}:${v}")
		}
		WebUI.refresh()
	}

	@Keyword
	def verifyURLContains(String containsText) {
		Assert.assertTrue(WebUI.getUrl().contains(containsText),"Expected Url contains "+containsText+"but not.")
	}

	@Keyword
	static def openComicPage() {
		WebUI.click(findTestObject('POPS App UI/TopMenu/menu_2_Comics'))
	}

	static def openMyListPage() {
		WebUI.click(findTestObject('POPS App UI/TopMenu/menu_5_Them'))
		WebUI.click(findTestObject('MyListPageUI/BUTTON_MY_LIST_INMOREPAGE'))
	}

	@Keyword
	static String openSeriesPage(TestObject object) {
		try {
			WebUI.waitForElementPresent(object, 5)
			String name  = BaseActions.getAttributeFirstElement(object, 'title');
			BaseActions.clickFirstElement(object,0);
			return	name;
		}catch(NoSuchElementException ignored) {
			println("Not found Series List  : " + ignored)
		}
	
	}

	@Keyword
	static def openVideoPage() {
		WebUI.click(findTestObject('SearchPageUI/TEXTBOX_SEARCH'))
		SearchActions.searchAnyVideo(findTestObject('SearchPageUI/TEXTBOX_SEARCH'), 'conan')
		WebUI.waitForElementPresent(findTestObject('SearchPageUI/RESULT_ELEMENTS'), 1);
		BaseActions.clickFirstElement(findTestObject('SearchPageUI/RESULT_ELEMENTS'), 0);
		BaseActions.clickFirstElement(findTestObject('SearchPageUI/LIST_TITLE_RESULT'), 3);
	}
	
	@Keyword
	public static Boolean checkBrokenImages(TestObject object, String attribute) {
		ArrayList<String> imglinks = BaseActions.getAttributeElements(object,attribute);
		for(int i=0; i<imglinks.size();i++) {
			BaseActions.isLinkOK(imglinks.get(i))	
			return	true;
		}
		return false;
	}
	
	@Keyword
	public static Boolean checkRecommandation(TestObject object) {	
		List<String> list = WebUiCommonHelper.findWebElements(object, 2);
		if (list.size()>0) {
			Assert.assertEquals(list.size(), APIs.getNumberItemInRecommandation())
			return true;
		}
		return false;
	}

	@Keyword
	public static void checkReCommandationCanClickable(TestObject object) {
		try {
			BaseActions.clickFirstElement(object);
		}catch(NoSuchElementException e){
			println(e);
			
		}
	}
	
	@Keyword
	public static Boolean checkAlbumItems(TestObject object) {
		List<String> list = WebUiCommonHelper.findWebElements(object, 2);
		if (list.size()>0) {
			Assert.assertEquals(list.size(), APIs.getAlbumItemsNumber())
		}
		return false;
	}
	@Keyword
	public static void checkAlbumItemsCanClickable(TestObject object) {
		try {
			BaseActions.clickFirstElement(object);
		}catch(NoSuchElementException e){
			println(e);
			
		}
	}
}
