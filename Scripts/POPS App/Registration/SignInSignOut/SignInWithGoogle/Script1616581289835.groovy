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

WebUI.click(findTestObject('POPS App UI/SignIn_DangNhap/button_GoogleLogin'))

parentWindow = WebUI.getWindowIndex()

WebUI.switchToWindowIndex(1)

'Google Account for testing must be created with a new phone number - which has not associated with any account before.'
WebUI.setText(findTestObject('POPS App UI/SignIn_DangNhap/GoogleLoginPageUI/input_GoogleEmail'), GlobalVariable.LOGIN_GOOGLE_EMAIL)

WebUI.click(findTestObject('POPS App UI/SignIn_DangNhap/GoogleLoginPageUI/button_Next'))

WebUI.setText(findTestObject('POPS App UI/SignIn_DangNhap/GoogleLoginPageUI/input_GooglePassword'), GlobalVariable.LOGIN_GOOGLE_PASSWORD)

WebUI.click(findTestObject('POPS App UI/SignIn_DangNhap/GoogleLoginPageUI/button_Final'))

WebUI.switchToWindowIndex(parentWindow)

WebUI.click(findTestObject('POPS App UI/TopMenu/Settings_DropDownMenuUI/icon_AccountAvatar'))

WebUI.click(findTestObject('POPS App UI/TopMenu/Settings_DropDownMenuUI/button_EditAccount'))

WebUI.verifyElementAttributeValue(findTestObject('POPS App UI/SettingsPageUI/Account General/input_Email'), 'value', GlobalVariable.LOGIN_GOOGLE_EMAIL, 
    0)

