import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.util.internal.PathUtil as PathUtil
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

'Get full directory\'s path of android application'
def appPath = PathUtil.relativeToAbsolutePath(GlobalVariable.G_AndroidApp, RunConfiguration.getProjectDir())

LocalDateTime now = LocalDateTime.now()

DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

String nowString = formatter.format(now)

Mobile.startApplication(appPath, true)

Mobile.waitForElementPresent(findTestObject('REGISTRATION/SPLASHPAGE_SIGNUP_BUTTON'), 0)

Mobile.tap(findTestObject('REGISTRATION/SPLASHPAGE_SIGNUP_BUTTON'), 0)

Mobile.setText(findTestObject('REGISTRATION/SIGNUPPAGE_EMAIL_TXTBOX'), ('mail' + nowString) + '@mailinator.com', 0)

Mobile.setText(findTestObject('REGISTRATION/SIGNUPPAGE_PASSWORD_TXTBOX'), '123456', 0)

Mobile.tap(findTestObject('REGISTRATION/SIGNUPPAGE_REGISTER_BUTTON'), 0)

Mobile.tap(findTestObject('REGISTRATION/ACTIVATIONPAGE_CONFIRM_POPUP'), 0)

WebUI.openBrowser('mailinator.com')

Mobile.closeApplication()

