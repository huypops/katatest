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

WebUI.sendKeys(findTestObject('POPS App UI/ForgotPassword_QuenMatKhau/input_Email'), GlobalVariable.EMAIL_TO_RESET_PASSWORD_BY_BUTTON + 
    '@mailinator.com')

WebUI.click(findTestObject('POPS App UI/ForgotPassword_QuenMatKhau/button_Send'))

WebUI.verifyElementVisible(findTestObject('POPS App UI/ToastMessage/ToastMessage_Sucessfull'))

WebUI.verifyElementText(findTestObject('POPS App UI/ToastMessage/ToastMessage_Content'), 'Một email đã được gửi đến tài khoản email của bạn! Vui lòng kiểm tra email')

CustomKeywords.'commonActions.Mailinator.OpenMailinatorMail'(GlobalVariable.EMAIL_TO_RESET_PASSWORD_BY_BUTTON, 'Thay đổi mật khẩu tài khoản POPS')

WebUI.scrollToElement(findTestObject('MailinatorPageUI/button_ResetPasswordInEmail'), 0)

WebUI.click(findTestObject('MailinatorPageUI/button_ResetPasswordInEmail'))

WebUI.switchToWindowIndex(1)

WebUI.sendKeys(findTestObject('POPS App UI/ResetPasswordPageUI/input_NewPassword'), '12345678')

WebUI.sendKeys(findTestObject('POPS App UI/ResetPasswordPageUI/input_ConfirmPassword'), '12345678')

WebUI.click(findTestObject('POPS App UI/ResetPasswordPageUI/button_Save'))

WebUI.navigateToUrl(GlobalVariable.SourceURL)

WebUI.click(findTestObject('POPS App UI/TopMenu/button_DangNhap'))

WebUI.sendKeys(findTestObject('POPS App UI/SignIn_DangNhap/input_Email'), GlobalVariable.EMAIL_TO_RESET_PASSWORD_BY_BUTTON + 
    '@mailinator.com')

WebUI.sendKeys(findTestObject('POPS App UI/SignIn_DangNhap/input_Password'), '12345678')

WebUI.click(findTestObject('POPS App UI/SignIn_DangNhap/button_DangNhap'))

WebUI.click(findTestObject('POPS App UI/TopMenu/Settings_DropDownMenuUI/icon_AccountAvatar'))

WebUI.click(findTestObject('POPS App UI/TopMenu/Settings_DropDownMenuUI/button_EditAccount'))

WebUI.verifyElementAttributeValue(findTestObject('POPS App UI/SettingsPageUI/Account General/input_Email'), 'value', GlobalVariable.EMAIL_TO_RESET_PASSWORD_BY_BUTTON + 
    '@mailinator.com', 0)

