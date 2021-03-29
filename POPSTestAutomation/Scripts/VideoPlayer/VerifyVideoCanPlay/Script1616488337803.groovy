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
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser(GlobalVariable.SourceURL)

WebUI.maximizeWindow()


WebUI.click(findTestObject('SearchPageUI/TEXTBOX_SEARCH'))

CustomKeywords.'commonActions.SearchActions.verifyComicSuggest'(findTestObject('SearchPageUI/COMIC_ITEMS'))

CustomKeywords.'commonActions.SearchActions.verifyVideoSuggest'(findTestObject('SearchPageUI/VIDEO_ITEMS'))

CustomKeywords.'commonActions.SearchActions.searchAnyVideo'(findTestObject('SearchPageUI/TEXTBOX_SEARCH'), 'conan')

CustomKeywords.'commonActions.BaseActions.clickFirstElement'(findTestObject('SearchPageUI/RESULT_ELEMENTS'), 0)

CustomKeywords.'commonActions.BaseActions.clickFirstElement'(findTestObject('SearchPageUI/LIST_TITLE_RESULT'), 0)

CustomKeywords.'commonActions.VideoPlayer.verifyPlayer'( 25)
WebUI.closeBrowser()

