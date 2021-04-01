package commonActions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.BreakIterator

import org.openqa.selenium.WebElement
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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Comics {

	@Keyword
	def CheckComicRankingDisplay20Items(TestObject object) {
		List<WebElement> listOfComicRankingItems=	WebUiCommonHelper.findWebElements(object, 5)
		Assert.assertEquals(listOfComicRankingItems.size(),20)
	}
	
	@Keyword
	def checkUnlockChapterVisible(TestObject object) {
		Boolean isDisplayed = false		
		List<WebElement> listOfComicRankingItems=	WebUiCommonHelper.findWebElements(object, 5)
			if (listOfComicRankingItems.size()==0) {
				while (isDisplayed== false) {
					BaseActions.ScrollToFooter();
					BaseActions.ClickByJS(findTestObject('ComicPageUI/COMICDETAILPAGEUI/BUTTON_LOAD_MORE'), 3)
					isDisplayed=WebUI.verifyElementVisible(object, FailureHandling.OPTIONAL);
					break;
				}
					
								
			}
	}
}
