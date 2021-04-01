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

WebUI.click(findTestObject('POPS App UI/TopMenu/button_DangNhap'))

WebUI.callTestCase(findTestCase('POPS App/CommonTestCases/SignInWithAccount'), [('Email') : 'shally.h.88@gmail.com', ('Password') : '1234567890'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('POPS App UI/TopMenu/button_DangNhap'), 3)

WebUI.click(findTestObject('POPS App UI/TopMenu/icon_AccountAvatar'))

CustomKeywords.'commonActions.BaseActions.ClickByJS'(findTestObject('POPS App UI/TopMenu/Settings_DropDownMenuUI/Link_SignOut'))

WebUI.click(findTestObject('POPS App UI/SignIn_DangNhap/POPS_Logo'))

WebUI.verifyElementInViewport(findTestObject('POPS App UI/TopMenu/button_DangNhap'), 0)

