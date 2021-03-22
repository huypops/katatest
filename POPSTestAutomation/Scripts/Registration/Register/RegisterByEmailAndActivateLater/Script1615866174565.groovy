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
import org.apache.commons.lang.RandomStringUtils as RandomStringUtils

WebUI.openBrowser(GlobalVariable.SourceURL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('HomePageUI/AvatarOnTopMenu'))

WebUI.click(findTestObject('Settings_DropDownMenuUI/SignIn_Link'))

WebUI.click(findTestObject('SignInPageUI/link_RegisterNewAccount'))

String email = 'KatalonWeb_' + RandomStringUtils.randomNumeric(8)

WebUI.sendKeys(findTestObject('SignUpPageUI/input_Email'), email + '@mailinator.com')

WebUI.sendKeys(findTestObject('SignUpPageUI/input_Password'), '123456')

WebUI.click(findTestObject('SignUpPageUI/button_Register'))

WebUI.click(findTestObject('ActivateAccountPageUI/link_ActivateLater'))

WebUI.verifyElementInViewport(findTestObject('HomePageUI/message_ActivateAccount'), 0)

