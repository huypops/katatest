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

WebUI.callTestCase(findTestCase('POPS App/CommonTestCases/OpenForgotPasswordPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('POPS App UI/ForgotPassword_QuenMatKhau/input_Email'), GlobalVariable.EMAIL_TO_RESET_PASSWORD + 
    '@mailinator.com')

WebUI.click(findTestObject('POPS App UI/ForgotPassword_QuenMatKhau/button_Send'))

WebUI.click(findTestObject('POPS App UI/ResetPasswordPageUI/button_Save'))

WebUI.verifyElementText(findTestObject('POPS App UI/ResetPasswordPageUI/label_ErrorMessage_Code'), 'Nhập thông tin ở đây')

WebUI.verifyElementText(findTestObject('POPS App UI/ResetPasswordPageUI/label_ErrorMessage_NewPassword'), 'Nhập thông tin ở đây')

WebUI.verifyElementText(findTestObject('POPS App UI/ResetPasswordPageUI/label_ErrorMessage_ConfirmPassword'), 'Nhập thông tin ở đây')

