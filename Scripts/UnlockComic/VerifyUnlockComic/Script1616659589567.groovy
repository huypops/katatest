import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import commonActions.APICMS as APICMS
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.SourceURL)

WebUI.maximizeWindow()

CustomKeywords.'commonActions.SignInActions.SignInWithValidAccount'('huy.thanh@pops.vn', '12345678')

CustomKeywords.'commonActions.SearchActions.searchAnyComic'(findTestObject('SearchPageUI/TEXTBOX_SEARCH'), APICMS.getComicNameCanUnlock())

CustomKeywords.'commonActions.BaseActions.clickFirstElement'(findTestObject('SearchPageUI/COMIC_RESULT_ITEMS'))

WebUI.click(findTestObject('ComicPageUI/COMICDETAILPAGEUI/BUTTON_SORT'))

CustomKeywords.'commonActions.Comics.checkUnlockChapterVisible'(findTestObject('ComicPageUI/COMICDETAILPAGEUI/BUTTON_STAR_ICON'))

CustomKeywords.'commonActions.BaseActions.clickFirstElement'(findTestObject('ComicPageUI/COMICDETAILPAGEUI/BUTTON_STAR_ICON'))

WebUI.click(findTestObject('ComicPageUI/COMICDETAILPAGEUI/BUTTON_BUY_NOW'))

WebUI.closeBrowser()
