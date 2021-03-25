package commonActions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.junit.Assert.assertTrue

import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

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
		WebUI.click(findTestObject('TopMenu/menuComics'))
	}

	static def openMyListPage() {
		WebUI.click(findTestObject('TopMenu/menuThem'))
		WebUI.click(findTestObject('MyListPageUI/BUTTON_MY_LIST_INMOREPAGE'))
	}


	static String openSeriesPage(TestObject object) {
		BaseActions.clickFirstElement(object);
		return BaseActions.getAttributeFirstElement(object, 'title');
	}

	@Keyword
	static def openVideoPage() {
		WebUI.click(findTestObject('SearchPageUI/TEXTBOX_SEARCH'))
		SearchActions.searchAnyVideo(findTestObject('SearchPageUI/TEXTBOX_SEARCH'), 'conan')
		WebUI.waitForElementPresent(findTestObject('SearchPageUI/RESULT_ELEMENTS'), 1);
		BaseActions.clickFirstElement(findTestObject('SearchPageUI/RESULT_ELEMENTS'), 0);
		BaseActions.clickFirstElement(findTestObject('SearchPageUI/LIST_TITLE_RESULT'), 3);

	}
}
